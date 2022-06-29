package com.tcs.infy.algorithm.sorting;

public class QuickSorting {
	
	
	/* The main function that implements QuickSort() 
    arr[] --> Array to be sorted, 
    begin  --> Starting index, 
    end  --> Ending index */
  static void quickSort(int arr[], int begin, int end) 
  { 
      if (begin < end) 
      { 
          /* pi is partitioning index, arr[pi] is  
            now at right place */
          int partitionIndex = partition(arr, begin, end); 

          // Recursively sort elements before 
          // partition and after partition 
          quickSort(arr, begin, partitionIndex-1);
          quickSort(arr, partitionIndex+1, end);
      } 
  } 
	
	
	
	
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);// index of smaller element 
	    
	    for (int j = begin; j < end; j++) {
	    	// If current element is smaller than the pivot 
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	 // swap arr[i+1] and arr[end] (or pivot) 
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	    
	    return i+1;
	}
  
  
    



	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        
        quickSort(arr, 0, n-1);
        
        for (int lst2 : arr) {
			System.out.print(lst2 + " ");
		}


	}

}
