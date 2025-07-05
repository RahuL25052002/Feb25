class Program {

    // Static method using varargs to accept any number of int arguments
    private static void sum(int... arguments) {
        int result = 0;
        for (int element : arguments) {
            result = result + element;
        }
        System.out.println("Result : " + result);
    }

    public static void main(String[] args) {
        Program.sum();                                           // No arguments
        Program.sum(10, 20);                                     // 2 arguments
        Program.sum(10, 20, 30, 40, 50);                         // 5 arguments
        Program.sum(10, 20, 30, 40, 50, 60, 70);                 // 7 arguments
        Program.sum(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);    // 10 arguments
    }
}
//varibal argument also in the java but int... arguments three 3 dots we use for
