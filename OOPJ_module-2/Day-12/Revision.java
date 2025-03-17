class Animal{
	Animal(){
		System.out.println("In Animal");
	}
}

class Fish extends Animal{
	Fish(){
		this(0);
		System.out.println("In Fish");
	}
	Fish(int a){
		//super call by default
		System.out.println("Bhaii This is the parameter constructor");
	}
}
public class Revision{

	public static void main(String[]args){

		Fish obj=new Fish();
	}

}
