# Java Inheritance - Main Method Execution

## Concept Demonstration

This project demonstrates how inheritance works in Java when a child class doesn't have its own `main` method but the parent class does.

## Code Structure

```java
class MainMethod{
    public static void main(String[]args){
        System.out.println("Hello Im your Parent");
    }
}

class child extends MainMethod{
}
```

## Key Concept

When you run the bytecode of the `child` class (`java child`), even though the child class doesn't have its own `main` method, it will still execute successfully. This happens because:

- The `child` class extends `MainMethod` class
- Through inheritance, the child class inherits the parent's `main` method
- When you execute `java child`, the JVM finds and runs the inherited `main` method from the parent class

## Execution Result

![Terminal Output](image_showing_terminal_execution.png)

As shown in the terminal:
- Both `java MainMethod` and `java child` produce the same output: "Hello Im your Parent"
- This proves that the child class successfully inherits and executes the parent's main method

## Files Generated
- `MainMethod.class` - Bytecode for parent class
- `MainMethod.java` - Source file
- `child.class` - Bytecode for child class (inherits main method)

## Summary

If we don't write a `main` method in the child class and run the bytecode of the child class, it will work because the parent's main method runs at that time due to inheritance.
