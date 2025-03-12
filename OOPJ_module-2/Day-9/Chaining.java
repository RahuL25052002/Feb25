class Parent{
	Parent(String name){
		System.out.println("In parent constructor "+name);
	}

}

class Child extends Parent{
	/*
	 *invokespecial and super
When invoking a method with the super keyword, as in super.someMethod(), you want the superclass's version of a method to be invoked -- even if the current class overrides the method. Once again, invokevirtual would invoke the current class's version, so it can't be used in this situation.
	 */
	Child(String name){
		super(name);// if we not write then it gave a error 
		System.out.println("In child constructor "+name);
	}
	 
}


class  Chaining{

	public static void main(String[]args){
		Child c1=new Child();
		//static int x=222;
	}

}
