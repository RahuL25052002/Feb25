class HSort{

	static void heapify(int []arr,int n,int i){
		int largest=i;//parent
		int l=2*i+1;//left child
		int r=2*i+2;
		// if left child is largest
		if(l<n && arr[l]>arr[largest]){
			largest=l;
		}
		//if rigght child is largest
		if(r<n && arr[r]>arr[largest])
			largest=r;
		//if  check it not parent  or what
		if(largest!=i){
			int temp=arr[largest];
			arr[largest]=arr[i];
			arr[i]=temp;

			heapify(arr,n,largest);
		}



	}
	static void  heapsort(int[]arr){

		int n=arr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
		
		for(int i=n-1;i>0;i--){
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,i,0);
		}
	}
	static void  display(int[]arr){
		System.out.println("------------------");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"  ");
		}
		 System.out.println();
		 System.out.println("------------------");
	}
	public static void main(String[]args){
		int arr[]={99,44,77,22,33,66,11,99};
		display(arr);
		heapsort(arr);
		display(arr);
	}
}
