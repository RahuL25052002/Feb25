class Parent{
	String name;
	Parent(String name){
		this.name=name;
		System.out.println("In parent Constructor: "+name);
	}

}
class Child extends Parent{
	Child(String name){
		super(name);
		this.name=name;
		System.out.println("In child constructor!! "+name);
	}
}
class Third{

	public static void main(String[]args){	
		Parent obj=new Child("Rahul");
	}

}
