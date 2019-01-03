package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ButtonAction {

    @JsonProperty("type")
    private String type;

    @JsonProperty("payload")
    private String payload;

    @JsonProperty("label")
    private String label;

    public ButtonAction(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "type=" + getType() + "\n" + "payload=" + getPayload() + "\n" + "label=" + getLabel() + "\n";
    }
}