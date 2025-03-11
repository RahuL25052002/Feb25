class MethodOverloading{
	static int add(int a,int b){
		return a+b;
	}
/*
 *
 * Method Overloading : Same name with different paramter
 * it checks the methid signature at the compile time 
 * thats why ata comiple time it gfet check and if it found aby method signature same then it gave an error 
 *
 *
 * this is method overloadin or compile time polymorphism or static binding called
 *
 *
 * yes we can overload main method 
 *best techinacal example is println() method
 give an interview
 *
 *
 *
 *
 *
 *
 *
 *
 *
	int add(int a, int b){
		return a+b;
	}
 method add(int,int) is already defined in class MethodOverloading
        int add(int a, int b){
            ^
	*/
	public static int main(){
		return 10+12;
	}
	public static void main(String name){

		System.out.println(name);
	}
	public static void main(String[]args){

		MethodOverloading mo=new MethodOverloading();
		System.out.println(add(4,5));
		main("Rahul");
		System.out.println(main());
	}

}
