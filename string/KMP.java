package com.string;

public class KMP {

	public static void main(String[] args) {
		String text = "aaaaaab";
		String pattern = "ab";
		int start = kmp_search(text, pattern);
		System.out.println("found first index at: " + start);
	}
	
	private static int kmp_search(String text, String pattern) {
		char[] textChar = text.toCharArray();
		char[] patternChar = pattern.toCharArray();
		int[] prefix = prefix_table(pattern);
		int t_len = text.length();
		int pre_len = pattern.length();
		int j = 0, i = 0;
		while(i < t_len) {
			System.out.println("i:" + i + " j: " + j);
			// �����ǰƥ��ĳ��Ⱥ�ģʽ���ĳ�����ȣ��������һλ��һ���ģ�˵��ƥ�䵽��
			// q:ΪʲôҪ-1��a:j�Ǵ�0��ʼ�ġ�
			if (j == pre_len-1 && textChar[i] == patternChar[j]) {
				return i-j;
			}
			if (textChar[i] == patternChar[j]) {
				i++;
				j++;
			} else {
				j = prefix[j];
				if (j == -1) {
					i++;j++;
				}
			}
		}
		return -1;
	}
	
	private static int[] prefix_table(String pattern) {
		int len = pattern.length();
		char[] charArr = pattern.toCharArray();
		int j = 0; // ��ͬǰ��׺�ĸ���
		int i = 2; // �Ƚϵ�λ��
		int[] prefix = new int[len];
		prefix[0] = -1;
		prefix[1] = 0;
		while(i < len) {
			/**
			 * ���������һλ�����һλ���Ƚ�
			 */
			if (charArr[i-1] == charArr[j]) {
				j++;
				prefix[i] = j;
				i++;
			} else {
				j = prefix[j];
				if (j == -1) {
					i++;
				}
			}
		}
		return prefix;
	}
	
}
