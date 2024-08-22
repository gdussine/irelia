package irelia.core.service;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.core.Irelia;
import irelia.core.request.RiotRequest;
import irelia.data.dragon.ChampionInfo;
import irelia.data.dragon.Champions;
import irelia.data.dragon.DDragon;
import irelia.data.dragon.DDragonObject;
import irelia.data.dragon.IconInfo;

public class DDragonService extends RiotService {

	private final static String CHAMPIONS_URI = "cdn/%s/data/%s/champion.json";
	private final static String ICONS_URI = "cdn/%s/data/%s/profileicon.json";
	private final static String IMG_URI = "cdn/%s/img/%s/%s";
	private final static String LANGUAGES_URI = "cdn/languages.json";
	private final static String VERSION_URI = "api/versions.json";

	private DDragon cachedDDragon;

	public DDragonService(Irelia riot) {
		super(riot);
	}

	private DDragon getCachedDDragon() {
		if (cachedDDragon == null)
			cachedDDragon = getDDragon().join();
		return cachedDDragon;
	}

	private void setCachedDDragon(DDragon cachedDDragon) {
		this.cachedDDragon = cachedDDragon;
	}

	public CompletableFuture<InputStream> getProfileIcon(String fullname) {
		TypeReference<InputStream> type = new TypeReference<InputStream>() {};
		RiotRequest<InputStream> request = this.createDDragonRequest(type, IMG_URI, getCachedDDragon().getVersion(),
				"profileicon",
				fullname);
		return getInputStreamAsync(request);
	}

	public CompletableFuture<InputStream> getChampionIcon(Champions champion) {
		String fullname = getCachedDDragon().getChampion(champion).getImage().getFull();
		TypeReference<InputStream> type = new TypeReference<InputStream>() {};
		RiotRequest<InputStream> request = this.createDDragonRequest(type, IMG_URI, getCachedDDragon().getVersion(),
				"champion", fullname);
		return getInputStreamAsync(request);
	}

	public CompletableFuture<DDragon> getDDragon() {
		if (cachedDDragon != null) {
			CompletableFuture<DDragon> futureDDragon = new CompletableFuture<DDragon>();
			futureDDragon.complete(cachedDDragon);
			return futureDDragon;
		}
		TypeReference<List<String>> typeList = new TypeReference<List<String>>() {};
		TypeReference<DDragonObject<ChampionInfo>> typeChampion = new TypeReference<DDragonObject<ChampionInfo>>() {}; 
		TypeReference<DDragonObject<IconInfo>> typeIcon = new TypeReference<DDragonObject<IconInfo>>() {};
		
		RiotRequest<List<String>> requestLanguage = this.createDDragonRequest(typeList, LANGUAGES_URI);
		RiotRequest<List<String>> requestVersion = this.createDDragonRequest(typeList, VERSION_URI);
		return getAsync(requestLanguage).thenApplyAsync(list -> {
			DDragon result = new DDragon();
			result.setLang(this.irelia.getLocale().toString());
			return result;
		}).thenComposeAsync(result -> {
			return getAsync(requestVersion).thenApplyAsync(list -> {
				String version = list.get(0);
				result.setVersion(version);
				return result;
			});
		}).thenComposeAsync(dragon -> {
			RiotRequest<DDragonObject<ChampionInfo>> request = this.createDDragonRequest(typeChampion, CHAMPIONS_URI,
					dragon.getVersion(), dragon.getLang());
			return getAsync(request).thenApplyAsync(obj -> {
				dragon.setChampions(obj.getData());
				return dragon;
			});
		}).thenComposeAsync(dragon -> {
			RiotRequest<DDragonObject<IconInfo>> request = this.createDDragonRequest(typeIcon, ICONS_URI, dragon.getVersion(),
					dragon.getLang());
			return getAsync(request).thenApplyAsync(obj -> {
				dragon.setIcons(obj.getData());
				return dragon;
			});
		}).thenApply(dragon -> {
			this.setCachedDDragon(dragon);
			return dragon;
		});
	}
}
