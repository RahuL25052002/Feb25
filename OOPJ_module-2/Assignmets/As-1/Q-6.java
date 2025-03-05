
//6. Write a program to display character and string literals along with their ASCII values.
class Test{
	public static void main(String[]args){
		char ch ='a';
		System.out.println((int)ch);

		String str="Rahul";
		for(int i=0;i<str.length();i++){
			System.out.println((int)str.charAt(i));
		}

	}

}

