class Parent{
	static{
		System.out.println("In parent Static block");
	}
	Parent(){
		System.out.println("In parent Constructor: ");
	}

}
class Child extends Parent{
	static{
		System.out.println("In Child Static block");
	}
	Child(){
	
		System.out.println("In child constructor!! ");
	}
}
class Fifth{

	static{
		System.out.println("In Main Static block");
		System.exit(0);
	}

	public static void main(String[]args){	
		Parent obj=new Child();
		Child ob2=new Child();

	}
}







/*
 *
o/p:
In Main static block"
 */
