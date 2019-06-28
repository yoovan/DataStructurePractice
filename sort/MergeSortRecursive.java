package com.sort;

import java.util.Arrays;

public class MergeSortRecursive {

	public static void main(String[] args) {
		int[] arr = {2,9,1,50,2,1,54,21,10};
		System.out.println("�鲢����ǰ��" + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("�鲢�����" + Arrays.toString(arr));
		
	}
	
	/**
	 * ����midΪ�ֽ��������������ϲ���һ����������
	 * @param arr ��Ҫ���ϲ�������
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
		// ������õ�������ӵ�arr��
		for (int z = start; z <= end; z++) {
			arr[z] = target[z];
		}
	}
	
	/**
	 * ����˼�룬������һֱ�и�ֱ��ʣ��һ��Ԫ��
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

