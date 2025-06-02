import java.util.*;
import java.util.stream.Collectors;
class StudentDetails{
	private String name;
	private String college;
	StudentDetails(){
	}
	StudentDetails(String name,String college){
		this.name=name;
		this.college=college;
	}
	public String getName(){
		return this.name;
	}
	public String getCollege(){
		return this.college;
	}
	public String toString(){
		return this.name+" "+this.college;
	}
}
class Student{

	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of student data n: ");
		int n=sc.nextInt();
		StudentDetails[] s1=new StudentDetails[n];
		List<StudentDetails> list=new ArrayList<>();
		for(int i=0;i<n;i++){
			System.out.println("enter name: ");
			String name=sc.next();
			System.out.println("enter college: ");
			String college=sc.next();
			s1[i]=new StudentDetails(name,college);
			list.add(s1[i]);
		}
		//Not a completed code this is 
		List<StudentDetails> streamlist=list.stream().sorted().collect(Collectors.toList());
		System.out.println(streamlist);

	}
}
