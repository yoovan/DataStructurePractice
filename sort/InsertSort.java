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
	 * ��������
	 * @param arr
	 */
	private static void insertSort(int[] arr) {
		int temp, i, j;
		for (i = 1; i < arr.length; i++) {
			temp = arr[i]; // �������Ԫ��
			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j]; // ��Ԫ�غ��ƣ���������Ԫ���ڳ��ռ�
			}
			arr[j + 1] = temp; // ��Ԫ�ز����Ƴ�����λ��
		}
	}

}
