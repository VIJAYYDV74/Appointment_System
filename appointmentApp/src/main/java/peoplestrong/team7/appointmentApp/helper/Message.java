package peoplestrong.team7.appointmentApp.helper;

public class Message {

    private String content;
    private String type;

    public String getContent() {
        return content;
    }

    public Message(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
