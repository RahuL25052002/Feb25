class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])//if number is same then skip if not same
                continue;
            nums[k++]=nums[i+1]; // if not same then in the the next we swap the non-match element
        } 
        return k;       
    }

}
