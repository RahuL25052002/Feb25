import java.util.*;
class LongConsSequence{
	
    public static  int longestConsecutive(int[] nums) {
        if(nums.length==0){//if the length is zero then we have to return 0;
            return 0;
        }
        // then we have the sorted the array
        Arrays.sort(nums);

        // i took 2 varraible to store count and max variable.
        int count=1;
        int max=1;

        // for traverse the array and check the consecutive element if yes then increment
        //count and also add and also last we have assign to max if count is max then assign max likewise.

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                continue;
            }

            if(nums[i-1]+1==nums[i]){
                count++;
            }else{
                count=1;
            }
            max=Math.max(count,max);// take max betn max and count
        }
        return max;
    }
	public static void main(String[]args){
		int arr[]={2,3,1,100,200,4};
		int ans=longestConsecutive(arr);
		System.out.println("Longest consecutive sequence length: "+ans);
	}
}
