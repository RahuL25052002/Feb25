# Java Method Overloading - Complete Guide

## What is Method Overloading?

Method overloading is a feature in Java that allows a class to have **multiple methods with the same name** but **different parameters**. It's a form of **compile-time polymorphism**.

## Method Signature Rules

Method overloading is determined by the **method signature**, which includes:
- ✅ Method name
- ✅ Number of parameters
- ✅ Type of parameters
- ✅ Order of parameters
- ❌ **Return type is NOT part of the signature**

## Valid Overloading Examples

```java
class Calculator {
    
    // 1. Different number of parameters
    public int add(int a, int b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // 2. Different parameter types
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    // 3. Different parameter order
    public void display(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public void display(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
    
    // 4. Different return types are allowed IF parameters differ
    public int getValue(int x) {
        return x * 2;
    }
    
    public String getValue(String x) {
        return "Value: " + x;
    }
}
```

## Invalid Overloading Examples

### ❌ Cannot Overload Based on Return Type Alone

```java
class Test {
    public int getValue() {
        return 10;
    }
    
    public String getValue() {  // Compilation Error!
        return "Hello";
    }
}
```

**Error:** `method getValue() is already defined in class Test`

### ❌ Cannot Overload Based on Access Modifiers

```java
class Test {
    public void method() { }
    
    private void method() { }  // Compilation Error!
}
```

### ❌ Parameter Names Don't Matter

```java
class Test {
    public void method(int x) { }
    
    public void method(int y) { }  // Compilation Error!
}
```

## Why Return Type Cannot Be Used for Overloading

Consider this method call:
```java
Test obj = new Test();
obj.getValue();  // Which method should the compiler choose?
```

The compiler cannot determine which method to call because:
- Both methods have the same name and parameters
- Return type is not specified in the method call
- Java resolves method calls at **compile-time** based on method name and arguments only

## Overloading with Type Promotion

Java supports automatic type promotion in overloading:

```java
class TypePromotion {
    public void method(int x) {
        System.out.println("int method: " + x);
    }
    
    public void method(double x) {
        System.out.println("double method: " + x);
    }
}

// Usage
TypePromotion obj = new TypePromotion();
obj.method(10);      // Calls int method
obj.method(10.5);    // Calls double method
obj.method('A');     // Calls int method (char promoted to int)
```

## Overloading with Varargs

```java
class VarargsExample {
    public void method(int x) {
        System.out.println("Single int: " + x);
    }
    
    public void method(int... x) {
        System.out.println("Varargs: " + Arrays.toString(x));
    }
}

// Usage
VarargsExample obj = new VarargsExample();
obj.method(10);        // Calls single int method (exact match preferred)
obj.method(10, 20);    // Calls varargs method
obj.method();          // Calls varargs method with empty array
```

## Best Practices

1. **Keep related functionality together** - Only overload methods that perform similar operations
2. **Maintain consistent behavior** - All overloaded methods should behave similarly
3. **Avoid ambiguous overloading** - Don't create overloads that could confuse the compiler or developers
4. **Use descriptive names when overloading isn't suitable** - Sometimes different method names are clearer

## Common Pitfalls

### Ambiguous Method Calls
```java
class Ambiguous {
    public void method(int x, double y) { }
    public void method(double x, int y) { }
}

// This call is ambiguous:
// obj.method(10, 20);  // Compilation error!
```

### Wrapper Classes vs Primitives
```java
class WrapperExample {
    public void method(int x) { }
    public void method(Integer x) { }
}

// Be careful with autoboxing/unboxing
```

## Real-World Example

```java
class FileProcessor {
    // Process from file path
    public void process(String filePath) {
        // Read file and process
    }
    
    // Process from File object
    public void process(File file) {
        // Process file object
    }
    
    // Process from InputStream
    public void process(InputStream stream) {
        // Process stream
    }
    
    // Process with custom options
    public void process(String filePath, ProcessingOptions options) {
        // Process with custom configuration
    }
}
```

## Summary

- **Method overloading** enables multiple methods with the same name but different parameters
- **Method signature** determines overloading (name + parameters, NOT return type)
- **Compile-time resolution** - Java decides which method to call at compile time
- **Cannot overload** based on return type alone, access modifiers, or parameter names
- **Useful for** providing multiple ways to call similar functionality with different input types or counts
