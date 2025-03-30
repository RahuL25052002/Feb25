class Q3{
	static int binarySearch(int []arr,int key){
		
		int s=0;
		int e=arr.length-1;
		while(s<e){
			int mid=s+(e-s)/2;
			if(arr[mid]==key){
				return mid;
			}else if(arr[mid]>key){
				e=mid-1;
			}else{
				s=mid+1;
			}

		}
		return -1;

	}

	  static int[] firstOcc(int []arr,int key){

            	int[]ans={-1,-1};

		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				if(ans[0]==-1)
					ans[0]=i;
				ans[1]=i;
			}
		}
		return ans;

        }

	 static int peakEl(int arr[]){
        	int start=0;
        	int end=arr.length-1;
        	while(start<end){
            		int mid=start+(end-start)/2;
            		if(arr[mid]>arr[mid+1])
                		end=mid;
            		else
                		start=mid+1;

        	}
        	return arr[start];//beacause both will be point to the highest one
    	}

	static int totalCountKey(int[] arr,int key){
			
		int count=0;
		for(int i=0;i<arr.length;i++){
			
			if(arr[i]==key){
				count++;
			}
			if(arr[i]>key){
				return count;
			}
	
		}
		return count;
	
	}
	public static void main(String[]args){
	
		int arr[]={1,3,3,3,4,6,8};
		int key=3;
		int ind=binarySearch(arr,key);
		if(ind!=-1){
			System.out.println("Index of "+key+" is "+ind);

		}else{
			System.out.println("Not Found");
		}

		int ans3[]=firstOcc(arr,key);
		System.out.println("First: "+ans3[0]+" Last: "+ans3[1]);
		//System.out.println(ans3);
		int ans4=totalCountKey(arr,key);
		System.out.println("Total count: "+ans4);
		int arr2[]={1,2,18,4,5,0};
		int peak=peakEl(arr2);
		System.out.println(peak);
	}
}
