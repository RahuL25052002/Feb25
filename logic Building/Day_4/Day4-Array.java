class ArrayDemo{
	public static void main(String[]args){
		
		int a[][]={
				{1,2},//jagged array it is
				{3,4,5,6,7},
				{8,9,10}
			};

		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		/*
		Array is store value in continous memory allocation
		where 
			0  1  2
			---------
		      0	| |  |  |
			---------
		      1	| |  |  |
			---------
		      2	| |  |  |
			---------
		2d array represntation it can store in this way but 			it just the graphical representation actually array store 
		its value in the  continous manner
		
		actual storation of elements
		__________________
		| | | | | | | | | |
		-------------------
		in this way it actually store the elements in memory
		continous address location

		*/		
	}
}