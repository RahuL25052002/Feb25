class Student{

	int id;
	String name;
	long mobNo;
	static String courseName="PG-DAC";
	Student(){
	
	}
	void display(){
		System.out.println(id+"  having course: "+courseName);
	}
	static void display(int id){
		System.out.println(id+"  having course: "+courseName);
	}

}
class StudentDemo{
	public static void main(String[] args){
		Student obj=new Student();
		obj.display();
		//Student.display(100);	it also work accessing throgh class name
	}	
}