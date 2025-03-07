import java.util.Scanner;

class AdditionOfMatrix{

	public static void main(String[]args){
		
		Scanner obj=new Scanner(System.in);

		int[][]a=new int[3][3];
		int[][]b=new int[3][3];

		int [][]sub=new int[3][3];




		int count=1;
		while(count<=2){
			 System.out.println("_________________________________________");
			  System.out.println("Enter the "+count+" array elements");
			for(int i=0;i<a.length;i++){
				System.out.println("Enter the "+i+" row Element");
				for(int j=0;j<a[i].length;j++){
					if(count==1){
						a[i][j]=obj.nextInt();
					}else{
						b[i][j]=obj.nextInt();
					}
				}

			}
			count++;

		}
		for(int i=0;i<sub.length;i++){
			for(int j=0;j<sub[i].length;j++){
				sub[i][j]=a[i][j]-b[i][j];
			}
		}


		System.out.println("_________________________________________");
		System.out.println("Subtraction of two matrix in one matrix: ");
		for(int i=0;i<sub.length;i++){
                        for(int j=0;j<sub[i].length;j++){
                                System.out.print(sub[i][j]+" ");
                        }
			System.out.println();
                }

		
	}

}
