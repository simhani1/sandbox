import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import notification.NotifierFactory;
import notification.dto.EmailNotificationDto;
import notification.dto.SmsNotificationDto;
import notification.dto.UndefinedNotificationDto;

class MainTest {

	private static NotifierFactory factory = new NotifierFactory();

	@Test
	void should_success_when_send_email_notification() {
		// GIVEN
		EmailNotificationDto emailRequest = new EmailNotificationDto(
			"test@example.com",
			"This is an email notification."
		);

		// WHEN
		// THEN
		assertThatNoException().isThrownBy(() -> factory.send(emailRequest));
	}

	@Test
	void should_success_when_send_sms_notification() {
		// GIVEN
		SmsNotificationDto smsRequest = new SmsNotificationDto(
			"010-1234-5678",
			"This is a sms notification."
		);

		// WHEN
		// THEN
		assertThatNoException().isThrownBy(() -> factory.send(smsRequest));
	}


	@Test
	void should_fail_when_send_undefined_notification() {
		// GIVEN
		UndefinedNotificationDto undefinedRequest = new UndefinedNotificationDto(
			"This is an undefined notification."
		);

		// WHEN
		// THEN
		assertThatThrownBy(() -> factory.send(undefinedRequest))
			.isInstanceOf(RuntimeException.class);
	}
}