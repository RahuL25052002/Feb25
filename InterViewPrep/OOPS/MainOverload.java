class MainOverload{

	public static void main(String[]args){

		System.out.println("In main");
		int []arr={1,2,3,4};
		main(arr);
		}
	public static void main(int[]arr){
		System.out.println("IN arr main");
	}
}
