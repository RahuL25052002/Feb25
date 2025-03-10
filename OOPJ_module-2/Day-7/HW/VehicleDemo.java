abstract class Vehicle{
	int noOfWheels;
	String name;

	Vehicle(int noOfWheels, String name){

		this.noOfWheels=noOfWheels;

		this.name=name;
	}

	static void avg(){
		System.out.println("..good to go :)");
	}

	void display(){

		System.out.println("Name of Vehicle: "+name);
		System.out.println("No of Wheels: "+noOfWheels);
	}
	
	abstract void speed();

}

class Bike extends Vehicle{

	Bike(int n, String name){
		super(n,name);
	}

	public void speed(){
		System.out.println("Maximum speed upto 140Kmh");
	}

}


class VehicleDemo{

	public static void main(String []args){
		Bike v1=new Bike(2,"Pulsor");
		v1.display();
		v1.speed();
		v1.avg();
	}
}


