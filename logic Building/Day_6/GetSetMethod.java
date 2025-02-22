class Student{

	int id;
	String name;
	long mobNo;
	static String courseName="PG-DAC";

	Student(){
		id=0;
		name="xyz";
		mobNo=911l;
		System.out.println("0 para-constructor");
	}

	Student(int id, String name,long mobNo){
		this.id=id;
		this.name=name;
		this.mobNo=mobNo;
		System.out.println("3 para-constructor");
	}
	static void display(){
		System.out.println("In static display method");
	}
	void setId(int id){
		this.id=id;
	}
	int getId(){
		return id;
	}

	

}

class StudentDemo{
	public static void main(String[] args){
		Student obj=new Student();
		System.out.println(obj.getId());

	}
}



