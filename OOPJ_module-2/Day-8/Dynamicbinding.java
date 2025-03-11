/*
 *Methode overriding

 having Parent child relationship(Inheritance);

 and also callled dynamic binding

 or runtime polymorphism also call

 same name same return type and same parammter

static method cannor be overriden


 */


class Parent{
	/*
	protected void display(){
		System.out.println("Im in parent class");
	}
	
	 *when mehtid protected you have to make 
	 overruden method as protected and public
	 */

	 public void display(){
                System.out.println("Im in parent class");
        }
}

class Child extends Parent{
	int x=0;

	/*
	void display(){
		System.out.println("in child class");
	}
	 display() in Child cannot override display() in Parent
        void display(){
             ^
  attempting to assign weaker access privileges; was public
	*/

	public  void display(){
		System.out.println("In child class");
	}
}


class Dynamicbinding{	
	public static void main(String[]args){
		Child c=new Child();
		c.display();
		System.out.println(c.x);
		Parent p=new Child();
		p.display();
	/*	System.out.println(p.x);
	 *-2\Day-8>javac Dynamicbinding.java
Dynamicbinding.java:53: error: cannot find symbol
                System.out.println(p.x);
                                    ^
  symbol:   variable x
  location: variable p of type Parent
1 error
	 *
	 */	
	}
}
