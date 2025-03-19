import java.util.*;

class Employee{

	int id;
	String name;
	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}
	public String toString(){

		return id+" "+name;
	}


}


class EmployeeComparator implements Comparator<Employee>{

	public int compare(Employee o1,Employee o2){
		return o1.id-o2.id;
	}
}

class EmployeeComparator1 implements Comparator<Employee>{

        public int compare(Employee o1,Employee o2){
                return o1.name.compareTo(o2.name);
        }
}
class ComparatorDemo{

	public static void main(String[]args){

		

	}

}
