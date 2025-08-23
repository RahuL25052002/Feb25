/*
 *
 * Array Rotation Check

Problem:
Given two arrays arr1 and arr2 of equal length, determine if arr2 is a rotation of arr1.
Return True or False.

Examples:

arr1 = [1, 2, 3, 4, 5]
arr2 = [3, 4, 5, 1, 2]   -> True

arr1 = [1, 2, 3]
arr2 = [2, 1, 3]         -> False


Constraints:

1 ≤ n ≤ 2×10^5

Elements can repeat.

Time target: O(n)

Hint: Use hashing to map first occurrence and verify rotation length, or join technique (for strings) / KMP on arrays.
 */
import java.util.*;
class ArrayRota{

	public static boolean isRotate(int []arr1,int []arr2){
		
		if(arr1.length!=arr2.length)
			return false;

		StringBuilder sb=new StringBuilder();

		for(int num:arr1){
			sb.append(num).append(",");
		}
		sb=sb.append(sb);
		System.out.println(sb);

		StringBuilder sb2=new StringBuilder();
		for(int num:arr2){
			sb.append(num).append(",");
		}

	
		String s1=sb.toString();
		String s2=sb2.toString();
		if(s1.contains(s2)){
			return true;
		}
		return false;
	
	}

	public static void main(String[]args){
		
		int[]arr1={1,2,3,4,5};
		int[]arr2={3,4,5,1,2};
		System.out.println(isRotate(arr1,arr2));

	}
}
