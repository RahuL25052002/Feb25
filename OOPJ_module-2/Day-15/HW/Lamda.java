
@FunctionalInterface
interface Hellocdac{
	void sayHello1();
}

interface Double{
	int square(int n);
}

interface MathOp{
	int calculate(int a, int b);
}
class LambdaEx1 {

	public static void main(String[] args) {
		Hellocdac h1 = () -> System.out.println("Hello Lambda!");
		h1.sayHello1();
		
		Double d1 = (n) -> n*n;
		System.out.println(d1.square(5));
		
		MathOp m1 = (a,b) -> a+b;
		System.out.println(m1.calculate(5, 10));
		
		//Important:
		Runnable r = () -> {
			for(int i=1;i<=5;i++) {
				System.out.println("Thread "+i);
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		}
}


