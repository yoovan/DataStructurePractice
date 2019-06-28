package com.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		System.out.println("before bubble sort: " + Arrays.toString(arr));
		bubbleSortAsc(arr);
		System.out.println("after bubble sort asc: " + Arrays.toString(arr));
		bubbleSortDesc(arr);
		System.out.println("after bubble sort desc: " + Arrays.toString(arr));
	}
	
	/**
	 * Ωµ–Ú≈≈–Ú
	 * @param arr
	 */
	private static void bubbleSortDesc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	/**
	 * …˝–Ú≈≈–Ú
	 * @param arr
	 */
	private static void bubbleSortAsc(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
