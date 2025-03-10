abstract class Bank{

	int id;
	String nameBank;

	abstract void displayBalance();

}
class Employee extends Bank{

	void displayBalance(){
		System.out.println("Empty");
	}
}

class AbstractionDemo{

	public static void main(String[]args){
		
		Bank obj=new Employee();
		obj.displayBalance();
		
	}

}


