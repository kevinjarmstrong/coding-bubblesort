/*
 * Bubble Sort
 * The main advantage of Bubble Sort is the simplicity of the algorithm.
 * 
 * Worst and Average Case Time Complexity: O(n2). Worst case occurs when array is reverse sorted.
 * 
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * 
 * Auxiliary Space: O(1) - The space complexity for Bubble Sort is O(1), because only a single additional memory
 * space is required i.e. for temp variable.
 * 
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * 
 * Due to its simplicity, bubble sort is often used to introduce the concept of a sorting algorithm.
 * In computer graphics it is popular for its capability to detect a very small error 
 * (like swap of just two elements) in almost-sorted arrays and fix it with just linear complexity (2n). 
 * For example, it is used in a polygon filling algorithm, where bounding lines are sorted by their x 
 * coordinate at a specific scan line (a line parallel to x axis) and with incrementing y their order 
 * changes (two elements are swapped) only at intersections of two lines (Source: Wikipedia).
 * 
 * Following are the steps involved in bubble sort(for sorting a given array in ascending order):
 *   Starting with the first element(index = 0), compare the current element with the next element of the array.
 *   If the current element is greater than the next element of the array, swap them.
 *   If the current element is less than the next element, move to the next element. Repeat Step 1.
 * 
 * In Bubble Sort, n-1 comparisons will be done in the 1st pass, n-2 in 2nd pass, n-3 in 3rd pass and so on.
 * (n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1 
 * Sum = n(n-1)/2 
 * i.e O(n2)
 * 
 * Following are the Time and Space complexity for the Bubble Sort algorithm.
 * 	Worst Case Time Complexity [ Big-O ]: O(n2)
 * 	Best Case Time Complexity [Big-omega]: O(n)
 * 	Average Time Complexity [Big-theta]: O(n2)
 * 	Space Complexity: O(1)
 * 
 */

public class BubbleSort {

	/*
	 * Main
	 */
	public static void main(String[] args) {
		int arr1[] = {5, 7, 8, 2, 3, 9};
		int arr2[] = {5, 7, 8, 2, 3, 9};
		BubbleSort ob = new BubbleSort();
		
		//run basic bubble sort
		ob.basicBubbleSort(arr1, true);
		
		//run optimized bubble sort
		ob.optimizedBubbleSort(arr2, true);
		
	}
	
	/*
	 * The basic Bubble Sort function always runs O(n^2) time even if the array is sorted. 
	 * It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.
	 */
	void basicBubbleSort(int arr[], boolean verbose) {
		System.out.println("Basic Bubble Sort Initial Array: " + this.printArray(arr));
		
		int n = arr.length; 	//length of array
		int step = 1; 			//number of steps taken in sort - used to compare basic and optimized sorts
		
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                	swap(arr, j, j+1);	
                
                	if (verbose) this.printVebose("Next Swap", step++, i, j, arr);
                }
                //swap not required
                else if (verbose) this.printVebose("**No Swap", step++, i, j, arr);
            }
        
        System.out.println("Sorted Array: " +this.printArray(arr));
		System.out.println();
	}
	
	/*
	 * The optimized Bubble Sort function is optimized by stopping the algorithm if inner loop 
	 * didn’t cause any swap.
	 * 
	 * To optimize our bubble sort algorithm, we can introduce a flag to monitor whether elements are getting swapped 
	 * inside the inner for loop.  
	 * 
	 * Hence, in the inner for loop, we check whether swapping of elements is taking place 
	 * or not, everytime.
	 * 
	 * If for a particular iteration, no swapping took place, it means the array has been sorted and we can jump out of 
	 * the for loop, instead of executing all the iterations.
	 * 
	 */
	void optimizedBubbleSort(int arr[], boolean verbose) {
		System.out.println("Basic Bubble Sort Initial Array: " + this.printArray(arr));
		
		int n = arr.length; 	//length of array
        int step = 1;			//number of steps taken in sort - used to compare basic and optimized sorts
        boolean swapped; 		//lag to monitor whether elements are getting swapped inside the inner for loop
        
        for (int i = 0; i < n - 1; i++)  
        { 
            swapped = false; 
            for (int j = 0; j < n - i - 1; j++)  
            { 
                if (arr[j] > arr[j + 1])  
                { 
                	swap(arr, j, j+1); 
                    swapped = true; 
                    
                    if (verbose) this.printVebose("Next Swap", step++, i, j, arr);
                } 
                else this.printVebose("**No Swap", step++, i, j, arr);
            } 
  
            // If no two elements were swapped by inner loop, then break 
            if (swapped == false) 
                break; 
        }
        
        System.out.println("Sorted Array: " +this.printArray(arr));
		System.out.println();
	}
	
	/*
	 * print the verbose information when request that will show the current step number, i, j values
	 * of the sort and current state of the array
	 */
	public void printVebose(String status, int step, int i, int j, int arr[]) {
		System.out.print("("+(step)+") "+status+": ("+arr[j]+","+arr[j+1]+") | i="+i+",j="+j+" | "+this.printArray(arr));
		System.out.println();
	}
	
	/*
	 * Print the array
	 */
	public String printArray(int arr[]) 
    { 
		StringBuffer sb = new StringBuffer();
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            sb.append(arr[i] + ","); 
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
