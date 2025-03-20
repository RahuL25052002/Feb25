
interface Hello{

	void sayHello();
}
class LambdaEx{
	public static void main(String[]args){
		Hello h1=() -> System.out.println("Lambda function");
		h1.sayHello();
	}
}
