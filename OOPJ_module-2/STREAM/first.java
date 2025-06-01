import java.util.*;
class First{
	public static void main(String[]args){
		//imperative approach
		int[]arr={1,2,3,4,5,6};
		int sum=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%2==0)
				sum+=arr[i];
		}
		System.out.println("sum by imperative :"+sum);

		//Stream
		//for understanding purpose this code is only
		Integer[]arr2={1,2,3,4,5,6,7,78,8};
		Integer sum2=Arrays.stream(arr2).
			filter(n->n%2==0);
		System.out.println("stream sum: "+sum2);
	}
}
