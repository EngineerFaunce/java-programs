public interface List<T> {
	public T removeFirst( );					// PRE:		list is not empty
												// POST: 	remove and return first element
	public T removeLast( );						// PRE:		list is not empty,
												// POST: 	remove and return last element
	public T remove (T element);				// POST: 	remove and return specified element
												//	     	no work done if element is not found
	public T first ( );							// PRE:  	list is not empty
												// POST: 	return first element
	public T last ( );							// PRE: 	list is not empty
												// POST: 	return last element
	public boolean contains (T target);			// POST: 	return true if list contains target
	public boolean isEmpty ( );					// POST: 	return true if list is empty
	public int size( );							// POST: 	return number of elements in list
	public void clear ( );						// POST: 	remove all nodes
}
