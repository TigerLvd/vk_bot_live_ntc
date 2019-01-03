package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Button {

    @JsonProperty("action")
    private ButtonAction action = new ButtonAction();

    @JsonProperty("color")
    private String color;

    public Button() {
    }

    public ButtonAction getAction() {
        return action;
    }

    public void setAction(ButtonAction action) {
        this.action = action;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "action=" + action.toString() + "color=" + getColor() + "\n";
    }
}