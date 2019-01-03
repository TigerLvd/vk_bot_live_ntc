package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

public class InitInfoMessage extends InitInfo {
    @JsonProperty("object")
    private JsonObject object;

    public InitInfoMessage() {
        super();
    }

    public JsonObject getObject() {
        return object;
    }

    public void setObject(JsonObject object) {
        this.object = object;
    }
}