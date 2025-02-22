
public class MainMethodDemo{
	
	public static void main(String[] args){
		MainMethodDemo.main(10);
		System.out.println("In main(String)");
	}
	public static void main(int a){
		MainMethodDemo.main(10);//goes into recursion thats why get stackoverflowexception
		System.out.println("In main(int)");
	}
	
}