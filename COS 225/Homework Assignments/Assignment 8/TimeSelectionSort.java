
import java.util.Random;

public class TimeSelectionSort {

	public static void main(String[] args) {
		long start;								// start time for timing
		long end;								// end time for timing
		int size1 = 10000;						// initial array size, adjust as needed
		int size2 = size1 * 2;					// increase original size by factor of 2
		int size3 = size1 * 4;					// increase original size by factor of 4
		
		Double [ ] a1 = new Double [size1];		// arrays of increasing sizes
		Double [ ] a2 = new Double [size2];
		Double [ ] a3 = new Double [size3];
		
		// best case test - fill arrays with sorted data
		for (int k = 0; k < size1; k++ )
			a1[k] = k + Math.random();
		for (int k = 0; k < size2; k++ )
			a2[k] = k + Math.random();
		for (int k = 0; k < size3; k++ )
			a3[k] = k + Math.random();
			
		System.out.println ("Selection Sort Best Case Times:");
		System.out.println("Size\t\tMilliseconds");
		
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a1);
		end = System.currentTimeMillis();
		System.out.println(size1 + "\t\t" + (end-start));
		
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a2);
		end = System.currentTimeMillis();
		System.out.println(size2 + "\t\t" + (end-start));
		
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a3);
		end = System.currentTimeMillis();
		System.out.println(size3 + "\t\t" + (end-start));
		
		// worst case test -  fill arrays with backwards data
		for (int k = 0; k < size1; k++ )
			a1[k] = (size1-k)+ Math.random();
		for (int k = 0; k < size2; k++ )
			a2[k] = (size2-k) + Math.random();
		for (int k = 0; k < size3; k++ )
			a3[k] = (size3-k)+ Math.random();
						
		System.out.println ("\nDelection Sort Worst Case Times:");
		System.out.println("Size\t\tMilliseconds");
		
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a1);
		end = System.currentTimeMillis();
		System.out.println(size1 + "\t\t" + (end-start));
				
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a2);
		end = System.currentTimeMillis();
		System.out.println(size2 + "\t\t" + (end-start));
				
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a3);
		end = System.currentTimeMillis();
		System.out.println(size3 + "\t\t" + (end-start));
		
		// average case test - fill arrays with random data
		Random ran = new Random();
		for (int k = 0; k < size1; k++ )
			a1[k] = ran.nextInt(size1) + Math.random();
		for (int k = 0; k < size2; k++ )
			a2[k] = ran.nextInt(size2) + Math.random();
		for (int k = 0; k < size3; k++ )
			a3[k] = ran.nextInt(size3) + Math.random();
		
		System.out.println ("\nSelection Sort Random Case Times:");
		System.out.println("Size\t\tMilliseconds");
				
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a1);
		end = System.currentTimeMillis();
		System.out.println(size1 + "\t\t" + (end-start));
				
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a2);
		end = System.currentTimeMillis();
		System.out.println(size2 + "\t\t" + (end-start));
				
		start = System.currentTimeMillis();
		SortMethods.selectionSort(a3);
		end = System.currentTimeMillis();
		System.out.println(size3 + "\t\t" + (end-start));
	}
}
