class A{}
class B extends A{

}

class ExceptionDemo22{


	public static void main(String[]args){
		System.out.println("Started...");
		A a=new A();
		/*
		B b=(B)a;

		Exception in thread "main" java.lang.ClassCastException: class A cannot be cast to class B (A and B are in unnamed module of loader 'app')
        at ExceptionDemo22.main(ExceptionDemo2.java:12)

	*/
		try{
			B b=(B)a;
		}catch(ClassCastException e){
			System.out.println(e.getMessage());
			System.out.println("Handle the downcasting exception");
		}

		System.out.println("Endedd...");
	}

}
