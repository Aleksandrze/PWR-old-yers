

public interface StosT<T> {
	boolean isFull();

	boolean isEmpty();

	int size();

	void push(T elem);

	T pop();

	T top();

}