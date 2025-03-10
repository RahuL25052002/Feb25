interface A{
	void show();/*   Compiled from "MultipleDemo.java"
interface A {
  public abstract void show();
}
 */

}

interface B{
	void show();/*

			Compiled from "MultipleDemo.java"
interface B {
  public abstract void show();
}
		       */
}

class C implements A,B{

/*	void show(){

		System.out.println("In the C class");
	}
	MultipleDemo.java:12: error: show() in C cannot implement show() in A
        void show(){
             ^
  attempting to assign weaker access privileges; was public
1 error
we have to make void show() to public then it not giving an error;

	*/

	public void show(){

                System.out.println("In the C class");
        }

}



class MultipleDemo{
	public static void main(String[]args){
		C c1=new C();
		c1.show();
	}

}
