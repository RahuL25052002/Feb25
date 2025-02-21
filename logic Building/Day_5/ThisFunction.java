class Student2{

	int id;
	String name;
	long mobNo;
	static String courseName="PG-DAC";

	Student2(){
		this(1);
		id=0;
		name="xyz";
		mobNo=911l;
		System.out.println("0 para-constructor");
	}
		
	Student2(int id){
		this.id=id;
		System.out.println("1 para-constructor and id: "+id);
	}

	Student2(int id, String name,long mobNo){
		this();// this() will always a first statement
		this.id=id;
		this.name=name;
		this.mobNo=mobNo;
		System.out.println("3 para-constructor");
	/*	this();error: call to this must be first statement in constructor
                this();
	*/
	}

}
class StudentDemo2{
	public static void main(String[] args){
		Student2 obj=new Student2(1,"ABC",9l);

	}	
}


