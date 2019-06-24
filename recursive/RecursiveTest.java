package yostar.recursive;

public class RecursiveTest {

	public static void main(String[] args) {
		int[] arr = {7,11,20,19,9,2,0,1,40,4,3,5,100,6};
		System.out.println(max(arr, arr.length-1));
	}
	
	private static int max(int[] arr, int n) {
		if (n == 0) {
			return arr[0];
		} else if (max(arr, n-1) > arr[n] ) {
			return max(arr, n-1);
		} else {
			return arr[n];
		}
		
	}

}
