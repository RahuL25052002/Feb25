import java.util.*;
class Duplicate{
	static TreeSet<Integer> dup(int []arr){
		
		TreeSet<Integer> check=new TreeSet();
		TreeSet<Integer> ans=new TreeSet<>();
		for(int i=0;i<arr.length;i++){
			if(!check.contains(arr[i]))
				check.add(arr[i]);
			else
				ans.add(arr[i]);
		
		}
		//ArrayList<Integer> ans=new ArrayList<>();

		return ans;
	
	}

	 static void dup1(int []arr){
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]==arr[i+1]){
				System.out.println(arr[i+1]);
				i=i+1;
			}
		}
        }
	public static void main(String[]args){

		int arr[]={2,2,3,4,5,4,5};
		
		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr);
		dup1(arr);
		System.out.println(Arrays.toString(arr));

		TreeSet<Integer> ans=dup(arr);
		System.out.println(ans);


	}

}
