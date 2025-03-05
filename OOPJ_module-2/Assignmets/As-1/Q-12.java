
//12. Write a program to demonstrate the use of assignment operators (=, +=, -=, *=, /=, %=) on two integers.
class Test{


	public static void main(String[]args){
		int a=5;
		int b=3;
		a+=b;
		b-=a;
		int c=10;
		c/=b;
		int d=20;
		d*=c;
		a%=d;

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
                System.out.println(d);
	

	}

}

