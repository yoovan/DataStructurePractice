package com.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		System.out.println("before select sort: " + Arrays.toString(arr));
		selectSort(arr);
		System.out.println("after select sort: " + Arrays.toString(arr));
	}
	
	private static void selectSort(int[] arr) {
		int min;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}

}
