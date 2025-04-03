class SelectionSort{
	static void sSort(int []arr){

		int n=arr.length;
		for(int i=0;i<n-1;i++){
			int min=i;
			for(int j=0;j<n;j++){
				if(arr[j]<arr[min])
					min=j;
			}
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
	}

	static void display(int []arr){

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[]args){
		int arr[]={2,6,5,8,1,7,3,4};
		display(arr);
		bSort(arr);
		System.out.println();
		System.out.println("------------------------");
		display(arr);
	}
}
