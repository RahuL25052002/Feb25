import java.util.*;
class UserDefExc{
		
	public static void main(String[]args){

		System.out.println("Started");
		Scanner obj=new Scanner(System.in);
		try{
			System.out.println("Enter number 1");
                	int x=obj.nextInt();
                	System.out.println("Enter mumber 2");
			int y=obj.nextInt();
			System.out.println(x/y);
		}catch(ArithmeticException | NumberFormatException| InputMismatchException e){
			System.out.println("Exception in Thread "+Thread.currentThread().getName()+": "+e.getMessage());
			//e.printStackTrace();

		}finally{
			System.out.println("Realeased the Resources");	
		}
		System.out.println("Finished");
	}
}
