class Parent{
	int x=0;
}

class Child extends Parent{
	int y=2;
	InDemo b;// it aslo work  

}

class InDemo{

	public static void main(String[]args){

		Parent p=new Child();
		System.out.println(p.x);
		p.x=20;
		System.out.println(p.x);
		/*System.out.println(p.y); here we create parent reference thats why we cant access child variables
		
		  at compile time compiler on;y check for the 
		  refernce type of means left side of the object creation 
		  and objcet creation not happennig in compile time ans aslo 
		  compiler find out the varible y in parent rtefernce so it not found
		  so thats why it gave an error


		  */

		Parent p1=new Child();
		Child c1=new Child();
		c1=(Child)p1;

		System.out.println(p1.x);
	
	}

}
