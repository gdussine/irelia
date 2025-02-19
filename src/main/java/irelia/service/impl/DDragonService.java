package irelia.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import irelia.data.ddragon.ChampionInfo;
import irelia.data.ddragon.Champions;
import irelia.data.ddragon.DDragon;
import irelia.data.ddragon.DDragonObject;
import irelia.data.ddragon.IconInfo;
import irelia.data.ddragon.ItemInfo;
import irelia.request.core.RiotRequest;
import irelia.service.RiotService;

public class DDragonService extends RiotService {

	private final static String CHAMPIONS_URI = "cdn/%s/data/%s/champion.json";
	private final static String ICONS_URI = "cdn/%s/data/%s/profileicon.json";
	private final static String ITEMS_URI = "cdn/%s/data/%s/item.json";
	private final static String ICON_URI = "cdn/%s/img/profileicon/%s";
	private final static String CHAMPION_ICON_URI = "cdn/%s/img/champion/%s";
	private final static String CHAMPION_SPASH_URI = "cdn/img/champion/splash/%s_%s.jpg";
	private final static String LANGUAGES_URI = "cdn/languages.json";
	private final static String VERSION_URI = "api/versions.json";

	private DDragon cachedDDragon;

	private DDragon getCachedDDragon() {
		if (cachedDDragon == null)
			cachedDDragon = getDDragon().join();
		return cachedDDragon;
	}

	private void setCachedDDragon(DDragon cachedDDragon) {
		this.cachedDDragon = cachedDDragon;
	}

	@Override
	public void start() {
		DDragon dragon = this.getDDragon().join();
		this.log.debug("{} started in version {}.", getClass().getSimpleName(), dragon.getVersion());
	}

	public void clearCahche() {
		cachedDDragon = null;
	}

	public CompletableFuture<InputStream> getProfileIcon(Integer iconId) {
		String fullname = getCachedDDragon().getIcon(iconId).getImage().getFull();
		TypeReference<InputStream> type = new TypeReference<InputStream>() {
		};
		RiotRequest<InputStream> request = this.createDDragonRequest(type, ICON_URI, getCachedDDragon().getVersion(),
				fullname);
		return getInputStreamAsync(request);
	}

	public CompletableFuture<InputStream> getChampionIcon(Champions champion) {
		String fullname = getCachedDDragon().getChampion(champion).getImage().getFull();
		TypeReference<InputStream> type = new TypeReference<InputStream>() {
		};
		RiotRequest<InputStream> request = this.createDDragonRequest(type, CHAMPION_ICON_URI,
				getCachedDDragon().getVersion(), fullname);
		return getInputStreamAsync(request);
	}

	public CompletableFuture<InputStream> getChampionSplash(Champions champion, int skinId) {
		String fullname = getCachedDDragon().getChampion(champion).getId();
		TypeReference<InputStream> type = new TypeReference<InputStream>() {
		};
		RiotRequest<InputStream> request = this.createDDragonRequest(type, CHAMPION_SPASH_URI, fullname, skinId);
		return getInputStreamAsync(request);
	}

	public CompletableFuture<DDragon> getDDragon() {
		if (cachedDDragon != null) {
			CompletableFuture<DDragon> futureDDragon = new CompletableFuture<DDragon>();
			futureDDragon.complete(cachedDDragon);
			return futureDDragon;
		}
		TypeReference<List<String>> typeList = new TypeReference<List<String>>() {
		};
		TypeReference<DDragonObject<ChampionInfo>> typeChampion = new TypeReference<DDragonObject<ChampionInfo>>() {
		};
		TypeReference<DDragonObject<IconInfo>> typeIcon = new TypeReference<DDragonObject<IconInfo>>() {
		};
		TypeReference<DDragonObject<ItemInfo>> typeItem = new TypeReference<DDragonObject<ItemInfo>>() {
		};
		RiotRequest<List<String>> requestLanguage = this.createDDragonRequest(typeList, LANGUAGES_URI);
		RiotRequest<List<String>> requestVersion = this.createDDragonRequest(typeList, VERSION_URI);
		return getAsync(requestLanguage).thenApplyAsync(list -> {
			DDragon result = new DDragon();
			String ddragonLang = list.stream().filter(x -> x.contains(irelia.getLang())).findAny()
					.orElse("en_US");
			result.setLang(ddragonLang);
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
			RiotRequest<DDragonObject<IconInfo>> request = this.createDDragonRequest(typeIcon, ICONS_URI,
					dragon.getVersion(),
					dragon.getLang());
			return getAsync(request).thenApplyAsync(obj -> {
				dragon.setIcons(obj.getData());
				return dragon;
			});
		}).thenComposeAsync(dragon -> {
			RiotRequest<DDragonObject<ItemInfo>> request = this.createDDragonRequest(typeItem,ITEMS_URI,dragon.getVersion(), dragon.getLang());
			return getAsync(request).thenApplyAsync(obj ->{
				dragon.setItems(obj.getData());
				return dragon;
			});
		}).thenApply(dragon -> {
			this.setCachedDDragon(dragon);
			return dragon;
		});
	}
}
