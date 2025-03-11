/*
 *1. Find the Largest and Smallest Element
 Given an array, find the smallest and largest elements in it
 */
import java.util.Scanner;
class Reverse{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Array size: ");
		int size=obj.nextInt();

		int arr[]=new int[size];


		System.out.println("Enter array element: ");
		for(int i=0;i<arr.length;i++){

			arr[i]=obj.nextInt();
		}

		System.out.println("Before Reverse: ");

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

		System.out.println();
		System.out.println("-----------------");

		int temp=0;
		int i=0;
		int j=arr.length-1;

		while(i<=j){
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		System.out.println("Reverse an Array: ");
		for(int l=0;l<arr.length;l++){
			System.out.print(arr[l]+" ");
		}
	}
}

