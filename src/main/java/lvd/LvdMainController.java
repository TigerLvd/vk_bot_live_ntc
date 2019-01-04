package lvd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import lvd.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Properties;
import java.util.Random;

@RestController
public class LvdMainController {
    private static String CONFIRMATION_CODE;
    private static String SECRET_CODE;
    private static Integer GROUP_ID;

    private static final String OK_BODY = "ok";
    private static final String PROPERTIES_FILE_INIT = "init.properties";
    private static final String PROPERTIES_FILE_CONTENT = "messageContent.properties";
    private static final String PATH_CONTENT = ".\\src\\main\\resources\\rwuMessageText.properties";
    private static final String PATH_CONTENT_SHORT = "rwuMessageText.properties";

    private static VkApiClient vk;
    private static GroupActor groupActor;

    private static final Logger LOG = LoggerFactory.getLogger(LvdMainController.class);
    private static Random random = new Random();
    private static Gson gson = new GsonBuilder().create();
    private static QueueVk messageRandomIds = new QueueVk();

    static void init_contriller() throws IOException {
        LOG.debug("init_controller start");

        setInitProperties();

//        checkContentProperties();

        TransportClient transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);

        LOG.debug("init_controller finish");
    }

    @RequestMapping("/lvd")
    public String index(@RequestParam("x") String str) {

        if (null != str && !str.isEmpty()) {
            return "you entered " + str;
        }
        return "Use & to input property!";
    }

    @RequestMapping(value = "/Ckf_d3f-j8u1eF0k3kbk_eqz",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody MessageContent rwuMessageText(MessageContent input) throws IOException {
        MessageContent output = new MessageContent();
        LOG.info("rwuMessageText start, input=" + input.toString());

        if (null != input) {
            if (MessageContentAction.REFRESH.equals(input.getAction())) {
                output.setAction(MessageContentAction.SUCCESS);
                output.setProperties(getContent());
            } else if (MessageContentAction.SAVE.equals(input.getAction())) {
                Pair[] pairs = output.getProperties();

                if (null != pairs && pairs.length > 0) {
                    Properties properties = new Properties();
                    for (Pair pair : pairs) {
                        properties.setProperty(pair.getName(), pair.getValue());
                    }
                    writeProperties(properties);

                    output.setAction(MessageContentAction.SUCCESS);
                    output.setProperties(input.getProperties());
                }

            }
        }
        LOG.info("rwuMessageText finish, output=" + output.toString());
        return output;
    }

    @RequestMapping(value = "/a-4G_wc0qNillQWE2_34fgh", produces = "application/json")
    @ResponseBody
    public String getMessage(@RequestBody String jsonStr) throws ClientException, ApiException, IOException {
        LOG.info("getMessage jsonStr =<" + jsonStr + ">\n");
        JsonObject requestJson = gson.fromJson(jsonStr, JsonObject.class);
        String type = requestJson.get("type").getAsString();

        if (TypeMessage.CONFIRMATION.getTitle().equals(type)) {
            LOG.info("getMessage " + TypeMessage.CONFIRMATION.getTitle() + " start!\n");

            InitInfoConfirm initInfoConfirm = gson.fromJson(jsonStr, InitInfoConfirm.class);
            String resultStr = getStringErrorType();
            if (null != initInfoConfirm.getGroup_id() && initInfoConfirm.getGroup_id().equals(GROUP_ID.toString())
                    && null != initInfoConfirm.getSecret() && initInfoConfirm.getSecret().equals(SECRET_CODE)) {
                resultStr = CONFIRMATION_CODE;
            }

            LOG.info("getMessage " + TypeMessage.CONFIRMATION.getTitle() + " resultStr=<" + resultStr + ">\n");
            LOG.info("getMessage " + TypeMessage.CONFIRMATION.getTitle() + " end!\n");
            return resultStr;
        } if (TypeMessage.MESSAGE_NEW.getTitle().equals(type)
                || TypeMessage.MESSAGE_REPLY.getTitle().equals(type)
                || TypeMessage.MESSAGE_EDIT.getTitle().equals(type)) {
            LOG.info("getMessage " + TypeMessage.MESSAGE_NEW.getGroup() + " start!\n");
            LOG.info("getMessage groupActor.Id=<" + groupActor.getId() + ">\ngroupActor.GroupId=<" + groupActor.getGroupId() + ">\n");

            InitInfoMessage initInfoMessage = gson.fromJson(jsonStr, InitInfoMessage.class);
            Message message = gson.fromJson(initInfoMessage.getObject(), Message.class);
            if (null != groupActor.getId() && !groupActor.getId().equals(message.getFrom_id())
                    && !messageRandomIds.contains(message.getRandom_id())) {
                String text = message.getText();
                String outputText = null;

                if (null != text && !text.isEmpty()) {
                    if (Label.TIME_TABLE.getTitle().equals(text)) {
                        outputText = getMessageContent("TIME_TABLE", PROPERTIES_FILE_CONTENT);
                        message.setAction(Label.TIME_TABLE);
                    } else if (Label.MASTER_CLASSES.getTitle().equals(text)) {
                        outputText = getMessageContent("MASTER_CLASSES", PROPERTIES_FILE_CONTENT);
                        message.setAction(Label.MASTER_CLASSES);
                    } else if (Label.SPEAKERS.getTitle().equals(text)) {
                        outputText = getMessageContent("SPEAKERS", PROPERTIES_FILE_CONTENT);
                        message.setAction(Label.SPEAKERS);
                    } else if (Label.CONTACTS.getTitle().equals(text)) {
                        outputText = getMessageContent("CONTACTS", PROPERTIES_FILE_CONTENT);
                        message.setAction(Label.CONTACTS);
                    } else if (Label.NEWS.getTitle().equals(text)) {
                        outputText = getMessageContent("NEWS", PROPERTIES_FILE_CONTENT);
                        message.setAction(Label.NEWS);
                    } else if (Label.FOOD.getTitle().equals(text)) {
                        outputText = getMessageContent("FOOD", PROPERTIES_FILE_CONTENT);
                        message.setAction(Label.FOOD);
                    } else if (Label.COMPETITIONS.getTitle().equals(text)) {
                        outputText = getMessageContent("COMPETITIONS", PROPERTIES_FILE_CONTENT);
                        message.setAction(Label.COMPETITIONS);
                    } else {
                        outputText = getMessageContent("START_MESSAGE", PROPERTIES_FILE_CONTENT);
                    }
                }

                if (null == outputText) {
                    outputText = "Привет! Я чат-бот конференции LIVE.\nЯ могу подсказать некоторую информацию поконференции (текст на кнопках)"
                            + "\n\nКонференция LIVE — это место твоей встречи с Богом. \n"
                            + "Это слово, преображающeе жизнь. Это место, где все мы — одна семья.";
                }
                sendMessage(message.getFrom_id(), outputText, message.getAction());
                messageRandomIds.add(message.getRandom_id());
            }

            LOG.info("TIGER_LVD " + TypeMessage.MESSAGE_NEW.getGroup() + " end!\n");
            return OK_BODY;
        } else {
            LOG.info("TIGER_LVD ERROR TYPE!\n");
            return getStringErrorType();
        }
    }

    private String getStringErrorType() {
        return "Ты кто такой? Давай до свидания!";
    }

    private void sendMessage(int userId, String text, Label action) throws ClientException, ApiException {
        LOG.info("TIGER_LVD sendMessage start!\n");
        vk.messages().send(groupActor)
                .message(text)
                .userId(userId)
                .unsafeParam("keyboard", gson.toJson(new Keyboard(7, action)))
                .randomId(random.nextInt())
                .execute();
        LOG.info("TIGER_LVD sendMessage userId = <" + userId + "> text=<" + text.substring(0,10) + ">\n");
        LOG.debug("TIGER_LVD sendMessage userId = <" + userId + "> text=<" + text + ">\n");
        LOG.info("TIGER_LVD sendMessage end!\n");
    }

    private String getMessageContent(String code, String path) throws IOException {
        Properties prop = readProperties(path);
        return convertStr(prop.getProperty(code));
    }

    private Pair[] getContent() throws IOException {
        Pair[] text = new Pair[6];

        text[0] = new Pair("TIME_TABLE", getMessageContent("TIME_TABLE", PROPERTIES_FILE_CONTENT));
        text[1] = new Pair("MASTER_CLASSES", getMessageContent("MASTER_CLASSES", PROPERTIES_FILE_CONTENT));
        text[2] = new Pair("SPEAKERS", getMessageContent("SPEAKERS", PROPERTIES_FILE_CONTENT));
        text[3] = new Pair("CONTACTS", getMessageContent("CONTACTS", PROPERTIES_FILE_CONTENT));
        text[4] = new Pair("NEWS", getMessageContent("NEWS", PROPERTIES_FILE_CONTENT));
        text[5] = new Pair("FOOD", getMessageContent("FOOD", PROPERTIES_FILE_CONTENT));

        return text;
    }

    private static Properties readProperties(String path) throws IOException {
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + path + "' not found in the classpath");
        }
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Incorrect properties file");
        } finally {
            inputStream.close();
        }
    }

    private static void writeProperties(Properties prop) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PATH_CONTENT), "UTF-8"));
            prop.store(writer, null);
        } catch (IOException ex) {
            LOG.error(ex.getMessage());
        }
    }

    private static void writeProperties(Properties prop, String name, String text) {
        prop.setProperty(name, text);

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PATH_CONTENT), "ISO_8859_1"));
            prop.store(writer, null);
        } catch (IOException ex) {
            LOG.error(ex.getMessage());
        }
    }

    private static void setInitProperties() throws IOException {
        Properties prop = readProperties(PROPERTIES_FILE_INIT);

        CONFIRMATION_CODE = prop.getProperty("CONFIRMATION_CODE");
        SECRET_CODE = prop.getProperty("SECRET_CODE");
        GROUP_ID = new Integer(prop.getProperty("GROUP_ID"));
        String TOKEN_GROUP = prop.getProperty("TOKEN_GROUP");

        LOG.info("GROUP_ID: " + GROUP_ID);
        groupActor = new GroupActor(GROUP_ID, TOKEN_GROUP);
    }

    private static void checkContentProperties() throws IOException {
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(PATH_CONTENT_SHORT);
        if (inputStream == null) {
            Properties prop = readProperties(PROPERTIES_FILE_CONTENT);

            for (String name : prop.stringPropertyNames()) {
                prop.setProperty(name, convertStr(prop.getProperty(name)));
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PATH_CONTENT), "UTF-8"));
            prop.store(writer, null);
        }
    }

    private static String convertStr(String str) throws UnsupportedEncodingException {
        return new String(str.getBytes("ISO_8859_1"),
                "Windows-1251");
    }
}