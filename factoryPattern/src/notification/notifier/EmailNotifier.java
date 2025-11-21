package notification.notifier;

import notification.Notifier;
import notification.dto.EmailNotificationDto;

public class EmailNotifier implements Notifier<EmailNotificationDto> {

    @Override
    public void send(EmailNotificationDto request) {
        System.out.println("Sending Email to: " + request.getRecipient());
        System.out.println("Body: " + request.getBody());
        System.out.println("Email sent successfully!");
    }
}
