/*
23. Write a program to print the following pattern:
11111
22222
33333
44444
55555
*/

class pattern{
	public static void main(String[]args){

		for (int i = 1; i <= 5; i++) {
            		for (int j = 1; j <=5; j++) {
                		System.out.print(i);	
            		}
           		System.out.println(); 
        	}
	}
}