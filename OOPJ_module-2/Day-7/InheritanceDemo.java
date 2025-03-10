class Employee{
	float sal=300000;
}
class Pro extends Employee{

	int bonus=100000;

}
class InheritanceDemo{

	public static void main(String[]args){
		Pro e1=new Pro();

		System.out.println(e1.bonus);
		System.out.println(e1.sal);
	}
}
