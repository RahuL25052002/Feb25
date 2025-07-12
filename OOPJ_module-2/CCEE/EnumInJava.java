import java.util.Scanner;

// Enum for Arithmetic Operations
enum ArithmeticOperation {
    EXIT, SUM, SUBTRACT, MULTIPLY, DIVIDE
}

public class EnumInJava{

    // Arithmetic operation methods
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return a / b;
    }

    // Method to display result
    public static void printResult(int result) {
        System.out.println("Result: " + result);
    }

    // Menu method to display options and get user choice
    public static ArithmeticOperation menuList(Scanner scanner) {
        System.out.println("\n===== MENU =====");
        System.out.println("0. Exit");
        System.out.println("1. Sum");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice < 0 || choice > 4) {
            System.out.println("Invalid choice. Try again.");
            return menuList(scanner);
        }

        return ArithmeticOperation.values()[choice];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticOperation choice;

        while ((choice = menuList(scanner)) != ArithmeticOperation.EXIT) {
            int result = 0;
            int num1 = 100, num2 = 20; // You can also ask the user for input here

            switch (choice) {
                case SUM:
                    result = sum(num1, num2);
                    break;
                case SUBTRACT:
                    result = subtract(num1, num2);
                    break;
                case MULTIPLY:
                    result = multiply(num1, num2);
                    break;
                case DIVIDE:
                    result = divide(num1, num2);
                    break;
            }

            printResult(result);
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}

