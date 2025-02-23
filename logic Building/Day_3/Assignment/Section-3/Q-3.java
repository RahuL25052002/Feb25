//3. Write a program to print all multiples of 7 between 1 and 100.

class MultipleOf7{
	public static void main(String[]args){
		System.out.print("Multiple of 7: ");
		for(int i=7;i<100;i++){
		
			if(i%7==0){
				System.out.print(i+" ");
			}
		}	
	}
}

//o/p: Multiple of 7: 7 14 21 28 35 42 49 56 63 70 77 84 91 98