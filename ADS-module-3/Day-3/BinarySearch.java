class BinarySearch{

	static int bs(int []arr,int k){

		int l=0;
		int h=arr.length-1;
	//	int mid=l+(h-l)/2;
		while(l<=h){
			int mid=(l+h)/2;
			if(arr[mid]==k){
				return mid;
			}else if(arr[mid]>k){
				h=mid-1;
			}else if(arr[mid]<k){
				l=mid+1;
			}
		}
		return -1;
	
	}
	static int bsByRec(int arr[],int x,int l,int h){
			
		if(h>=l){
			int mid=l+(h-l)/2;
			if(arr[mid]==x)
				return mid;
			if(arr[mid]>x)
				return bsByRec(arr,x,l,mid-1);
			if(arr[mid]<x)
				return bsByRec(arr,x,mid+1,h);
		}
		return -1;

		
	}
	public static void main(String[]args){
		
		int []arr={20,35,37,40,45,50,51,55,67};
		int ans=bsByRec(arr,45,0,arr.length-1);

		if(ans!=-1){
			System.out.println("Founded at index: "+ans);
		}else{
			System.out.println("Not founded");
		}

	}
}
