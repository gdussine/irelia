package irelia.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feats {

    @JsonProperty("EPIC_MONSTER_KILL")
    private Feat epicMonsterKill;


    @JsonProperty("FIRST_BLOOD")
    private Feat firstBlood;

    @JsonProperty("FIRST_TURRET")
    private Feat firstTurret;

    public Feat getEpicMonsterKill() {
        return epicMonsterKill;
    }

    public void setEpicMonsterKill(Feat epicMonsterKill) {
        this.epicMonsterKill = epicMonsterKill;
    }

    public Feat getFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood(Feat firstBlood) {
        this.firstBlood = firstBlood;
    }

    public Feat getFirstTurret() {
        return firstTurret;
    }

    public void setFirstTurret(Feat firstTurret) {
        this.firstTurret = firstTurret;
    }

    
}
