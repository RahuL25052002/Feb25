class BubbleSort{
	static void bSort(int []arr){

		for(int i=0;i<arr.length-1;i++){
			boolean isIter=false;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					isIter=true;
				}
			}
			if(!isIter){
				break;
			}
			System.out.println(arr[arr.length-1-i]);
		}
	}
	static void iSort(int arr[]){
		int n = arr.length;
		for(int i=1;i<n;i++){
			int key = arr[i];//element to be shifted
			int j=i-1;

			//shifting elements
			while(j>=0 && arr[j] > key){
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = key;
		}

	}


	static void display(int []arr){

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[]args){
		int arr[]={5,3,4,1,2};
		display(arr);
		iSort(arr);
		System.out.println();
		System.out.println("------------------------");
		display(arr);
	}
}
