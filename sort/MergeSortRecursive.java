package com.sort;

import java.util.Arrays;

public class MergeSortRecursive {

	public static void main(String[] args) {
		int[] arr = {2,9,1,50,2,1,54,21,10};
		System.out.println("归并排序前：" + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("归并排序后：" + Arrays.toString(arr));
		
	}
	
	/**
	 * 将以mid为分界的两个有序数组合并成一个有序数组
	 * @param arr 需要被合并的数组
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void merge(int[] arr, int start, int mid, int end) {
		int[] target = new int[arr.length];
		int i = start, j = mid + 1, k = i;
		for (; i <= mid && j <= end; k++) {
			if (arr[i] < arr[j]) {
				target[k] = arr[i++];
			} else {
				target[k] = arr[j++];
			}
		}
		
		while(i <= mid) {
			target[k++] = arr[i++];
		}
		
		while(j <= end) {
			target[k++] = arr[j++];
		}
		// 将排序好的内容添加到arr中
		for (int z = start; z <= end; z++) {
			arr[z] = target[z];
		}
	}
	
	/**
	 * 分治思想，将数组一直切割直到剩下一个元素
	 * @param arr
	 * @param start
	 * @param end
	 */
	private static void mergeSort(int[] arr, int start, int end) {
		int mid = (start + end)/2;
		if (start < end) {
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
}

