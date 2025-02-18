import java.util.*;
class DisplayMessage{
	public static void main(String[] args){
		Scanner obj =new Scanner(System.in);
		System.out.print("Enter Number: ");
		int msg=obj.nextInt();
		if(msg>5 && msg<12){
			System.out.println("Good Morning EveryOne!!");
		}else{
			System.out.println("Have a good Day!!");
		}
	}
}