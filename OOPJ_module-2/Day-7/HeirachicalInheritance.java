class Animal{
	Animal(){
		
		System.out.println("In Animal Constructor");

	}
	void sound(){
		System.out.println("Making Noises");
	}
	void eat(){
		System.out.println("nonveg/veg/grass");
	}
}

class Dog extends Animal{

	Dog(){

		System.out.println("In Dog Constructor");
	}
	void sound(){
		System.out.println("Bark Bark");
	}
}

class Cat extends Animal{

	Cat(){
		this("Bow Bow");
		System.out.println("In Cat Constructor");
	}
	Cat(String str){
		System.out.println(str);
	}
	void sound(){
		System.out.println("Meow Meow");
	}

}




class HeirachicalInheritance{

	public static void main(String[]args){
		
		Cat c1=new Cat();
		Dog d1=new Dog();

		c1.sound();
		d1.sound();
		c1.eat();
		d1.eat();

	}
}
