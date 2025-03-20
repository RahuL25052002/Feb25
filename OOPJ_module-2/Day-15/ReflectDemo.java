import java.lang.reflect.*;
class Demo{

	private String msg="Learnig reflection";

	public Demo(){
		System.out.println("Demo-Const");
	}

	public Demo(int x){
	}
	public Demo(String n){

	}

	public void display(){
		System.out.println("Dmeo Method");
	
	
	}
	public void show(){

	}

	int getMoney(){
		return 1000;
	}
}


class ReflectDemo{

	public static void main(String[]args){
		
		Class<?> d1=Demo.class;

		System.out.println(d1.getName());

		Constructor <?> []c1=d1.getConstructors();

		System.out.println(".......................");
		for(Constructor<?> x: c1){

			System.out.println(x);
		}


		Method[] m1=d1.getDeclaredMethods();
		System.out.println(".......................");

		for(Method x:m1){

			System.out.println(x);
		}


	}

}
