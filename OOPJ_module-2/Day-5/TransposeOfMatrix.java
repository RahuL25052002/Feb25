import java.util.Scanner;

class AdditionOfMatrix{

	public static void main(String[]args){
		
		Scanner obj=new Scanner(System.in);

		int[][]a=new int[3][3];
		int [][]tra=new int[3][3];
		for(int i=0;i<a.length;i++){
			System.out.println("Enter the "+i+" row Element");
			for(int j=0;j<a[i].length;j++){
				a[i][j]=obj.nextInt();
			}

		}


		for(int i=0;i<a.length;i++){      
			for(int j=0;j<a[i].length;j++){
                                tra[i][j]=a[j][i];
                        }

                }


		System.out.println("_________________________________________");
		for(int i=0;i<tra.length;i++){
                        for(int j=0;j<tra[i].length;j++){
                                System.out.print(tra[i][j]+" ");
                        }
			System.out.println();
                }

		
	}

}
