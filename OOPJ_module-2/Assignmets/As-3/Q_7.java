/*
 * 7. Rotate an Array
○ Rotate the array to the right by k positions
 
 */
import java.util.*;
class RotateRightKtimes{

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Array size: ");
		int n=obj.nextInt();

		int arr[]=new int[n];


		System.out.println("Enter array element: ");
		for(int i=0;i<arr.length;i++){

			arr[i]=obj.nextInt();
		}
		System.out.println("Enter the value k: ");
		int k=obj.nextInt();

		k=k%n;

		int i, j;
        	for (i = n - k, j = n - 1; i < j; i++, j--) {
            		int temp = arr[i];
            		arr[i] = arr[j];
            		arr[j] = temp;
        		
		}
        	for (i = 0, j = n - k - 1; i < j; i++, j--) {
            		int temp = arr[i];
            		arr[i] = arr[j];
            		arr[j] = temp;
        	}
        	for (i = 0, j = n - 1; i < j; i++, j--) {
            		int temp = arr[i];
            		arr[i] = arr[j];
            		arr[j] = temp;
        	}

        	for (int t = 0; t < n; t++) {
            		System.out.print(arr[t] + " ");
        	}
	}
}
