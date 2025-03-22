class Student{
	String name;
	double s1,s2,s3;
	double mark;
	Student(String name,double s1,double s2,double s3){
		this.name=name;
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
	}
	void marksCompute(){
		mark=s1+s2+s3;
		double avg=mark/3;
		System.out.println("Total Mark: "+mark);
		System.out.println("Avg of Marks: "+avg);

	}
	void display(){
		System.out.println("Student Name: "+name+" Total marks: "+mark);
	}
}  

class StudentDemo{

	public static void main(String[]args){
		
		Student s1=new Student("Rahul",45,78,98);

		s1.marksCompute();
		s1.display();


	}

}

