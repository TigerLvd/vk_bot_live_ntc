package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pair {
    @JsonProperty("name")
    String name;

    @JsonProperty("value")
    String value;

    public Pair() {
    }

    public Pair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}