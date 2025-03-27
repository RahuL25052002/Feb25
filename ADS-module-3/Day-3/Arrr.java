import java.util.*;
class Arrr{
	
	static int a[]=new int[5];
	static int n=0;

	static void display(){
		 System.out.println("====================================================");
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		 System.out.println("====================================================");
	}


	static void insert(int value){
		if(n>a.length-1){
			System.out.println("Arrays if full you can't insert data");
		}else{
			a[n]=value;
			n++;
		}
	}

	static boolean find(int key){

		for(int i=0;i<n;i++){
			if(a[i]==key){
				return true;
			}
		}
		return false;
	
	}

	static void del(int k){
		int ind=-1;
		for(int i=0;i<n;i++){
			if(a[i]==k){
				ind=i;
				break;
			}		
		}
		if(ind!=-1){
			for(int i=ind;i<n-1;i++){

				a[i]=a[i+1];
			}
			a[n-1]=0;
			n--;
		}
	}

	public static void main(String[]args){
	//	int arr[]{1,2,3,4,5,6};not working
		Scanner obj=new Scanner(System.in);
		for(int i=0;i<a.length;i++){
			System.out.print("Enter ele: ");
			insert(obj.nextInt());
		
		}
		//insert(obj.nextInt());
		display();

		int key=40;

		boolean ans=find(key);

		if(ans){
			System.out.println("Founded "+key+" in given array");
		}else{
			System.out.println(key+" Not founded in given array");
		}


		del(key);
		display();
		System.out.println(Arrays.toString(a));

		
	}

}
