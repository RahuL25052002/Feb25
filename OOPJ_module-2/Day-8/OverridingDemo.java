
class Parent{
	 public void display(){
                System.out.println("Im in parent class");
        }
}

class Child extends Parent{
	int x=0;

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
	 *
	 *	Unlike methods, instance variables are resolved at compile-time based on the reference type.
	 */
	}
}
