class FindPivot{

	public static int findPivot(int []nums){
		int start = 0;
        	int end = nums.length - 1;
        	while (start <= end) {
            		int mid = start + (end - start) / 2;
            		// 4 cases over here
            		if (mid < end && nums[mid] > nums[mid + 1]) {
				/* in the if condn we use mid<end because if the mid is the last 
				 * element then mid+1 exceeding the array and we have give the
				 * arrayIndexOutBound exception thats why we have to use there.
				 * mid<end*/
                		return mid;
            		}
            		if (mid > start && nums[mid] < nums[mid - 1]) {
				/* same here like above if mid-1 excedding the 0 means it have the -1 value that s
				 * not have the index also get the then arrayIndexoutOfBound exception
				 * thats why i have firstly check the mid> start*/
                		return mid-1;
            		}
            		if (nums[mid] <= nums[start]) {
                		end = mid - 1;
            		} else {
                		start = mid + 1;
            		}
		}
		return -1;
	}
	public static void main(String[]args){
		int[]arr={9,10,11,12,2,4,5,7,8};
		System.out.println(findPivot(arr));
	}
}
