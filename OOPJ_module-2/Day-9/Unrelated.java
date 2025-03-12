interface inYourFace {
    void interfaceMethod ();
}

class itsABirdItsAPlaneItsSuperClass implements inYourFace {

    itsABirdItsAPlaneItsSuperClass(int i) {
        super(); // invokespecial (of an <init>)
    }

    static void classMethod() {
    }

    void instanceMethod() {
    }

    final void finalInstanceMethod() {
    }

    public void interfaceMethod() {
    }
}

class subClass extends itsABirdItsAPlaneItsSuperClass {

    subClass() {
        this(0); // invokespecial (of an <init>)
    }

    subClass(int i) {
        super(i); // invokespecial (of an <init>)
    }

    private void privateMethod() {
    }

    void instanceMethod() {
    }

    final void anotherFinalInstanceMethod() {
    }

    void exampleInstanceMethod() {

        instanceMethod(); // invokevirtual
        super.instanceMethod(); // invokespecial

        privateMethod(); // invokespecial

        finalInstanceMethod(); // invokevirtual
        anotherFinalInstanceMethod(); // invokevirtual

        interfaceMethod(); // invokevirtual

        classMethod(); // invokestatic
    }
}

class unrelatedClass {

    public static void main(String args[]) {

        subClass sc = new subClass(); // invokespecial (of an <init>)
        subClass.classMethod(); // invokestatic
        sc.classMethod(); // invokestatic
        sc.instanceMethod(); // invokevirtual
        sc.finalInstanceMethod(); // invokevirtual
        sc.interfaceMethod(); // invokevirtual

        inYourFace iyf = sc;
        iyf.interfaceMethod(); // invokeinterface
    }
}
