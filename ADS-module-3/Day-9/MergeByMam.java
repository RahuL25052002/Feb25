/*
 * efficient sorting techinque O(nlogn); time complexity
 * every case  it gave in O(nlogn) time complexity gives
 * space complexity O(n);
 *
 * stable sort this is..
 *
 */

class MergeByMam{
	static void mergeSort(int[]arr,int l,int r){
		if(l<r){
			int mid=l+(r-l)/2;
			mergeSort(arr,l,mid);//for leftside 
			mergeSort(arr,mid+1,r);//for  right;
			merge(arr,l,mid,r);//merging sort
			//stable sort 
		}
	}
	static void merge(int arr[],int l,int mid,int r){
		int n1=mid-l+1;
		int n2=r-mid;
		int L[]=new int[n1];
		int R[]=new int[n2];
		for(int i=0;i<n1;i++){
			L[i]=arr[i+l];
		}
		for(int i=0;i<n2;i++){
			R[i]=arr[mid+i+1];
		}
		int i=0,j=0;
		int k=l;
		while(i<n1 && j<n2){
			if(L[i]<R[j]){
				arr[k]=L[i];
				i++;
			}else{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1){
			arr[k]=L[i];
			i++;
			k++;
		}
		 while(j<n2){
                        arr[k]=R[j];
                        j++;
                        k++;
                }

	}
	static  void  display(int[]arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[]args){

		int arr[]={3,4,5,2,1,6,8,7};
		display(arr);
		System.out.println();
		System.out.println("---------------------------");
		mergeSort(arr,0,arr.length-1);
		display(arr);

	}
}
