package irelia.data.account;

public record AccountDTO(
                String puuid,
                String gameName,
                String tagLine) {
                        
	public String getRiotId() {
		return gameName + "#" + tagLine;
	}
}
