class Fib{
	static long fibo(int n){
		
		if(n==0 || n==1){
			return n;
		}
		return fibo(n-1)+fibo(n-2);

	}
	public static void main(String []args){
		/*System.out.println(fibo(0));
		System.out.println(fibo(1));
		System.out.println(fibo(2));
		System.out.println(fibo(3));
		System.out.println(fibo(4));
		System.out.println(fibo(5));
		System.out.println(fibo(6));
		System.out.println(fibo(7));
		System.out.println(fibo(8));
		System.out.println(fibo(9));
		System.out.println(fibo(10));
		System.out.println(fibo(50));*/
		for(int i=0;i<=100;i++){
			System.out.println("Fibonocii of "+i+" is: "+fibo(i));
		}
	}
}
