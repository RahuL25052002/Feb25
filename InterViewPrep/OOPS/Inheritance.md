
# Java Inheritance - Complete Guide

## What is Inheritance?

**Inheritance** is a fundamental concept in Object-Oriented Programming (OOP) where a **child class (subclass)** inherits properties and methods from a **parent class (superclass)**. It establishes an **"IS-A"** relationship between classes.

Think of it like family inheritance - just as you inherit traits from your parents, classes can inherit features from other classes.

## Basic Syntax

java

```java
class ParentClass {
    // Parent class members
}

class ChildClass extends ParentClass {
    // Child class inherits everything from ParentClass
    // Plus can add its own unique features
}
```

## Real-World Example: Vehicle Inheritance System

Let me explain inheritance with a practical example:

java

```java
// Parent class - Vehicle
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    // Common methods all vehicles have
    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }
    
    public void stop() {
        System.out.println(brand + " " + model + " has stopped.");
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + 
                          ", Year: " + year + ", Price: $" + price);
    }
}

// Child class - Car inherits from Vehicle
class Car extends Vehicle {
    private int doors;
    private String fuelType;
    
    public Car(String brand, String model, int year, double price, 
               int doors, String fuelType) {
        super(brand, model, year, price); // Call parent constructor
        this.doors = doors;
        this.fuelType = fuelType;
    }
    
    // Car-specific method
    public void openTrunk() {
        System.out.println("Car trunk is now open.");
    }
    
    // Override parent method with car-specific behavior
    @Override
    public void start() {
        System.out.println("Car engine starting... *vroooom*");
    }
}

// Child class - Motorcycle inherits from Vehicle  
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    
    public Motorcycle(String brand, String model, int year, double price, 
                     boolean hasSidecar) {
        super(brand, model, year, price);
        this.hasSidecar = hasSidecar;
    }
    
    // Motorcycle-specific method
    public void popWheelie() {
        System.out.println("Motorcycle is doing a wheelie! 🏍️");
    }
    
    // Override parent method
    @Override
    public void start() {
        System.out.println("Motorcycle engine roaring to life... *VROOOM*");
    }
}
```

## Usage Example:

java

```java
public class InheritanceDemo {
    public static void main(String[] args) {
        // Create objects
        Vehicle vehicle = new Vehicle("Generic", "Vehicle", 2020, 15000);
        Car car = new Car("Toyota", "Camry", 2023, 25000, 4, "Gasoline");
        Motorcycle bike = new Motorcycle("Harley", "Sportster", 2022, 12000, false);
        
        // All can use inherited methods
        vehicle.start();    // Generic vehicle start
        car.start();        // Overridden car start  
        bike.start();       // Overridden motorcycle start
        
        // Child classes have their own unique methods
        car.openTrunk();    // Only cars have trunks
        bike.popWheelie();  // Only motorcycles can do wheelies
        
        // All inherit displayInfo() method
        vehicle.displayInfo();
        car.displayInfo();
        bike.displayInfo();
    }
}
```

## Major Advantages of Inheritance

### 1. **Code Reusability** 🔄

java

```java
// Instead of writing this for every vehicle type:
class Car {
    String brand, model;
    int year;
    double price;
    
    void start() { /* same code */ }
    void stop() { /* same code */ }
    void displayInfo() { /* same code */ }
    // ... duplicate code everywhere
}

class Motorcycle {
    String brand, model; // DUPLICATE!
    int year;            // DUPLICATE!
    double price;        // DUPLICATE!
    // ... more duplicates
}

// With inheritance, write once, use everywhere:
class Vehicle { /* common code here */ }
class Car extends Vehicle { /* only car-specific code */ }
class Motorcycle extends Vehicle { /* only bike-specific code */ }
```

### 2. **Method Overriding** (Runtime Polymorphism) 🎭

java

