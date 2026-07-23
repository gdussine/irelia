package irelia.data.champion;

import java.util.List;

public class ChampionRotation {

    private int maxNewPlayerLevel = 11;

    private List<Integer> newplayer;
    private List<Integer> sr;

    public int getMaxNewPlayerLevel() {
        return maxNewPlayerLevel;
    }
    public void setMaxNewPlayerLevel(int maxNewPlayerLevel) {
        this.maxNewPlayerLevel = maxNewPlayerLevel;
    }
    public List<Integer> getNewplayer() {
        return newplayer;
    }
    public void setNewplayer(List<Integer> newplayer) {
        this.newplayer = newplayer;
    }
    public List<Integer> getSr() {
        return sr;
    }
    public void setSr(List<Integer> sr) {
        this.sr = sr;
    }
    
    
    

}
