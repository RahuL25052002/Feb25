import java.util.*;
class NegativePos{


	static void shiftNegative(int []arr){

		int n=arr.length;
		for(int i=0;i<n;i++){
			if(arr[i]>=0){
				int temp=arr[i];
				for(int j=i;j<n;j++){
					if(arr[j]<0){
						arr[i]=arr[j];
						arr[j]=temp;
						break;
					}
				}
			}
		
		}
			
	}

	static void shift(int []arr){

		int n=arr.length;
		int count=0;
		for(int i=0;i<n;i++){
			if(arr[i]<0){
				count++;
			}
		}
		int start=0;
		int end=n-1;
		while(count!=0){
			if(arr[start]>=0){

			//workin on this function on 


		}
	}

	public static void main(String[]args){
		
		int arr[]={-12,11,-13,-5,6,-7,5,-3,-6};
		
		shiftNegative(arr);

		System.out.println(Arrays.toString(arr));
			
	}

}
