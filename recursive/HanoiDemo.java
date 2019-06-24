package yostar.recursive;

public class HanoiDemo {

	public static void main(String[] args) {
		hanoi(2, 'A', 'B', 'C');

	}
	
	public static void hanoi(int n, char from, char temp, char to) {
		if (n==1) {
			System.out.println("第"+ n + "个盘子从"+from+"移动到" + to);
		}else {
			hanoi(n-1,from, to, temp);
			System.out.println("第"+ n + "个盘子从"+from+"移动到" + to);
			hanoi(n-1, temp, from, to);
		}
	}

}
