class Parent {
    static void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    static void greet() {
        System.out.println("Hello from Child");
    }
}

class Test {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.greet(); // Output?
    }
}

