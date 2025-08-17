class PeakNumber{

	public static int peakIndex(int []arr){
		int start=0;
		int end=arr.length-1;
		while(start<end){

			int mid=start+(end-start)/2;
			if(arr[mid]>arr[mid+1]){
				end=mid;/* here we use end=mid because there are more chances if the if the mid-1 also greter then its mid that why in particular part we have to also check  and also the mid also may be the peak thats why we have not use the mid-1 just i check assign end to the mid;
					   */
			}else{
				start=mid+1;
			}
		}
		return start;// beacause both end and start pointing to the highest one thats 
			     // why just return the start;
	}	
	public static void main(String[]args){

		int[] arr = {3, 5, 7, 9, 10, 90,100, 90, 40, 30, 17};

        	System.out.println(peakIndex(arr));
	}
}
