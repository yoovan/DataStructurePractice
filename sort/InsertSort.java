package com.sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		System.out.println("before insert sort: " + Arrays.toString(arr));
		insertSort(arr);
		System.out.println("after insert sort: " + Arrays.toString(arr));
	}
	
	/**
	 * 插入排序
	 * @param arr
	 */
	private static void insertSort(int[] arr) {
		int temp, i, j;
		for (i = 1; i < arr.length; i++) {
			temp = arr[i]; // 待插入的元素
			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j]; // 将元素后移，给待插入元素腾出空间
			}
			arr[j + 1] = temp; // 将元素插入移出来的位置
		}
	}

}
