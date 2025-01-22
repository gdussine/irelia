package irelia.data.status;

import java.util.List;

public class StatusPlatform {

    private String id, name;
    private List<String> locales;
    private List<StatusData> maintenances;
    private List<StatusData> incidents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocales() {
        return locales;
    }

    public void setLocales(List<String> locales) {
        this.locales = locales;
    }

    public List<StatusData> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<StatusData> maintenances) {
        this.maintenances = maintenances;
    }

    public List<StatusData> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<StatusData> incidents) {
        this.incidents = incidents;
    }

}
