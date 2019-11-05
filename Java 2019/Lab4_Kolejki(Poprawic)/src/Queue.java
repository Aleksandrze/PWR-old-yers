
public interface Queue {

	/*enqueue - add in queue
	 * dequeue- pobera z kolejki
	 * clear - usuwa wszystkie elementy
	 * size- rozmiar kolejki
	 * isEmpty - wraca true jezeli kolejka jest pusta
	 */
	
	public void enqueue(Object value);
	public Object dequeue() throws EmptyQueueException;
	public void clear();
	public int size();
	public boolean isEmpty();
	void enqueue2(Object value);
	public Object dequeue2() throws EmptyQueueException;
}
