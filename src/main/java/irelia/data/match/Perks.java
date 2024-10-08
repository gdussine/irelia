package irelia.data.match;

import java.util.List;

public class Perks {
    private PerkStats statPerks;
    private List<PerkStyle> styles;
    public PerkStats getStatPerks() {
        return statPerks;
    }
    public void setStatPerks(PerkStats statPerks) {
        this.statPerks = statPerks;
    }
    public List<PerkStyle> getStyles() {
        return styles;
    }
    public void setStyles(List<PerkStyle> styles) {
        this.styles = styles;
    }
}
