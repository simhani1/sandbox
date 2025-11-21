package notification.notifier;

import notification.Notifier;
import notification.dto.SmsNotificationDto;

public class SmsNotifier implements Notifier<SmsNotificationDto> {
    @Override
    public void send(SmsNotificationDto request) {
        System.out.println("Sending SMS to: " + request.getPhoneNumber());
        System.out.println("Message: " + request.getMessage());
        System.out.println("SMS sent successfully!");
    }
}
