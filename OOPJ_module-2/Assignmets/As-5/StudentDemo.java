import java.util.*;

class Student{
	String name;
	int rollNo;
	double marks[]=new double[5];
	double avg;
	char grade;
	Student(String name,int rollNo,double marks[]){
		this.name=name;
		this.rollNo=rollNo;
		for(int i=0;i<marks.length;i++){
			if(marks[i]<0 || marks[i]>100){
				throw new IllegalArgumentException("Marks neighter Negative nor greater than 100");
			}
		}
		this.marks=marks;
	}

	void calculateAverage(){
		int sum=0;
		for(int i=0;i<marks.length;i++){
			sum+=marks[i];
		}
		avg=sum/5;
	}

	void calculateGrade(){
		if(avg>=90){
			grade='A';
		}else if(avg>=80 && avg<90){
			grade='B';
		}else if(avg>=70 && avg<80){
			grade='C';
		}else if(avg>=60 && avg<70){
			grade='D';
		}else if(avg<60){
			grade='F';
		}
	}
	void displayStudentInfo(){
		System.out.println("========================");
		System.out.println("Name of Student: "+name);
		System.out.println("Student Roll no. : "+rollNo);
		System.out.print("Marks : ");
		for(int i=0;i<marks.length;i++){
			System.out.print(marks[i]+" ");
		}
		System.out.println();
   	      	System.out.println("Average of Marks: "+avg);
		System.out.println("Grade : "+grade);
	     	System.out.println("========================");
	}
}
class StudentDemo{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("How many student entries add: ");
		int num=obj.nextInt();
		Student s[]=new Student[num];
		for(int i=0;i<s.length;i++){
			double marks[]=new double[5];
			String name="";
			int r=0;
			try{
				System.out.print("Enter Student name: ");
				obj.nextLine();
				name=obj.nextLine();
				System.out.print("Enter roll no: ");
				r=obj.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Invalid Inputs");
				System.exit(0);
			}

			try{
				System.out.print("Enter marks: ");
				for(int j=0;j<marks.length;j++){
					if (!obj.hasNextDouble()) {
                    				throw new InputMismatchException("Invalid input! Please enter numeric values.");
                			}
                			marks[i] = obj.nextDouble();
                			if (marks[i] < 0 || marks[i] > 100) {
                    				throw new IllegalArgumentException("Marks should be between 0 and 100.");
                			}
				}
			}catch(IllegalArgumentException| NoSuchElementException e){
				System.out.println("Invalid marks: "+e.getMessage());
				System.exit(0);
			}finally{
			}
			s[i]=new Student(name,r,marks);
		}


		for(Student sd:s){
			sd.calculateAverage();
			sd.calculateGrade();
			sd.displayStudentInfo();
		}

	}
}
