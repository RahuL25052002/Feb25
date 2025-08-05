class Solution {
    public static int maxSubArray(int[] arr) {

        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0)
                sum=0;
        }

        return max;
    }
    public static void main(String[]args){
	    int []arr={1,3,4,4,2,3,4,3,23,32,3};
	    System.out.println(maxSubArray(arr));
    }
}
