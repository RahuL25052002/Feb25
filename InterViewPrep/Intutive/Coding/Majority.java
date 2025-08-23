import java.util.*;
class Majority{

	public static int majorElement(int []arr){
		
		Map<Integer,Integer> mp=new HashMap<>();

		int n=arr.length;
		for(int num:arr){
			mp.put(num,mp.getOrDefault(num,0)+1);

			if(mp.get(num)>n/2)
				return num;


		
		}
		return -1;
	}

	public static void main(String[]args){
		
		int[]arr={2,2,1,1,1,2,2,2};
		int ans=majorElement(arr);
		System.out.println(ans);
	
	}
}
