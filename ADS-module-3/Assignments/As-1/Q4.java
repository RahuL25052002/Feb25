/*
 *Problem 4:
Write a recursive program that performs the following operations:
1. Check if a number is prime using recursion.
2. Check whether a given string is a palindrome.
3. Find the sum of digits of a given number.
4. Calculate the nth Fibonacci number.
5. Calculate a raised to the power b
Input:
num = 7
str = "racecar"
num = 1234
fibIndex = 6
a = 2, b = 5
Output:
Is prime: true
Is 'racecar' a palindrome? true
Sum of digits of 1234: 10
Fibonacci(6): 8
2^5 = 32
Constraints:
● Do not use loops or built-in reverse methods.
● Use charAt() for string access.
● You can assume valid positive integer inputs.
 */
class Q4{
	static boolean isPrime(int num,int div){
        	
		if(num<2){
			return false;
		}
		if(div==1){
			return true;
		}
		if(num%div==0){
			return false;
		}
		return isPrime(num,div-1);
	
	}
	static boolean checkPalindrome(String s,int start,int end){
		if(start>=end){
			return true;
		}
		if(s.charAt(start)==s.charAt(end))
			return checkPalindrome(s,start+1,end-1);
		else
			return false;
	}
	static int findSum(int n){
		if(n<=0){
			return 0;
		}
		return n%10+findSum(n/10);
	}
	static int fib(int num){
		if(num==0 || num==1){
			return num;
		}
		return fib(num-1)+fib(num-2);
	}
	static long power(int a,int b){
		if(b==0)
			return 1;
		return a*power(a,b-1);
	}
	public static void main(String[]args){
		int num=9;
		boolean ans=isPrime(num,num/2);
		if(ans){
			System.out.println(num+" is prime");
		}else{
			System.out.println("Not a Prime Number");
		}

		String s="racecar";
		int len=s.length()-1;
		boolean ans1=checkPalindrome(s,0,len);
		System.out.println(ans1);
		int n=1234;
		int sum=findSum(n);
		System.out.println("Sum of "+n+" is : "+sum);

		int nfib=fib(6);
		System.out.println("Fibbonocci: "+nfib);
		int a=2,b=5;
		long po=power(a,b);
		System.out.println(a+"^"+b+" = "+po);
	}

}
