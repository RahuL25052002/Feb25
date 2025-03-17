
class Parent{
	int x;
	int y;
	void display(){
		System.out.println("X: "+x+" y: "+y);
	}
}
class Child extends Parent{
	Child(int x,int y){
		x=x;
		y=y;
	}
}
class First{
	First(){
		System.out.println("In First");
	}
	public static void main(String[]args){
		Child obj=new Child(67,99);
		obj.display();
	}

}


