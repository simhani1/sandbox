package notification.dto;

public class SmsNotificationDto {
    private String phoneNumber;
    private String message;

    public SmsNotificationDto(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
}
