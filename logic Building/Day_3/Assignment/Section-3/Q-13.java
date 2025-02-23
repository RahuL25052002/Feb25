/*
13. Write a program to print the following pattern:
1
2*2
3*3*3
4*4*4*4
5*5*5*5*5
5*5*5*5*5
4*4*4*4
3*3*3
2*2
1

*/

class pattern{
	public static void main(String[]args){
		int num=1;
		for(int i=1;i<=5;i++){
			for(int j=1;j<i*2;j++){
				if(j%2!=0)
					System.out.print(num);
				else
					System.out.print("*");
			}
			num++;
			System.out.println();
		}
		num=5;
 		for (int i = 5; i >= 1; i--) {
            		for (int j = 1; j < i * 2; j++) {
                		if (j % 2 != 0)
                    			System.out.print(num);
                		else
                    			System.out.print("*");
            		}
            		num--;
            		System.out.println();
		 }	
	}
}	