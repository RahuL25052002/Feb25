class Person {
    private String name;
    private int age;

    public Person() {
        this("", 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printRecord() {
        System.out.println("Name  : " + this.name);
        System.out.println("Age   : " + this.age);
    }
}

class Employee extends Person {
    private int empid;
    private float salary;

    public Employee() {
        this("", 0, 0, 0.0f);
    }

    public Employee(String name, int age, int empid, float salary) {
        super(name, age); // Calls Person(String, int) constructor
        this.empid = empid;
        this.salary = salary;
    }

    @Override
    public void printRecord() {
	super.printRecord();
        System.out.println("Empid  : " + this.empid);
        System.out.println("Salary : " + this.salary);
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        Employee emp = new Employee("Sandeep", 39, 3778, 45000.50f);
        emp.printRecord(); // Due to method overriding, Employee.printRecord() will be called
    }
}

