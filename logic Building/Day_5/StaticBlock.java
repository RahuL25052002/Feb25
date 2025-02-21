class StaticBlock{
	int ram;
	static String name="HP";
	double price;
	
	{
		System.out.println("Instance Block1");

	}
	static{
		System.out.println("Inside static block 1");
		//inside static block we cant write non-static variable
	}
	StaticBlock(){
		System.out.println("Inside constructor 1");
	}
	{
		System.out.println("Instance Block2");

	}

	static{
		System.out.println("Inside static block 2");
	}
	
}
/*
sequence of execution 
	that static block execute only once 
	then init block execute 
	then constructor 
*/

class StaticBlockDemo{
			
	public static void main(String[]args){
		StaticBlock obj1=new StaticBlock();
		//StaticBlock obj2=new StaticBlock();

	}
}