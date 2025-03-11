/*
 *1. Find the Largest and Smallest Element
 Given an array, find the smallest and largest elements in it
 */
import java.util.Scanner;
class LargestAndSmallest{

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
		int small=arr[0];

		for(int i=0;i<arr.length;i++){
				
			if(large<arr[i]){
				large=arr[i];
			}
			if(arr[i]<small){
				small=arr[i];
			}
			
		}

		System.out.println("Small: "+small);
		System.out.println("Large: "+large);
	}
}

