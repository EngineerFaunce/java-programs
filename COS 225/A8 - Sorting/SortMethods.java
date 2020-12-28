import java.util.Comparator;

public class SortMethods {
		
	public static <T extends Comparable<T>> void selectionSort (T [ ] data)
	{	int mindex;
		for (int index=0; index<data.length; index++)
		{	mindex = index;
			for (int scan=index+1; scan<data.length; scan++)
			if (data[scan].compareTo(data[mindex])<0)
					mindex=scan;   
			swap (data, mindex, index);
		}
	}
	
	public static <T extends Comparable<T>> void bubbleSort (T [ ] data)
	{	  	for (int ct1 = 0; ct1 < data.length-1; ct1++)       		
	   		for(int ct2 = 0; ct2 < data.length-1-ct1; ct2++)  		
		          	if (data[ct2].compareTo(data[ct2+1])>0)		
		          	  	swap (data, ct2, ct2+1);
	}

	public static <T extends Comparable<T>> void betterBubbleSort (T [ ] data)
	{	boolean needPass = true;
	   	for (int ct1 = 0; ct1 < data.length-1 && needPass; ct1++)    
	   	{	needPass = false;	
	   		for(int ct2 = 0; ct2 < data.length-1-ct1; ct2++)  	
	          	if (data[ct2].compareTo(data[ct2+1])>0)			
	          	{  	swap (data, ct2, ct2+1);
	         		needPass = true;   }
	  	  } 
	 }

	public static <T extends Comparable<T>> void swap (T[ ] data, int index1, int index2)
	{	T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	public static <T extends Comparable<T>> void insertionSort(T [ ] data)
	{	
	}
	
	public static <T> void insertionSort(T [ ] data, Comparator<T> comp)
	{	
	}
	
	public static <T extends Comparable<T>> boolean isSorted (T [ ] data)
	{
		return true;
	}
	
	

	
	
}
