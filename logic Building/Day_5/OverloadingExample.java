class OverloadingExample{
	int ram;
	static String name="HP";
	double price;
	
	OverloadingExample(){
		System.out.println("In laptop");
	}
	OverloadingExample(int a,double c){
		ram=a;
		price=c;
		System.out.println(name+" laptop having "+ram+" gb ram price is : "+price);
	}	
	void playMovie(){
		System.out.println(name);
		System.out.println("Chavaa movie playing ");
	}
	void playMovie(String  s){
		System.out.println(name);
		System.out.println("Chavaa movie playing ");
	}
}

class OverloadingExampleDemo{
	public static void main(String[] rahul){
		OverloadingExample obj1=new OverloadingExample();
		OverloadingExample obj2=new OverloadingExample(16,72000);
	OverloadingExample.name="Dell";
	OverloadingExample obj3=new OverloadingExample(8,54000);
		
	}
}