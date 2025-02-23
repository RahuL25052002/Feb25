//9. Write a program to find and print the largest digit in the number 4825.

class LargestDigit{
	public static void main(String[]args){
	
		int large=0;
		int num=4825;
		int temp=num;
		while(num!=0){
			if(large<num%10){
				large=num%10;
			}
			num=num/10;
		}
		System.out.println("largest digit in the number 4825 is: "+large);

	}
}

//op largest digit in the number 4825 is: 8