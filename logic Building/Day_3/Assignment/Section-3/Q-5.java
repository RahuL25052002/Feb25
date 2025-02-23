//5. Write a program to print the Fibonacci sequence up to the number 21.

class Fibonocci{
	public static void main(String[]args){
		int a=0;
		int b=1;
		int c=a;
		System.out.print("Fibonocci sequence up to number 21: ");
		for(int i=1;i<10;i++){
			System.out.print(c+" ");
			a=b;
			b=c;
			c=a+b;
		}	
	}
}

//op: Fibonocci sequence up to number 21: 0 1 1 2 3 5 8 13 21