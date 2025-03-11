/*
 6. Remove Duplicates from a Sorted Array
○ Remove duplicate elements from a sorted array without using extra space
 */
import java.util.Scanner;
class RemoveDuplicate{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Array size: ");
		int size=obj.nextInt();

		int arr[]=new int[size];


		System.out.println("Enter array element: ");
		for(int i=0;i<arr.length;i++){

			arr[i]=obj.nextInt();
		}



	}
}

