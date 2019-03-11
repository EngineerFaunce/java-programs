public class HashTable {
	String [ ] h;								// hash table using an array ring
	int capacity;								// capacity of hash table 
	int size;									// number of items in hash table

	public HashTable( )							// POST: empty hashtable 
	{	capacity = 1009;						// initial capacity
		h = new String [capacity];				// all references are null		
		size = 0;								// hash table is empty
	}
	
	public int getCapacity()					// POST: return capacity of underlying array
	{	return capacity;
	}
	
	public int getSize( )						// POST: return number of items in hash table
	{	return size;
	}
	
	public int getIndex (String word)			// POST: return index of given word, or -1 if not found
	{	for (int k = 0; k < capacity; k++)
			if (word.equals(h[k]))
				return k;
		return -1;
	}
	
	public double getLoadFactor ( )				// POST: return load factor, ratio of size to capacity
	{	return (double)size/capacity;
	}
	
	public boolean isEmpty( )					// POST: return true if hash table is empty
	{	return size == 0;
	}
	
	private int hash1 (String word)				// POST: return hash index of word
	{  int seed = 131; 
	   long sum = 0;
	   for(int k = 0; k < word.length(); k++)
	         sum = (sum * seed) + (int)(word.charAt(k));
		return (int)(Math.abs(sum) % capacity);
	}
	
	private int hash2 (String word)				// POST: return hash index of word
	{	int sum = 0;
		for (int k = 0; k< word.length(); k++)		
			sum = sum + (int)(word.charAt(k));		
		return  sum % capacity;   				
	}
	
	public boolean isPresent(String word)		// POST: return true if word is in hash table; else false
	{	return true;
	}
	
	public void insert (String word)			// POST: if word is not found, add word to hash table
	{	if ((double)size / capacity >= 0.75) 	// call resize when load factor hits 75%
			resize( );	
			
	}
	
	private void resize( )						// POST: double the capacity of the array and rehash all items
	{	
	}
	
	public int getNProbes (String word)			// POST: return number of probes to find word or determine it is not in table
	{	return 1;
	}
}
