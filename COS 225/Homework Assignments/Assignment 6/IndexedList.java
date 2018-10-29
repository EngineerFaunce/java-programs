public interface IndexedList<T> extends List<T>{
	public void addFirst (T element);				// POST: 	element added to front of list
	public void addLast (T element);				// POST: 	element added to rear of list
	public void add (T element, int position);		// PRE: 	0 <= position <= size
													// POST: 	element added at position
	public T removeAt (int position);				// PRE: 	0 <= position <= size-1
													// POST: 	return/remove from position
	public int indexOf (T element);					// POST: 	return index of element or -1
	public T get (int position);					// PRE:   	0 <= position < size
													// POST:	return element at position
	public void set (int position, T element);		// PRE:   	0 <= position < size
}													// POST:	set element at position


