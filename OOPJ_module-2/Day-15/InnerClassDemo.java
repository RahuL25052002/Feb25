import java.util.*;

class OuterClass{

	int x=100;
	public void display(){
		System.out.println("Outer class: method");
	//	System.out.println(y);//Error scope mai nahi hai re bhaii 
	}
	class InnerClass{
		int y=200;
		public void display1(){
			System.out.println("Inner class method");
			System.out.println(x);
			display();
		}
	}

}

class InnerClassDemo{

	public static void main(String[]args){
		OuterClass o1=new OuterClass();
		System.out.println(o1.x);
		o1.display();
		//InnerClass i1=new InnerClass(); gives erro
		OuterClass.InnerClass i1=o1.new InnerClass();
		System.out.println(i1.y);
		i1.display1();


	}
}
