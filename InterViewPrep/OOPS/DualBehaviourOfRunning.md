# Java Dual Behavior - Static Block Execution Without Main Method

## Overview

This project demonstrates the "dual behavior" phenomenon in Java where static blocks may or may not execute when no main method is present, depending on **how you run your Java code** and **how the JVM loads classes**.

## The Phenomenon

When you have a Java class with only a static block and no main method:

```java
class P {
    static {
        System.out.println("Hey main I'm running before you run");
    }
}
```

The behavior differs based on execution method:

## Case 1: Source-File Mode (JDK 11+)

**Command:** `java P.java`

### What Happens Internally:
- The JVM **compiles your file in memory** using an internal compiler
- It looks for a `main` method in that file to execute
- If no `main` method is present → JVM throws "Main method not found" error
- **BUT** some JDK versions **load the class temporarily** to check if it has a `main` method
- This can cause the **static block to execute** before the error

### Result:
```
Hey main I'm running before you run
Error: Main method not found in class P
```

**Static block runs first, then error is thrown**

## Case 2: Traditional Compile & Run

**Commands:**
```bash
javac P.java   # produces P.class
java P         # tries to execute class P
```

### What Happens Internally:
- `javac` compiles and produces `P.class`
- `java P` loads the `P` class **only if a valid main method is found**
- If `main` is missing, the JVM throws the "main method not found" error **before loading/executing any static block**

### Result:
```
Error: Main method not found in class P
```

**The static block never runs** because the JVM doesn't bother loading the class fully when it knows there's no entry point.

## Why the Difference?

- **`java filename.java` (source-file mode)** internally uses a different process introduced in newer JDKs (9+)
- **`javac` + `java` (class-file mode)** uses the traditional approach where the JVM expects an entry point (`main`) before fully loading/executing class initialization

### Summary of Modes:
- **Source-file mode:** may partially load class → static block runs → error
- **Class-file mode:** checks for main before initialization → no static block run

## How to Force Static Block Execution Without Main

If you want to see the static block run **without a main method** intentionally:

### Method: Load Class Explicitly from Another Class

```java
class P {
    static {
        System.out.println("Hey main I'm running before you run");
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        Class.forName("P");  // loads class P → static block executes
    }
}
```

**Output:**
```
Hey main I'm running before you run
```

## Key Takeaways

1. **Dual behavior exists** due to differences between **source-file mode** and **class-file mode** in newer JDKs
2. Traditional `java P` expects `main` before loading
3. Direct `java P.java` compiles on the fly and may trigger static initialization before main check
4. Class loading can be forced explicitly using `Class.forName()` to execute static blocks without main methods

## Testing the Concept

Create a file `P.java` with only a static block and test both execution methods to observe the dual behavior in your JDK version.
