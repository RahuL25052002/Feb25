/*
 5. Find Sum and Average
○ Compute the sum and average of all elements in the array
 */
import java.util.Scanner;
class FindSumAndAverage{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Array size: ");
		int size=obj.nextInt();

		int arr[]=new int[size];


		System.out.println("Enter array element: ");
		for(int i=0;i<arr.length;i++){

			arr[i]=obj.nextInt();
		}

		int sum=0;
		double avg;

		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		avg=(double)sum/size;
		System.out.println("Sum is : "+sum);
		System.out.println("Avg is : "+avg);
	}
}

