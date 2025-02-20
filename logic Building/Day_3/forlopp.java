class loops{
	public static void main(String[] args){
	/*
		for(int i=0; ;i--){
			System.out.println("Hello!!");
		}
		This for loop goes into the infinite loop 
		because by default there value present is true

	*/

	/*
		int a=10;
		for(System.out.println("hello");a>=5;a--){
			System.out.println(a);
		}
		
	`````````it also works it gives op hello
						10
						9
						8
						7
						6
		but not a way of good practise is.
	*/
		int a=10;
		for(;a>=5;System.out.println("hello")){
			System.out.println(a);
			a--;
		}
			it also run the code java loops
	
					java loops
				10
				hello
				9
hello
8
hello
7
hello
6
hello
5
hello
		
	}		
}