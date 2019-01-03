package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class InitInfo {

    @JsonProperty("type")
    protected String type;

    @JsonProperty("group_id")
    protected String group_id;

    public InitInfo() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }
}