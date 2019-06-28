package com.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		System.out.println("before quick sort: " + Arrays.toString(arr));
		qSort(arr, 0, arr.length-1);
		System.out.println("after quick sort: " + Arrays.toString(arr));
	}
	
	private static void qSort(int[] arr, int low, int high) {
		int pivot;
//		if (low < high) {
		while (low < high) { // 使用循环优化递归
			pivot = partition(arr, low, high);
			qSort(arr, low, pivot - 1);
//			qSort(arr, pivot + 1, high);
			low = pivot + 1;
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivotKey = arr[low];
		while (low < high) {
			while(low < high && arr[high] >= pivotKey) {
				high--;
			}
//			swap(arr, low, high);
			arr[low] = arr[high]; // 使用替换优化
			while (low < high && arr[low] <= pivotKey) {
				low++;
			}
//			swap(arr, low, high);
			arr[high] = arr[low]; // 使用替换优化
		}
		arr[low] = pivotKey;
		return low;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
