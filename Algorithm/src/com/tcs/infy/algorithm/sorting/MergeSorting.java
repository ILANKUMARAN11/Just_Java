package com.tcs.infy.algorithm.sorting;

public class MergeSorting {

	public static void mergeSort(int[] arr, int n) {

		if (n < 2) {
			return;
		}

		int mid = n / 2;

		int l[] = new int[mid];
		int r[] = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = arr[i];
		}

		for (int i = mid; i < n; i++) {
			r[i - mid] = arr[i];
		}
		
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(arr, l, r, mid, n - mid);

	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;

		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}

		while (i < left) {
			a[k++] = l[i++];
		}

		while (j < right) {
			a[k++] = r[j++];
		}

	}

	public static void main(String[] args) {

		int arr[] = { 8, 777, 9, 5, 2, 22 };

		mergeSort(arr, arr.length);

		for (int lst2 : arr) {
			System.out.print(lst2 + " ");
		}

	}

}
