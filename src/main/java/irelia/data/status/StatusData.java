package irelia.data.status;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusData {
    private int id;

    @JsonProperty("maintenance_status")
    private String maintenanceStatus;
    @JsonProperty("incident_severity")
    private String incidentSeverity;

    private List<StatusContent> titles;

    private List<StatusUpdate> updates;

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("archive_at")
    private String archiveAt;

    private List<String> platforms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getIncidentSeverity() {
        return incidentSeverity;
    }

    public void setIncidentSeverity(String incidentSeverity) {
        this.incidentSeverity = incidentSeverity;
    }

    public List<StatusContent> getTitles() {
        return titles;
    }

    public void setTitles(List<StatusContent> titles) {
        this.titles = titles;
    }

    public List<StatusUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(List<StatusUpdate> updates) {
        this.updates = updates;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getArchiveAt() {
        return archiveAt;
    }

    public void setArchiveAt(String archiveAt) {
        this.archiveAt = archiveAt;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    
    
}
