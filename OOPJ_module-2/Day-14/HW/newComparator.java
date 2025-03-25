import java.util.*;
class Employee{

	int id;
	String name;

	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}

	public String toString(){
		return id+"->"+name;
	}
}

class EmComp1 implements Comparator<Employee>{

	public int compare(Employee o1,Employee o2){

		return o1.id-o2.id;
	}
}

class EmComp2 implements Comparator<Employee>{
	
	public int compare(Employee o1,Employee o2){

		return o1.name.compareTo(o2.name);
	}

}

class newComparator{

	public static void main(String[]args){
		
		TreeSet<Employee> a=new TreeSet<Employee>(new EmComp1());
		a.add(new Employee(1,"Rahul"));
		  a.add(new Employee(90,"ahul"));
		    a.add(new Employee(3,"ul"));
		      a.add(new Employee(5,"l"));
		        a.add(new Employee(607,"zxRahul"));
			  a.add(new Employee(13,"tRahul"));
			    a.add(new Employee(5,"Rahul"));
		
		System.out.println(a);

		for(Employee a1:a){
			System.out.println(a1);
		}
	}
}
