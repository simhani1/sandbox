package notification;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import notification.notifier.EmailNotifier;
import notification.notifier.SmsNotifier;

public final class NotifierFactory {

	private final Map<Class<?>, Notifier<?>> map;

	public NotifierFactory() {
		this.map = new HashMap<>();
		registerNotifier(new EmailNotifier());
		registerNotifier(new SmsNotifier());
	}

	@SuppressWarnings("unchecked")
	public <T> void send(T request) {
		Notifier<?> notifier = map.get(request.getClass());
		if (notifier != null) {
			Notifier<T> selectedNotifier = (Notifier<T>) notifier;
			selectedNotifier.send(request);
			return;
		}
		throw new IllegalArgumentException("No notifier registered for type " + request.getClass().getName());
	}

	/**
	 * notification.Notifier 구현체를 팩토리에 등록합니다.
	 * @param notifier 등록할 notification.Notifier 인스턴스
	 */
	private void registerNotifier(Notifier<?> notifier) {
		Class<?> requestType = getRequestType(notifier);
		map.put(requestType, notifier);
	}

	/**
	 * notification.Notifier 구현체가 다루는 요청(DTO)의 클래스 타입을 리플렉션을 통해 추출합니다.
	 * @param notifier notification.Notifier 인스턴스
	 * @return 요청(DTO)의 클래스 타입
	 */
	private Class<?> getRequestType(Notifier<?> notifier) {
		// notification.Notifier<T> 인터페이스의 제네릭 타입 T를 추출합니다.
		ParameterizedType type = (ParameterizedType) notifier.getClass().getGenericInterfaces()[0];
		return (Class<?>) type.getActualTypeArguments()[0];
	}
}
