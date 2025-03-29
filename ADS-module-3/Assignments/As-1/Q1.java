/*
 * Problem 1:
Given an array of integers, perform the following operations:
1. Find the second largest element in the array.
2. Move all zeros to the end of the array while maintaining the order of non-zero
elements.
Input:
arr = [10, 0, 5, 20, 0, 8, 15]
Output:
Second largest element: 15
Array after moving zeros: [10, 5, 20, 8, 15, 0, 0]
Constraints:
● Do not use built-in sort functions.
● The array may contain duplicate elements or zeros at any position.
● Array length ≥ 2.
 */

import java.util.*;
class Q1{
	static int findSecLarge(int []arr){
		if(arr.length<2){
			return -1;
		}
		int max=arr[0];
		int secMax=-1;

		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				secMax=max;
				max=arr[i];
			}
			if(arr[i]>secMax && arr[i]<max){
				secMax=arr[i];
			}
		}
		return secMax;
	
	}

	static void shiftZero(int []arr){

		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				int temp=arr[i];
			for(int j=arr.length-1;j>i;j--){
				if(arr[j]!=0){
					arr[i]=arr[j];
					arr[j]=temp;
					break;
				}
			}
			}
		}

	}

	static void shift(int []arr){
			

		
	}
	public static void main(String[]args){
		int[]arr={10,0,5,20,0,8,15};
		int ans=findSecLarge(arr);
		if(ans!=-1){
			System.out.println("Seconnd Largedt element: "+ans);
		}else{
			System.out.println("No second Largest element is present");

		}
		shiftZero(arr);
		System.out.println(Arrays.toString(arr));

	}

}
