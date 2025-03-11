
class Employee{
	int id;
	String name;
	Address ad; // Has-A relation
		    //
	Employee(int id,String name, Address ad){
		this.id=id;
		this.name=name;
		this.ad=ad;
	}

	void display(){

		System.out.println("Employee Id: "+id+" Employee Name: "+name);
		System.out.println("Employee Address: "+ad.city+ " "+ad.state+" "+ad.country);
	}

}

class Address{
	String city;
	String state;
	String country;

	Address(String city, String state, String country){

		this.city=city;
		this.state=state;
		this.country=country;
	}

}

class Relation{

	public static void main(String[]args){
		//Aggregation

		Address a=new Address("Pune","Maharashtra","India");
		Employee e=new Employee(1,"Rahul",a);
		e.display();


	}
}
