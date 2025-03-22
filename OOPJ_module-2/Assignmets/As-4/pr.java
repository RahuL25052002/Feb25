interface A {
    default void msg() {
        System.out.println("A");
    }
}
interface B {
    default void msg() {
        System.out.println("B");
    }
}
class C implements A, B {

    @Override
    public void msg() {
        A.super.msg(); // Call A msg()
        B.super.msg(); // Call B msg()
        System.out.println("C"); 
    }
}
class pr {
    public static void main(String[] args) {
        C c1 = new C();
        c1.msg();
	/*if you not ovveride msg() method in C class then it gave an error because it create an ambigiuty which class method msg() to be call 
	 * and this probelm is also knowm as diamond problem
	 *
	 */
    }
}
