
class Employee{
	int id;
	String name;
	Employee(){

		this(11,"Rahul");

		System.out.println(id+ " "+name);
	}
	Employee(int id, String name){
		
		this(1,40000.0,9999l);
		id=id;
		this.name=name;
		System.out.println(id+ " "+name);
		
	}
	Employee(int id,double sal,long pn){
		this.id=id;
		System.out.println(id+" "+sal+" "+pn);
	}
}


class EmployeeDemo{

	public static void main(String[]args){

		Employee e1=new Employee();
	}

}
