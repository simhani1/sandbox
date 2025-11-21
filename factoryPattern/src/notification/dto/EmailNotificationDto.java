package notification.dto;

public class EmailNotificationDto {

    private String recipient;
    private String body;

    public EmailNotificationDto(String recipient, String body) {
        this.recipient = recipient;
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getBody() {
        return body;
    }
}
