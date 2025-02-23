//7. Write a program to calculate the sum of the digits of the number 9876. The output should be 30 (9 + 8 + 7 + 6).

class SumOfDigits{
	public static void main(String[]args){
	
		int sum=0;
		int num=9876;
		int temp=num;
		while(num!=0){
			sum=sum+num%10;
			num=num/10;
		}
		System.out.println("The sum of digits of number "+temp+" is : "+sum);
	}
}
//op The sum of digits of number 9876 is : 30