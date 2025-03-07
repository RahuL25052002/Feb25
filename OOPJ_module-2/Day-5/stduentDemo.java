class Student{
	int id;
	String name;

	Student(String name,int id){

		this.name=name;
		this.id=id;
	}
}


class StudentDemo{

	public static void main(String[]args){
	
		Student []s1={
			new Student("Rahul",1),
			new Student("Sai",2)
		};

		System.out.println(s1[0]);
	}
}

