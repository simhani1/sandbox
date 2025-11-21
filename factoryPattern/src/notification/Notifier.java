package notification;

public interface Notifier<T> {

	void send(T request);
}
