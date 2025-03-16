class Parent{
	String name;
	Parent(String name){
		this.name=name;
		System.out.println("In parent Constructor");
	}

}
class Child extends Parent{
	Child(String name){
		this.name=name;
		System.out.println("In child constructor!!");
	}
}
class Second{

	public static void main(String[]args){	
		Child obj=new Child("Rahul");
	}

}
