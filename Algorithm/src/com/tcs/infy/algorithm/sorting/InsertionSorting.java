package com.tcs.infy.algorithm.sorting;

public class InsertionSorting {

	public static void main(String[] args) {

		int arr[] = { 8, 22, 90, 5, 2 };

		for (int i = 1; i < arr.length; i++) {

			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && key < arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;

				j--;
			}

		}

		for (int lst2 : arr) {
			System.out.print(lst2 + " ");
		}

	}

}
