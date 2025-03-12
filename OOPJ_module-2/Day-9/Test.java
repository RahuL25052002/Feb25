class A { 
	public void printValue() { 
		System.out.println("Inside A"); 
	}

	public static void callMethod(A a) { 
		a.printValue();
	}
}
class B extends A
{
public void printValue()
{
super.printValue();// invokeStatic
System.out.println("Inside B");
}

}

public class Test
{
public static void main(String[] arr)
{
    A a = new A();
    B b = new B();
    A.callMethod(a);// invokeVirtual
    A.callMethod(b);// invokeVirtual
}
}