```java
Vehicle[] vehicles = {
    new Car("Honda", "Civic", 2023, 22000, 4, "Hybrid"),
    new Motorcycle("Yamaha", "R1", 2023, 17000, false),
    new Vehicle("Generic", "Transport", 2020, 10000)
};

// Same method call, different behaviors
for (Vehicle v : vehicles) {
    v.start(); // Calls appropriate version based on actual object type
}
// Output:
// Car engine starting... *vroooom*
// Motorcycle engine roaring to life... *VROOOM*  
// Generic Brand Transport is starting...
```

### 3. **Hierarchical Organization** 🌳

java

```java
// Clear, logical structure
Vehicle
├── LandVehicle
│   ├── Car
│   │   ├── SportsCar
│   │   └── SUV
│   └── Motorcycle
└── WaterVehicle
    ├── Boat
    └── Submarine
```

### 4. **Easier Maintenance** 🛠️

java

```java
// Change in parent class automatically affects all children
class Vehicle {
    public void start() {
        performSafetyCheck(); // Add this to all vehicles at once
        System.out.println("Vehicle starting...");
    }
    
    private void performSafetyCheck() {
        System.out.println("Safety check completed ✓");
    }
}
// Now ALL vehicles (Car, Motorcycle, etc.) automatically get safety checks!
```

### 5. **Extensibility** 📈

java

```java
// Easy to add new vehicle types without modifying existing code
class ElectricCar extends Car {
    private int batteryCapacity;
    
    @Override
    public void start() {
        System.out.println("Electric car starting silently... 🔋");
    }
    
    public void chargeBattery() {
        System.out.println("Charging battery...");
    }
}
```

### 6. **Memory Efficiency** 💾

-   Common methods stored once in parent class
-   Child objects only store their unique data
-   Reduces overall memory footprint

### 7. **Consistency** 🎯

java

```java
// All vehicles must have these basic methods
// Ensures consistent interface across all vehicle types
public abstract class Vehicle {
    public abstract void start();
    public abstract void stop();
    public abstract double calculateMaintenanceCost();
}
```

### 8. **Supports Design Patterns** 🏗️

java

```java
// Template Method Pattern
class Vehicle {
    public final void startVehicle() {
        checkFuel();        // Common step
        startEngine();      // Overridden by children
        checkLights();      // Common step
    }
    
    protected abstract void startEngine(); // Must be implemented by children
    
    private void checkFuel() { /* common implementation */ }
    private void checkLights() { /* common implementation */ }
}
```

## Types of Inheritance in Java

### 1. **Single Inheritance**

java

```java
class A { }
class B extends A { } // B inherits from A
```

### 2. **Multilevel Inheritance**

java

```java
class Vehicle { }
class Car extends Vehicle { }
class SportsCar extends Car { } // SportsCar → Car → Vehicle
```

### 3. **Hierarchical Inheritance**

java

```java
class Vehicle { }
class Car extends Vehicle { }
class Motorcycle extends Vehicle { } // Multiple classes inherit from Vehicle
class Truck extends Vehicle { }
```

**Note:** Java doesn't support multiple inheritance (class extending multiple classes) to avoid ambiguity, but supports it through interfaces.

## When to Use Inheritance

### ✅ **Good Use Cases:**

-   **IS-A relationship exists**: Car IS-A Vehicle, Dog IS-A Animal
-   **Shared behavior**: Multiple classes need common functionality
-   **Hierarchical structure**: Natural parent-child relationship
-   **Code reuse**: Avoid duplicating common code

### ❌ **Avoid When:**

-   **HAS-A relationship**: Car HAS-A Engine (use composition instead)
-   **No logical hierarchy**: Unrelated classes shouldn't inherit
-   **Tight coupling**: When changes in parent break children

## Summary

**Inheritance is like a family tree for classes** - children inherit traits from parents but can also develop their own unique characteristics. It's one of the most powerful features in OOP that makes code:

-   **Reusable** (write once, use many times)
-   **Maintainable** (change in one place affects all)
-   **Extensible** (easy to add new features)
-   **Organized** (logical hierarchical structure)
-   **Efficient** (less memory, less code duplication)

The vehicle example shows how real-world systems use inheritance - all vehicles share common properties (brand, model, start/stop) but each type (car, motorcycle) has its own specific features and behaviors.
