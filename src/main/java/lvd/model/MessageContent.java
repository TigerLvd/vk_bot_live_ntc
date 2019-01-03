package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageContent {

    @JsonProperty("action")
    private MessageContentAction action = MessageContentAction.ERROR;

    @JsonProperty("properties")
    private Pair[] properties;

    public MessageContent() {
    }

    public MessageContentAction getAction() {
        return action;
    }

    public void setAction(MessageContentAction action) {
        this.action = action;
    }

    public Pair[] getProperties() {
        return properties;
    }

    public void setProperties(Pair[] properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        if (null != properties && properties.length > 0) {
            StringBuilder str = new StringBuilder();
            for (Pair pair : properties) {
                str.append("name=");
                str.append(pair.getName());
                str.append(", value=<");
                str.append(pair.getValue());
                str.append(">;\n");
            }

            return "action=" + action + ",\n"
                    + "properties:\n" + str.toString();
        } else {
            return "action=" + action + ",\n"
                    + (properties == null ? "properties is NULL" : "properties.SIZE=" + properties.length);
        }
    }
}