/*
21. Write a program to print the following pattern:
1
1*3
1*3*5
1*3*5*7
1*3*5*7*9


*/

class pattern{
	public static void main(String[]args){

		for (int i = 1; i <= 5; i++) {
			int k=1;
            		for (int j = 1; j <i*2; j++) {
                		if(j%2==0){
					System.out.print("*");
				}else{
					System.out.print(k);
					k+=2;
				}
            		}
           		System.out.println(); 
        	}
	}
}