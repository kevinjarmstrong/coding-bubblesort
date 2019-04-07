
/*
 * Bubble Sort
 * 
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * 
 * Due to its simplicity, bubble sort is often used to introduce the concept of a sorting algorithm.
 * In computer graphics it is popular for its capability to detect a very small error 
 * (like swap of just two elements) in almost-sorted arrays and fix it with just linear complexity (2n). 
 * For example, it is used in a polygon filling algorithm, where bounding lines are sorted by their x 
 * coordinate at a specific scan line (a line parallel to x axis) and with incrementing y their order 
 * changes (two elements are swapped) only at intersections of two lines (Source: Wikipedia)
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr1[] = {5, 7, 8, 9};
		BubbleSort ob = new BubbleSort();
		
		
		System.out.println("Initial Array: " + ob.printArray(arr1));
		ob.basicBubbleSort(arr1, true);
		System.out.println("Sorted Array: " +ob.printArray(arr1));
		
		int arr2[] = {5, 7, 8, 9};
		System.out.println("Initial Array: " + ob.printArray(arr2));
		ob.optimizedBubbleSort(arr2, true);
		System.out.println("Sorted Array: " +ob.printArray(arr2));
		
	}
	
	/*
	 * The basic Bubble Sort function always runs O(n^2) time even if the array is sorted. 
	 * It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.
	 */
	void basicBubbleSort(int arr[], boolean verbose) {
		int n = arr.length; 
		int step = 1;
		
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                	swap(arr, j, j+1);	
                
                	if (verbose) {
                		System.out.print("("+(step++)+") - Next Swap: "+arr[j]+"(j),"+arr[j+1]+"(j+1) | i="+i+",j="+j+" | ");
                		for (int x=0; x < arr.length; x++) System.out.print(arr[x]+",");
                		System.out.println();
                	}
                }
                //swap not required
                else if (verbose) {
                	System.out.print("("+(step++)+") - **No Swap: "+arr[j]+"(j),"+arr[j+1]+"(j+1) | i="+i+",j="+j+" | ");
            		for (int x=0; x < arr.length; x++) System.out.print(arr[x]+",");
            		System.out.println();
                }
            }
	}
	
	/*
	 * The optimized Bubble Sort function is optimized by stopping the algorithm if inner loop 
	 * didn’t cause any swap.
	 */
	void optimizedBubbleSort(int arr[], boolean verbose) {
		int n = arr.length; 
        boolean swapped; 
        int step = 1;
        
        for (int i = 0; i < n - 1; i++)  
        { 
            swapped = false; 
            for (int j = 0; j < n - i - 1; j++)  
            { 
                if (arr[j] > arr[j + 1])  
                { 
                	swap(arr, j, j+1); 
                    swapped = true; 
                    
                    if (verbose) {
                		System.out.print("("+(step++)+") - Next Swap: "+arr[j]+"(j),"+arr[j+1]+"(j+1) | i="+i+",j="+j+" | ");
                		for (int x=0; x < arr.length; x++) System.out.print(arr[x]+",");
                		System.out.println();
                	}
                } 
                else {
                	System.out.print("("+(step++)+") - **No Swap: "+arr[j]+"(j),"+arr[j+1]+"(j+1) | i="+i+",j="+j+" | ");
                	for (int x=0; x < arr.length; x++) System.out.print(arr[x]+",");
            		System.out.println();
                }
            } 
  
            // If no two elements were swapped by inner loop, then break 
            if (swapped == false) 
                break; 
        } 
	}
	
	/*
	 * print the verbose information when request that will show the current step number, i, j values
	 * of the sort and current state of the array
	 */
	void printVebose(String status, int step, int i, int j, int arr[]) {
		System.out.print("("+(step)+") - **No Swap: "+arr[j]+"(j),"+arr[j+1]+"(j+1) | i="+i+",j="+j+" | ");
    	for (int x=0; x < arr.length; x++) System.out.print(arr[x]+",");
		System.out.println();
	}
	
	/*
	 * Print the array
	 */
	String printArray(int arr[]) 
    { 
		StringBuffer sb = new StringBuffer();
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            sb.append(arr[i] + " "); 
        return sb.toString();
    } 
	
	/*
	 * Swap two values in the array
	 */
	void swap(int a[], int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}

}
