/*448. Find All Numbers Disappeared in an Array
Easy
Topics
premium lock icon
Companies
Hint
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the 
returned list does not count as extra space.*/


import java.util.*;

class FindAllMissNumber{


	public static List<Integer> findAll(int []arr){
		int i=0;
		while(i<arr.length){
			int correct=arr[i]-1;// beacuase the the this is 1-indexed based array.
			if(arr[i]!=arr[correct]){
				int temp=arr[correct];
				arr[correct]=arr[i];
				arr[i]=temp;
			}else{
				i++;
			}
			
		}	

		List<Integer> ans=new ArrayList<>();

		for(int j=0;j<arr.length;j++){

			if(arr[j]!=j+1){
				ans.add(j+1);
			}
		}
		return ans;
		
	}
	public static void main(String[]args){
		
		/*
		 * Input: nums = [4,3,2,7,8,2,3,1]
		   Output: [5,6]
		 */

		int arr[]={4,3,2,7,8,2,3,1};
		List<Integer> ans=findAll(arr);
		System.out.println(ans);

	}
}
