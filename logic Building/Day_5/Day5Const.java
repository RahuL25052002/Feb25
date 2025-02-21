class Laptop1{
	int ram;
	String name;
	double price;
	
	Laptop1(){
		ram=8;
		name="HP";
		price=53000.00;
		System.out.println("In laptop");
	}
	Laptop1(int a,String b,double c){
		ram=a;
		name=b;
		price=c;
		System.out.println("In 3 para cstr laptop");
	}	
	void playMovie(){
		System.out.println(name);
		System.out.println("Chavaa movie playing ");
	}
	void playMovie(String  s){
		System.out.println(name);
		System.out.println("Chavaa movie playing ");
	}
	String display(){
		return name;
	}
}

class LaptopDemo1{
	public static void main(String[] rahul){
		Laptop1 obj=new Laptop1();
		obj.playMovie("Rahul");
		obj.playMovie();
		
	}
}