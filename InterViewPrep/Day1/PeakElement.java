class Solution {
    public int findPeakElement(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while(s<e){
            int mid=(s+e)/2;
            if(arr[mid]>arr[mid+1])
                e=mid;
            else
                s=mid+1;
        }
        return s;
    }
    public static void main(String[]args){
	int arr[]={1,2,1,3,5,6,4};
	Solution obj=new Solution();
	int ans=obj.findPeakElement(arr);
	System.out.println(ans);
    }
  
}
