class Laptop{
	int ram;
	String name;
	double price;
	
	void accessCamera(){
	
	}
	void playMovie(){
		System.out.println(name);
		System.out.println("Chavaa movie playing ");
	}
	String display(){
		return name;
	}
/*
	public static void main(String[] rahul){
	
	}
*/
// .........................................................
//here in this class we have template of laptop 
// defined all its properties and behaviour 
// so we can use this and create mutiple object also 
// ......................................................
	
}

class LaptopDemo{
	public static void main(String[] rahul){
		Laptop obj=new Laptop();
		obj.name="Hp_i5_8gbRam";
		System.out.println(obj.ram);
		obj.playMovie();
		String teach=obj.display();
		System.out.println(teach);
		
	
	}
}