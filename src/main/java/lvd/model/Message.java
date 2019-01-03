package lvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;
import com.vk.api.sdk.objects.base.Geo;

import java.util.List;

public class Message {
    // идентификатор сообщения
    @JsonProperty("id")
    private Integer id;

    // время отправки в Unixtime
    @JsonProperty("date")
    private Integer date;

    // идентификатор назначения
    @JsonProperty("peer_id")
    private Integer peer_id;

    // идентификатор отправителя
    @JsonProperty("from_id")
    private Integer from_id;

    //текст сообщения
    @JsonProperty("text")
    private String text;

    // идентификатор, используемый при отправке сообщения. Возвращается только для исходящих сообщений
    @JsonProperty("random_id")
    private Integer random_id;

    // произвольный параметр для работы с источниками переходов
    @JsonProperty("ref")
    private String ref;

    // произвольный параметр для работы с источниками переходов
    @JsonProperty("ref_source")
    private String ref_source;

    // медиавложения сообщения (фотографии, ссылки и т.п.)
    @JsonProperty("attachments")
    private List attachments;

    // true, если сообщение помечено как важное
    @JsonProperty("important")
    private boolean important;

    // информация о местоположении
    @JsonProperty("geo")
    private Geo geo;

    // сервисное поле для сообщений ботам
    @JsonProperty("payload")
    private String payload;

    // массив пересланных сообщений
    @JsonProperty("replay_message")
    private List<Message> replay_message;

    // сообщение, в ответ на которое отправлено текущее
    @JsonProperty("reply_message")
    private Message reply_message;

    @JsonProperty("keyboard")
    private JsonObject keyboard;

    // информация о сервисном действии с чатом
    private Label action;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getPeer_id() {
        return peer_id;
    }

    public void setPeer_id(Integer peer_id) {
        this.peer_id = peer_id;
    }

    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRandom_id() {
        return random_id;
    }

    public void setRandom_id(Integer random_id) {
        this.random_id = random_id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRef_source() {
        return ref_source;
    }

    public void setRef_source(String ref_source) {
        this.ref_source = ref_source;
    }

    public List getAttachments() {
        return attachments;
    }

    public void setAttachments(List attachments) {
        this.attachments = attachments;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public List<Message> getReplay_message() {
        return replay_message;
    }

    public void setReplay_message(List<Message> replay_message) {
        this.replay_message = replay_message;
    }

    public JsonObject getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(JsonObject keyboard) {
        this.keyboard = keyboard;
    }

    public Label getAction() {
        return action;
    }

    public void setAction(Label action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "id=" + getId() + "\n"
                + "date=" + getDate() + "\n"
                + "peer_id=" + getPeer_id() + "\n"
                + "from_id=" + getFrom_id() + "\n"
                + "text=" + getText() + "\n"
                + "random_id=" + getRandom_id() + "\n"
                + "ref=" + getRef() + "\n"
                + "ref_source=" + getRef_source() + "\n"
                + "attachments.size=" + (getAttachments() != null ? String.valueOf(getAttachments().size()) : "null") + "\n"
                + "important=" + (isImportant() ? "is" : "isn't") + "\n"
                + "geo=" + (getGeo() != null ? getGeo().toString() : "null") + "\n"
                + "payload=" + getPayload() + "\n"
                + "replay_message=" + (getReplay_message() != null ? String.valueOf(getReplay_message().size()) : "null")
                + "keyboard=" + keyboard.toString() + "\n";
    }
}