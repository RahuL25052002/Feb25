class Employee{
	
	int id;
	String empName;
	double sal;
	String address;
	long phNo;

	Employee(){
		
		
	}

	Employee(int id,String empName,double sal,String address,long phNo){
		
		this.id=id;
		this.empName=empName;
		this.sal=sal;
		this.address=address;
		this.phNo=phNo;
		
	}
	void displayDetails(){
		System.out.println("Employee Id: "+id);
		System.out.println("Employee Name: "+empName);
	        System.out.println("Employee Salary: "+sal);
	        System.out.println("Employee Address: "+address);
		System.out.println("Employee Phone Number: "+phNo);
	}
	void insertData(int id,String empName,double sal,String address,long phNo){
		this.id=id;
                this.empName=empName;
                this.sal=sal;
                this.address=address;
                this.phNo=phNo;
	}
	
}
class EmployeeManagementSystem{

	public static void main(String[]args){
		
		Employee e1=new Employee(11,"Rahul",50000.0d,"Niphad",902223);
	
		e1.displayDetails();
		Employee e2=new Employee();
		e2.insertData(12,"Sai",40000.00d,"Pune",9999);
		e2.displayDetails();
	
	}
}
