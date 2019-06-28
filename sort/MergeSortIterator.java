package com.sort;

import java.util.Arrays;

public class MergeSortIterator {

	public static void main(String[] args) {
		int[] arr = {2,50,2,1,54,21,10};
		System.out.println("归并排序前：" + Arrays.toString(arr));
		int k = 1;
		// 子序列长度超过数组元素个数停止
		while (k < arr.length) {
			mergePass(arr, k, arr.length-1);
			k = 2*k; // 每次子序列长度加倍
		}
		System.out.println("归并排序后：" + Arrays.toString(arr));
	}
	
	/**
	 * 归并
	 * @param arr
	 * @param step
	 * @param length
	 */
	private static void mergePass(int[] arr, int step, int length) {
		int i = 0;
		// 循环到剩下最后一对，可能是一个也可能是两个
		while(i <= (length - 2 * step + 1)) {
			merge(arr, i, i+step-1, i+2*step-1);
			i = i + 2 * step; 
		}
		if (i < length-step+1) {
			merge(arr, i, i+step-1, length);
		}
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
}
