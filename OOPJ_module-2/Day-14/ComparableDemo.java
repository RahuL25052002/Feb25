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
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}

		if(obj instanceof Employee){
			Employee e=(Employee)obj;
			return id==e.id;
		}
		return false;
	}
	public int compareTo(Employee e){
		return id-e.id;
	}

}
class ComparableDemo{

	public static void main(String[]args){
		TreeSet<Employee> a=new TreeSet<>();
		a.add(new Employee(11,"Rahul"));
		a.add(new Employee(42,"Sai"));
		a.add(new Employee(13,"Nikhil"));
	 	a.add(new Employee(14,"Mayuri"));
		a.add(new Employee(25,"Mauli"));
		a.add(new Employee(16,"Shweta"));

		System.out.println(a);


		for(Employee x:a){

			System.out.println(x);
		}
	}

}
