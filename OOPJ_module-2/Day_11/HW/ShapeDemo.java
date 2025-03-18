
abstract class Shape{
	protected String shapeName;

	Shape(){
		this.shapeName=this.getClass().getName();
	}

	String getShapeName(){
		return shapeName;
	}

	abstract double calculateArea();
}

class Circle extends Shape{
	private double radius;
	Circle(double radius){
		this.radius=radius;
	}

	public double calculateArea(){

		double area=3.14*radius*radius;

		return area;
	}

}

class Rectangle extends Shape{
	private double length;
	private double breadth;
	Rectangle(double length,double breadth){
		
		this.length=length;
		this.breadth=breadth;
		
	}
	public double calculateArea(){
		double area=length*breadth;
		return area;
	}
}

class ShapeDemo{

	public static void main(String[]args){
		
		Shape obj1=new Circle(5.0);
		System.out.println("Area of Circle: "+obj1.calculateArea());
		System.out.println("Shape Name of Obj1: "+obj1.getShapeName());
		Shape obj2=new Rectangle(4,6);
		System.out.println("Area of Rectangle: "+obj2.calculateArea());
		System.out.println("Shape Name of Obj2: "+obj2.getShapeName());

	}

}
