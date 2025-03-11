/*
 *4. Count Even and Odd Numbers
○ Count the number of even and odd numbers in an array.

 */
import java.util.Scanner;
class CountEvenAndOdd{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Array size: ");
		int size=obj.nextInt();

		int arr[]=new int[size];


		System.out.println("Enter array element: ");
		for(int i=0;i<arr.length;i++){

			arr[i]=obj.nextInt();
		}

		int odd=0;
		int even=0;

		for(int i=0;i<arr.length;i++){
			if(arr[i]%2==0)
				even++;
			else
				odd++;
			
		}

		System.out.println("Even count: "+even);
		System.out.println("Odd count: "+odd);
	}
}

