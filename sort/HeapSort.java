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
	 * ������
	 * ÿ���ø��������һ�����������
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
	 * ������
	 * @param arr
	 * @return
	 */
	private static int[] heap_build(int[] arr) {
		// �ӵ����ڶ��������߽�㿪ʼ
		for(int i = arr.length/2; i >= 0; i--) {
			arr = heapify(arr, arr.length, i);
		}
		
		return arr;
	}
	
	/**
	 * �����ĺ��ӽ���˫�׽�㣬������������������������С���������½���
	 * @param arr
	 * @param n
	 * @param start
	 * @return
	 */
	private static int[] heapify(int[] arr, int n, int start) {
		int max = start; // ���ֵ���±�
		int c1 = 2*start + 1; // ��ǰ��������
		int c2 = 2*start + 2; // ��ǰ�����Һ���
		if (c1 < n && arr[max] < arr[c1]) {
			max = c1;
		}
		if (c2 < n && arr[max] < arr[c2]) {
			max = c2;
		}
		if (max != start) {
			arr = swap(arr, start, max);
			// �ݹ����½�����ֱ�����ӽ��û�б�˫�׽���
			heapify(arr, n, max);
		}
		return arr;
	}
	
	/**
	 * Ԫ��λ�ý���
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
 