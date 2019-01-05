package entities.actions.parameters;

public class PanoramaParameters extends TotodileActionParameters{

    private String url;
    private Integer severity;
    private String agent;
    private String alertGroup;
    private String node;
    private Integer expireTime;
    private String link;
    private String summary;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAlertGroup() {
        return alertGroup;
    }

    public void setAlertGroup(String alertGroup) {
        this.alertGroup = alertGroup;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
