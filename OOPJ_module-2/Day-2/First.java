//1. Create a program that declares and initializes all primitive data types
// in Java and prints their default and assigned values.

class First{
	int a;
	byte b;
	char c;
	long d;
	float e;
	double f;
	short g;
	public static void main(String[]args){
		
		int a1=12;
		byte b1=13;
		char c1='C';
		long d1=20252002L;
		float e1=0.573f;
		double f1=88488.9090D;
		short g1=14;
		
		First obj=new First();
		System.out.println(obj.a);
		System.out.println(obj.b);
		System.out.println(obj.c);
		System.out.println(obj.d);
		System.out.println(obj.e);
		System.out.println(obj.f);
		System.out.println(obj.g);
		
		///////////////////////////////
		
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(c1);
		System.out.println(d1);
		System.out.println(e1);
		System.out.println(f1);
		System.out.println(g1);
	}
}