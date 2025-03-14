/*
 6. Remove Duplicates from a Sorted Array
○ Remove duplicate elements from a sorted array without using extra space
 */
import java.util.*;
class RemoveDuplicate{

	static int removeDuplicates(int[] arr) {
        	int n = arr.length;
        	if (n <= 1)
            		return n;

               	int idx = 1;

     	   	for (int i = 1; i < n; i++) {
        	    if (arr[i] != arr[i - 1]) {
                	arr[idx++] = arr[i];
            		}
                }
        	return idx;
    	}

	public static void main(String[]args){
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Array size: ");
		int size=obj.nextInt();

		int arr[]=new int[size];


		System.out.println("Enter array element: ");
		for(int i=0;i<arr.length;i++){

			arr[i]=obj.nextInt();
		}
		int newSize = removeDuplicates(arr);
		System.out.println("After removing duplicate elements:" );

        	for (int i = 0; i < newSize; i++) {
            		
			System.out.print(arr[i] + " ");
        	}
		System.out.println(Arrays.toString(arr));
	}
}

