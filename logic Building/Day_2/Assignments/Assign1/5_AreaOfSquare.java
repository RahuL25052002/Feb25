import java.util.*;
class AreaOfSquare{
	public static void main(String[] args){
		Scanner obj =new Scanner(System.in);
		System.out.print("Enter the side lenght of Square: ");
		int side=obj.nextInt();
		long area=side*side;
		System.out.println("Area of Square : "+area);
	}
}