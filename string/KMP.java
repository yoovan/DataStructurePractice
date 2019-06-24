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
			// 如果当前匹配的长度和模式串的长度相等，并且最后一位是一样的，说明匹配到了
			// q:为什么要-1？a:j是从0开始的。
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
		int j = 0; // 相同前后缀的个数
		int i = 2; // 比较的位置
		int[] prefix = new int[len];
		prefix[0] = -1;
		prefix[1] = 0;
		while(i < len) {
			/**
			 * 将整体后移一位，最后一位不比较
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
