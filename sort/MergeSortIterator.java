package com.sort;

import java.util.Arrays;

public class MergeSortIterator {

	public static void main(String[] args) {
		int[] arr = {2,50,2,1,54,21,10};
		System.out.println("�鲢����ǰ��" + Arrays.toString(arr));
		int k = 1;
		// �����г��ȳ�������Ԫ�ظ���ֹͣ
		while (k < arr.length) {
			mergePass(arr, k, arr.length-1);
			k = 2*k; // ÿ�������г��ȼӱ�
		}
		System.out.println("�鲢�����" + Arrays.toString(arr));
	}
	
	/**
	 * �鲢
	 * @param arr
	 * @param step
	 * @param length
	 */
	private static void mergePass(int[] arr, int step, int length) {
		int i = 0;
		// ѭ����ʣ�����һ�ԣ�������һ��Ҳ����������
		while(i <= (length - 2 * step + 1)) {
			merge(arr, i, i+step-1, i+2*step-1);
			i = i + 2 * step; 
		}
		if (i < length-step+1) {
			merge(arr, i, i+step-1, length);
		}
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
}
