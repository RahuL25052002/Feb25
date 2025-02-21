//this pointer variable

class Student1{

	int id;
	String name;
	long mobNo;
	static String courseName="PG-DAC";


	Student1(){
		id=0;
		name="xyz";
		mobNo=911l;
	}
	Student1(int id, String name,long mobNo){
		this.id=id;
		this.name=name;
		this.mobNo=mobNo;
	}


	void display(int id){
		System.out.println("Instance id: "+this.id+"  having course: "+courseName+" local-id: "+id);
	}

}
class StudentDemo1{
	public static void main(String[] args){
		Student1 obj1=new Student1();
		Student1 obj2=new Student1(2,"Mayur",9l);
		Student1 obj3=new Student1(3,"Sai",20l);
		//obj1.display();
		//obj2.display();
		//obj3.display();
		obj3.display(100);
		obj2.display(99);

	}	
}