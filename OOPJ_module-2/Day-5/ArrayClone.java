class ArrayClone{


	public static void main(String[]args){
	
		int[]arr={1,2,3,4};
		int[]clone=arr.clone();
		System.out.println(arr==clone);
		//clone[0]=5;
		/*
		 *here does not effect the memory memory 
		 location it make nre adressed for clone 
		 array

		 deep copy
		 */
		
		System.out.println(arr[0]);
		arr[0]=19;
		System.out.println(clone[0]);

	}

}
