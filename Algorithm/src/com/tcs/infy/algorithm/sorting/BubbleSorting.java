package com.tcs.infy.algorithm.sorting;

public class BubbleSorting {

	public static void main(String[] args) {
		
		

		int arr[] = { 8, 107, 3, 55, 2 };

		for (int i = 0; i < arr.length-1; i++) {
			
			for (int j = 0; j < arr.length-1-i; j++) {
				
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int lst2 : arr) {
			System.out.print(lst2 + " ");
		}
		
		
		

	}
	
	
}
