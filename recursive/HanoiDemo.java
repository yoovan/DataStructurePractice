package yostar.recursive;

public class HanoiDemo {

	public static void main(String[] args) {
		hanoi(2, 'A', 'B', 'C');

	}
	
	public static void hanoi(int n, char from, char temp, char to) {
		if (n==1) {
			System.out.println("��"+ n + "�����Ӵ�"+from+"�ƶ���" + to);
		}else {
			hanoi(n-1,from, to, temp);
			System.out.println("��"+ n + "�����Ӵ�"+from+"�ƶ���" + to);
			hanoi(n-1, temp, from, to);
		}
	}

}
