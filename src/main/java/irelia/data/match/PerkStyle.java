package irelia.data.match;

import java.util.List;

public class PerkStyle {

    private String description;
    private List<PerkStyleSelection> selections;
    private int style;
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<PerkStyleSelection> getSelections() {
        return selections;
    }
    public void setSelections(List<PerkStyleSelection> selections) {
        this.selections = selections;
    }
    public int getStyle() {
        return style;
    }
    public void setStyle(int style) {
        this.style = style;
    }

    
    
}