
public class IndexedListLinkedList<T> implements IndexedList<T> {
		
		private LinearNode <T> head;					// reference to first node
		private LinearNode <T> tail;					// reference to last node 
		private int count;								// number of nodes in the list

		public IndexedListLinkedList ( )				// POST: empty list
		{	head = tail = null;
			count = 0;		}
		
		public void addFirst (T element)				// POST: element added to front of list
		{	LinearNode<T> newNode = new LinearNode<T>(element);	
			if (isEmpty())								
		     	head = tail = newNode;					
			else
			{	newNode.setNext(head);					
				head = newNode;							
			}
			count++;
		}
		
		public void addLast (T element)					// POST: element added to rear of list
		{	LinearNode<T> newNode = new LinearNode<T>(element);	
		  	if (isEmpty())								
		     	head = tail = newNode;					
		  	else 
		  	{	tail.setNext(newNode);					
		    	tail = newNode;							
		  	}
		  	count++;
		}
		
		public void add (T element, int position) throws InvalidPositionException	
		{												// PRE: 0 <= position < count
			if (position < 0 || position >= count) 		// POST: element added at position
				throw new InvalidPositionException ();
			if (position == 0)
				addFirst(element);						
			else if (position == count)				
				addLast(element);
			else										
			{	LinearNode<T> current = head;			
				for (int i = 1; i < position; i++)			
					current = current.getNext();
				LinearNode<T> newNode = new LinearNode<T> (element);
				newNode.setNext(current.getNext());		
				current.setNext(newNode);				
			 	count++;
			}
		}
				
		public T removeFirst( )	throws EmptyCollectionException		// PRE:	list is not empty
		{															// POST: remove and return first element
			if (isEmpty()) 
				throw new EmptyCollectionException();
			LinearNode<T> temp = head;					
		   	head = head.getNext();						
		    count--;
		   	if (isEmpty()) 
		   		tail = null;					
		    T element = temp.getElement();				
		   	return element;		
		}

		public T removeLast( ) throws EmptyCollectionException		// PRE: list is not empty
		{															// POST: remove and return last element
			if (isEmpty( )) 
				throw new EmptyCollectionException( );
			LinearNode<T> temp = tail;				
			if (count == 1)						
			head = tail = null;					
			else
			{	LinearNode<T> current = head;			
				for (int k = 0; k< count-2; k++)			
					current = current.getNext( );
				tail = current;					
				tail.setNext(null);			
		    	}
			count--;
			return temp.getElement( );				
		}

		public T removeAt (int position) throws InvalidPositionException	// PRE: 0 <= position < count		
		{															// POST: remove/return element at position
			if (position < 0 || position >= count) 
				throw new InvalidPositionException( );			
			if (position == 0)							
				return removeFirst( );
			else if (position == count-1)				
				return removeLast( );
			else 
			{	LinearNode<T> previous = head;			
			    	for (int k = 1; k < position; k++)			
			    		previous = previous.getNext( );
			    	LinearNode<T> current = previous.getNext( );	
			    	previous.setNext(current.getNext( ));		
			    	count--;
			    	return current.getElement( );			
		  	}
		}

		public boolean isEmpty ( )									// POST: return true if list is empty, else false
		{	return count == 0;	}
		
		public int size( )											// POST: return number of elements in list	
		{ return count; }	
		
		public void clear ( )										// POST: remove all nodes
		{	head = tail = null;
			count = 0;   
		}
		
		public String toString ( )									// POST: return a string representation of list elements
		{ String result = "[";
		LinearNode<T> current = head;
		while (current != null)
		{	
			result = result + " " + current.getElement();
			current = current.getNext();
		}
		result = result + " ]";
		return result; }
		
		// complete the remaining methods
		
		public T remove (T element)									// POST: remove and return specified element
		{	return null;											//    	return null if element is not found
		}
				
		public T first ( )	throws EmptyCollectionException			// PRE:	list is not empty
		{	return null;											// POST: return first element
		}
		
		public T last ( )	throws EmptyCollectionException			// PRE:	list is not empty
		{	return null;											// POST: return last element
		}
		
		public boolean contains (T target)							// POST: return true if list contains target, else false
		{	return true;
		}

		public int indexOf (T element )								// POST: return position of element, else -1
		{	return 0;
		}
			

		public T get (int position)	throws InvalidPositionException	// PRE: 0 <= position < size
		{	return null;											// POST: return element at position
		}

		public void set (int position, T element) throws InvalidPositionException	// PRE:  0 <= position < size
		{	return null;															// POST: set element at position
		}
}
		

