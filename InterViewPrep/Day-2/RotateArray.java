class Solution {


    public void reverse(int []nums,int first, int last){
        while(first<=last){
            int temp=nums[first];
            nums[first]=nums[last];
            nums[last]=temp;
            first++;
            last--;
        }
    }

    public void rotate(int[] nums, int k) {
        if(nums.length==k)
            return;
        if(nums.length==1){
            return;
        }
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
}
