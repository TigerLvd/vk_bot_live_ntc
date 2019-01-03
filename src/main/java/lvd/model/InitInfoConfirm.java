package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitInfoConfirm extends InitInfo {

    @JsonProperty("secret")
    private String secret;

    public InitInfoConfirm() {
        super();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}