class ShortestUnsortedSubarry{

	public static int findUnsortedSubarray(int[] nums) {
        int start=0;
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                continue;
            }else{
                start=i;
                break;
            }
        }

	System.out.println("start : "+start);

        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                continue;
            }else{
                end=i;
                break;
            }
        }
	System.out.println("end: "+end);
        int ans=end-start+1;
        return ans;
    }
	public static void main(String[]args){
		int []arr={2,6,4,8,10,9,15};
		int ans=findUnsortedSubarray(arr);
		System.out.println(ans);
	}
}
