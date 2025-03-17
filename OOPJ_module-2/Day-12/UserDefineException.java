import java.util.*;
class UserDefineException{
		
	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the No");
		int x=obj.nextInt();
		try{
			if(x==0){
				throw new ArithmeticException("Divide by zeo");
			}
			System.out.println(10/x);
		}catch(ArithmeticException e){
			System.out.println("Exception in Thread "+Thread.currentThread().getName()+": "+e.getMessage());
			e.printStackTrace();

		}
	}
}
