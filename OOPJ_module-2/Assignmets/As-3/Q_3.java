/*
 *3. Find the Second Largest Element
○ Find the second-largest element in the arrya
 */
import java.util.Scanner;
class SecondLargest{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Array size: ");
		int size=obj.nextInt();

		int arr[]=new int[size];


		System.out.println("Enter array element: ");
		for(int i=0;i<arr.length;i++){

			arr[i]=obj.nextInt();
		}

		int large=arr[0];
		int second=-1;

		for(int i=0;i<arr.length;i++){
			if(arr[i]>large){
				second=large;
				large=arr[i];
			}
			if(arr[i]<large && arr[i]>second){
				second=arr[i];
			}
		}

		System.out.println("Second Largest Element in Array: "+second);
	}
}

