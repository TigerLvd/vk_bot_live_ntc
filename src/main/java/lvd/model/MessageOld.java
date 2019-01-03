package lvd.model;

public class MessageOld extends Message {

    private String out;

    private Integer user_id;

    private String read_state;

    private String title;

    private String body;

    private Integer group_id;

    public MessageOld() {
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getRead_state() {
        return read_state;
    }

    public void setRead_state(String read_state) {
        this.read_state = read_state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }
    //    @Override
//    public String toString() {
//        return super.toString() + ;
//    }
}