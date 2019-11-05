
import java.util.EmptyStackException;

public interface Stack {

	public void push(Object value); // odіуї na stos

	public Object pop() throws EmptyStackException; // pobierz ze stosu

	public Object peek() throws EmptyStackException; // odczytaj ( nieniszcz№co ) ze stosu

	public void clear(); // czyњж stos

	public int size(); // wysokoњж stosu

	public boolean isEmpty(); // true jeњli stos jest pusty
}
