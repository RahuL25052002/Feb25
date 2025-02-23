/*
20. Write a program to print the following pattern:
5
5*4
5*4*3
5*4*3*2
5*4*3*2*1

*/

class pattern{
	public static void main(String[]args){

		for (int i = 1; i <= 5; i++) {
			int k=5;
            		for (int j = 1; j <i*2; j++) {
                		if(j%2==0){
					System.out.print("*");
				}else{
					System.out.print(k);
					k--;
				}
            		}
           		System.out.println(); 
        	}
	}
}