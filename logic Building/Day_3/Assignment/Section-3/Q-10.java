//10. Write a program to print all even numbers between 1 and 50.

class EvenNumbers{
	public static void main(String[]args){
		System.out.print("Even numbers: ");
		for(int i=1;i<=50;i++){
			if(i%2==0)	
				System.out.print(i+" ");
		}
	}
}

/*
o/p
Even numbers: 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50
*/