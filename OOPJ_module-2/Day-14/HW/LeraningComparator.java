import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

class Employee{
	 int empId;
	 String empName;
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public String toString() {
		return  empId + " :=> " + empName;
	}
	
}

class EmployeeComparator implements Comparator<Employee>{
	
	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o2.empId - o1.empId;
	}
	
}

class EmployeeComparator1 implements Comparator<Employee>{
	
	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.empName.compareTo(o2.empName);
	}
	
}
public class LeraningComparator {

	public static void main(String[] args) {
		
		TreeSet<Employee> a = new TreeSet<Employee>(new EmployeeComparator());
		a.add(new Employee(11, "Ravi"));
		a.add(new Employee(21, "Ravi1"));
		a.add(new Employee(51, "Ravi2"));
		a.add(new Employee(61, "Ravi3"));
		a.add(new Employee(14, "Ravi4"));
		a.add(new Employee(66, "Ravi5"));
		a.add(new Employee(41, "Ravi6"));
		
		System.out.println(a);
		
		for(Employee x : a) {
			System.out.println(x);
		}
		
		System.out.println("=======================");
		
		TreeSet<Employee> a1 = new TreeSet<Employee>(new EmployeeComparator1());
		a1.add(new Employee(11, "Ravi"));
		a1.add(new Employee(21, "savi1"));
		a1.add(new Employee(51, "Ravi2"));
		a1.add(new Employee(61, "Tavi3"));
		a1.add(new Employee(14, "Kavi4"));
		a1.add(new Employee(66, "Aavi5"));
		a1.add(new Employee(41, "Mavi6"));
		
		System.out.println(a1);
		
		for(Employee x : a1) {
			System.out.println(x);
		}
		
	}

}

