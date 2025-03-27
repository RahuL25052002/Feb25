import java.util.*;
class Search{
	
	static int search(int []arr,int val){
		int n=arr.length;
		if(arr[n-1]==val){
			return n-1;

		}
		if(arr[0]==val){
			return 0;
		}

		for(int i=0;i<n;i++){

			if(arr[i]==val){
				return i;
			}
		}
		return -1;
	
	}
	public static void main(String[]args){
		
		int arr[]={10,20,50,30,70,40};

		int ans=search(arr,50);
		if(ans!=-1){
			System.out.println("Founded in index: "+ans);
		}else{
			System.out.println("Not Founded");
		}	
	}

}
