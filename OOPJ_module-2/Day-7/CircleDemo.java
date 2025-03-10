abstract class Shape{

	Shape(){
		System.out.println("In Shape Constructor");
	}
	
	abstract void draw();

	static void display(){
		System.out.println("We have in the Static methos in Shape class ");
	}
	
}
class Circle extends Shape{
	Circle(){
		System.out.println("In Circle Constructor::");
	}
	void draw(){
		System.out.println("Draw: circle");
	}
}

class Rectangle extends Shape{
	Rectangle(){
		System.out.println("In Rectangle Constructor::::");
	}
	void draw(){
		System.out.println("Draw: Rectangle");
	}
}

class CircleDemo{
	
	public static void main(String[]args){
		Shape s1=new Circle();
		s1.draw();
		s1.display();
		Shape s2=new Rectangle();
		s2.draw();
	}
	
}
