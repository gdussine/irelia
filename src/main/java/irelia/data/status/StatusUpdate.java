package irelia.data.status;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusUpdate {

    private int id;
    private String author;
    private boolean publish;
    @JsonProperty("publish_locations")
    private List<String> publishLocations;
    private List<StatusContent> translations;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public List<String> getPublishLocations() {
        return publishLocations;
    }

    public void setPublishLocations(List<String> publishLocations) {
        this.publishLocations = publishLocations;
    }

    public List<StatusContent> getTranslations() {
        return translations;
    }

    public void setTranslations(List<StatusContent> translations) {
        this.translations = translations;
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

}
