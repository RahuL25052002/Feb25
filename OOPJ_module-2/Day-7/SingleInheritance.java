class Animal{
	int legs;
	Animal(int num){
		this.legs=num;
	}
	//abstract void eat(); we cannot write abtract method in this class because this is not an abstract class 
	void eat(){
		
		System.out.println("This is Common property'");

	
	}
	
}

class Dog extends Animal{

	Dog(){
		super(4);

	}
	void sound(){
		System.out.println("Bow Bow");

	}

}



class  SingleInheritance{
	
	public static void main(String[]args){	
		//Dog d=new Animal();
		Animal d=new Dog();
		System.out.println(d.legs);
	}

}
