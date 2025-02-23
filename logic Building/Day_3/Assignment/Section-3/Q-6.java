//6. Write a program to find and print the first 5 prime numbers.

class first5PrimeNumber{
	public static void main(String[]args){
		int count=1;
		for(int i=1;i<100;i++){
			int cnt=0;
			for(int j=1;j<=i;j++){
				if(i%j==0)
					cnt++;
			}
			if(cnt==2){
				System.out.print(i+" ");
				count++;
			}
			if(count>5)
				break;
		}		
	}
}

//o/p:-2 3 5 7 11