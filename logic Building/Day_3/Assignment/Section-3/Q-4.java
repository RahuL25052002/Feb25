//4. Write a program to reverse the digits of the number 1234. The output should be 4321.

class ReverseNumber{
	public static void main(String[]args){
		int num=1234;
		int temp=num;
		int rev=0;
		while(num!=0){
			rev=rev*10+num%10;
			num=num/10;
		}
		System.out.println("The number "+temp+" its reverse is : "+rev);	
	}
}

//o/p: The number 1234 its reverse is : 4321