package irelia.data.match;

import java.util.List;

public class Metadata {
    
    private String dataVersion, matchId;
    private List<String> participants;

    public String getDataVersion() {
        return dataVersion;
    }
    public String getMatchId() {
        return matchId;
    }
    public List<String> getParticipants() {
        return participants;
    }
    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    
    
    
    
}
