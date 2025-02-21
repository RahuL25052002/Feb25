public class Main{
	public static void main(String[] args) {
		int x=0;
		for (int i = 0; i < 5; i++) {
			x = i * 2;
		}
		System.out.println(x); // Error: 'x' is not accessible here
	}
}