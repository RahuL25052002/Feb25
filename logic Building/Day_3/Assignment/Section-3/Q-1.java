//1. Write a program to calculate the sum of the first 50 natural numbers.

class SumOfNaturalNumber{

	public static void main(String[]args){
		int sum=0;
		for(int i=1;i<=50;i++){
			sum+=i;
		}
		System.out.print("Sum of First 50 Natural Number is: "+sum);	
	}
}

//o/p: Sum of First 50 Natural Number is: 1275