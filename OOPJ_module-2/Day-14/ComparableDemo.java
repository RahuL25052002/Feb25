import java.util.*;

class Employee implements Comparable<Employee>{

	int id;
	String name;
	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}
	public String toString(){

		return id+" "+name;
	}
	public boolean equals(Object obj0){
		if(obj==null){
			return false;
		}

		if(obj instanceof Employee){
			Employee e=(Employee)obj;
		}
	}

}
class ComparableDemo{

	public static void main(String[]args){
		ArrayList<Employee> a=new ArrayList<>();
		a.add(new Employee(11,"Rahul"));
		a.add(new Employee(12,"Sai"));
		a.add(new Employee(13,"Nikhil"));
	 	a.add(new Employee(14,"Mayuri"));
		a.add(new Employee(15,"Mauli"));
		a.add(new Employee(16,"Shweta"));

		System.out.println(a);
	}

}
