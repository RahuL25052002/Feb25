/*
Write a Java program to print the Fibonacci series up to the 10th number.
Expected Output:
0 1 1 2 3 5 8 13 21 34
*/

class fibbonocciSeries{
	public static void main(String[] args){
		int a=0;
		int b=1;
		int c=a;
		for(int i=0;i<10;i++){
			System.out.print(c+" ");
			a=b;
			b=c;
			c=a+b;
		}
	}
}