class MissingNumber{


	public static int missNumber(int []arr){

		/* for finding the missing number we have to do 
		 * or use the Cyclic sort means cyclic sort done that sort */
		int i=0;// for first index we start to check its correct index or not
	
		while(i<arr.length){//this is termination condin 
			
			int correct=arr[i];// we check the 
			if(arr[i]>=0 && arr[i]<arr.length && arr[i]!=arr[correct]){

				int temp=arr[correct];
				arr[correct]=arr[i];
				arr[i]=temp;
			}else{
				i++;
			}
		}
		/*now abve loop is for sorting and sort the element on the basis of index
		 *
		 * now below we check if the element is not index means that particular index is missing 
		 */
		// 
		for(int j=0;j<arr.length;j++){
			if(arr[j]!=j){
				return j;
			}
		}
		return arr.length;// if all re same means the last element means .. arr.length is missing number

	}

	public static void main(String[]args){
		int arr[]={0,3,2,4,5,1,9,6,7};
		int ans=missNumber(arr);
		System.out.println("Missing number is: "+ans);
	}

}
