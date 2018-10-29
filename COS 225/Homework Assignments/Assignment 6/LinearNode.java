public class LinearNode<T> {
	private T element;						// element
	private LinearNode<T> next;				// reference to next node or null
	
	public LinearNode () 					// POST: empty node
	{	element = null;
		next = null;	}
	
	public LinearNode (T elem)				// POST: node element set
	{	element = elem;
		next = null;	}
	
	// accessors and modifiers
	public LinearNode<T> getNext()
	{	return next;	}
	public void setNext (LinearNode<T> node)
	{	next = node;	}
	public T getElement ( )
	{	return element;	}
		public void setElement (T elem)
	{	element = elem;	}
}
