class QuickSort{
	static int partition(int[]arr,int low,int high){
		int i=low;
		int j=high;
		int pivot=arr[low];
		while(i<j){
			while(arr[i]<=pivot && i<=high-1){
				i++;
			}
			while(arr[j]>pivot && j>=low+1){
				j--;
			}
			if(i<j)
				swap(arr,i,j);
		}
		swap(arr,low,j);
		return j;
	}
	static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	static void qsort(int[]arr, int low, int high){
		if(low<high){
			
			int pi=partition(arr,low,high);
			qsort(arr,low,pi-1);
			qsort(arr,pi+1,high);
	
		}
	}
	static void display(int []arr){
		System.out.println("------------------------");
		for(int i=0;i<arr.length;i++){

			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("------------------------");
	}
	public static void main(String[]args){
		
		int[]arr={4,6,2,5,7,9,1,3};
		display(arr);
		qsort(arr,0,arr.length-1);
		display(arr);

	}
}
