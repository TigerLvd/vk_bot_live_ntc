package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Keyboard {

    @JsonProperty("one_time")
    private Boolean one_time = false;

    @JsonProperty("buttons")
    private Button[][] buttons = new Button[2][2];

    public Keyboard() {
    }

    public Keyboard(Boolean oneTime, Button[]... buttons) {
        this.one_time = oneTime;
        this.buttons = buttons;
    }

    public Keyboard(Integer x, Label action) {
        if (x == 4) {
            fill4Buttons();
        }
        if (x == 6) {
            fill6Buttons(action);
        }
        if (x == 7) {
            fill7Buttons(action);
        }
    }

    private void fill7Buttons(Label action) {
        buttons = new Button[3][];

        buttons[0] = new Button[3];
        buttons[1] = new Button[3];
        buttons[2] = new Button[1];

        buttons[0][0] = new Button();
        buttons[0][0].setAction(new ButtonAction());
        buttons[0][0].getAction().setType("text");
        buttons[0][0].getAction().setPayload("{\"button\": \"1\"}");
        buttons[0][0].getAction().setLabel(Label.TIME_TABLE.getTitle());
        buttons[0][0].setColor(Label.TIME_TABLE.equals(action) ? "primary" : "default");

        buttons[0][1] = new Button();
        buttons[0][1].getAction().setType("text");
        buttons[0][1].getAction().setPayload("{\"button\": \"2\"}");
        buttons[0][1].getAction().setLabel(Label.MASTER_CLASSES.getTitle());
        buttons[0][1].setColor(Label.MASTER_CLASSES.equals(action) ? "primary" : "default");

        buttons[0][2] = new Button();
        buttons[0][2].getAction().setType("text");
        buttons[0][2].getAction().setPayload("{\"button\": \"3\"}");
        buttons[0][2].getAction().setLabel(Label.SPEAKERS.getTitle());
        buttons[0][2].setColor(Label.SPEAKERS.equals(action) ? "primary" : "default");

        buttons[1][0] = new Button();
        buttons[1][0].getAction().setType("text");
        buttons[1][0].getAction().setPayload("{\"button\": \"4\"}");
        buttons[1][0].getAction().setLabel(Label.CONTACTS.getTitle());
        buttons[1][0].setColor(Label.CONTACTS.equals(action) ? "primary" : "default");

        buttons[1][1] = new Button();
        buttons[1][1].getAction().setType("text");
        buttons[1][1].getAction().setPayload("{\"button\": \"5\"}");
        buttons[1][1].getAction().setLabel(Label.NEWS.getTitle());
        buttons[1][1].setColor(Label.NEWS.equals(action) ? "primary" : "default");

        buttons[1][2] = new Button();
        buttons[1][2].getAction().setType("text");
        buttons[1][2].getAction().setPayload("{\"button\": \"6\"}");
        buttons[1][2].getAction().setLabel(Label.FOOD.getTitle());
        buttons[1][2].setColor(Label.FOOD.equals(action) ? "primary" : "default");//primary/default

        buttons[2][1] = new Button();
        buttons[2][1].getAction().setType("text");
        buttons[2][1].getAction().setPayload("{\"button\": \"7\"}");
        buttons[2][1].getAction().setLabel(Label.COMPETITIONS.getTitle());
        buttons[2][1].setColor(Label.COMPETITIONS.equals(action) ? "primary" : "default");//primary/default
    }

    private void fill6Buttons(Label action) {
        buttons = new Button[2][3];

        buttons[0][0] = new Button();
        buttons[0][0].setAction(new ButtonAction());
        buttons[0][0].getAction().setType("text");
        buttons[0][0].getAction().setPayload("{\"button\": \"1\"}");
        buttons[0][0].getAction().setLabel(Label.TIME_TABLE.getTitle());
        buttons[0][0].setColor(Label.TIME_TABLE.equals(action) ? "primary" : "default");

        buttons[0][1] = new Button();
        buttons[0][1].getAction().setType("text");
        buttons[0][1].getAction().setPayload("{\"button\": \"2\"}");
        buttons[0][1].getAction().setLabel(Label.MASTER_CLASSES.getTitle());
        buttons[0][1].setColor(Label.MASTER_CLASSES.equals(action) ? "primary" : "default");

        buttons[0][2] = new Button();
        buttons[0][2].getAction().setType("text");
        buttons[0][2].getAction().setPayload("{\"button\": \"3\"}");
        buttons[0][2].getAction().setLabel(Label.SPEAKERS.getTitle());
        buttons[0][2].setColor(Label.SPEAKERS.equals(action) ? "primary" : "default");

        buttons[1][0] = new Button();
        buttons[1][0].getAction().setType("text");
        buttons[1][0].getAction().setPayload("{\"button\": \"4\"}");
        buttons[1][0].getAction().setLabel(Label.CONTACTS.getTitle());
        buttons[1][0].setColor(Label.CONTACTS.equals(action) ? "primary" : "default");

        buttons[1][1] = new Button();
        buttons[1][1].getAction().setType("text");
        buttons[1][1].getAction().setPayload("{\"button\": \"5\"}");
        buttons[1][1].getAction().setLabel(Label.NEWS.getTitle());
        buttons[1][1].setColor(Label.NEWS.equals(action) ? "primary" : "default");

        buttons[1][2] = new Button();
        buttons[1][2].getAction().setType("text");
        buttons[1][2].getAction().setPayload("{\"button\": \"6\"}");
        buttons[1][2].getAction().setLabel(Label.FOOD.getTitle());
        buttons[1][2].setColor(Label.FOOD.equals(action) ? "primary" : "default");//primary/default
    }

    private void fill4Buttons() {
        buttons = new Button[2][2];

        buttons[0][0] = new Button();
        buttons[0][0].setAction(new ButtonAction());
        buttons[0][0].getAction().setType("text");
        buttons[0][0].getAction().setPayload("{\"button\": \"1\"}");
        buttons[0][0].getAction().setLabel("Red");
        buttons[0][0].setColor("negative");

        buttons[0][1] = new Button();
        buttons[0][1].getAction().setType("text");
        buttons[0][1].getAction().setPayload("{\"button\": \"2\"}");
        buttons[0][1].getAction().setLabel("Green");
        buttons[0][1].setColor("positive");

        buttons[1][0] = new Button();
        buttons[1][0].getAction().setType("text");
        buttons[1][0].getAction().setPayload("{\"button\": \"3\"}");
        buttons[1][0].getAction().setLabel("White");
        buttons[1][0].setColor("default");

        buttons[1][1] = new Button();
        buttons[1][1].getAction().setType("text");
        buttons[1][1].getAction().setPayload("{\"button\": \"4\"}");
        buttons[1][1].getAction().setLabel("Blue");
        buttons[1][1].setColor("primary");
    }

    public Boolean getOne_time() {
        return one_time;
    }

    public void setOne_time(Boolean one_time) {
        this.one_time = one_time;
    }

    public Button[][] getButtons() {
        return buttons;
    }

    public void setButtons(Button[][] buttons) {
        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return "one_time=" + (Boolean.TRUE.equals(one_time) ? "true" : "false") + "\n" + "size of buttons=" + getButtons().length;
    }
}