package com.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {2, 1, 5, 3, 10, 4, 7, 8, 9};
		System.out.println(Arrays.toString(arr));
		arr = heap_sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	/**
	 * 堆排序
	 * 每次用根结点跟最后一个结点做交换
	 * @param arr
	 * @return
	 */
	private static int[] heap_sort(int[] arr) {
		arr = heap_build(arr);
		for (int i = arr.length - 1; i > 0; i--) {
			arr = swap(arr, i, 0);
			arr = heapify(arr, i, 0);
		}
		return arr;
	}
	
	/**
	 * 构建堆
	 * @param arr
	 * @return
	 */
	private static int[] heap_build(int[] arr) {
		// 从倒数第二层的最左边结点开始
		for(int i = arr.length/2; i >= 0; i--) {
			arr = heapify(arr, arr.length, i);
		}
		
		return arr;
	}
	
	/**
	 * 将最大的孩子结点给双亲结点，并且如果交换后如果还比下面小，继续向下交换
	 * @param arr
	 * @param n
	 * @param start
	 * @return
	 */
	private static int[] heapify(int[] arr, int n, int start) {
		int max = start; // 最大值的下标
		int c1 = 2*start + 1; // 当前结点的左孩子
		int c2 = 2*start + 2; // 当前结点的右孩子
		if (c1 < n && arr[max] < arr[c1]) {
			max = c1;
		}
		if (c2 < n && arr[max] < arr[c2]) {
			max = c2;
		}
		if (max != start) {
			arr = swap(arr, start, max);
			// 递归向下交换，直到孩子结点没有比双亲结点大
			heapify(arr, n, max);
		}
		return arr;
	}
	
	/**
	 * 元素位置交换
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	private static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
}
 