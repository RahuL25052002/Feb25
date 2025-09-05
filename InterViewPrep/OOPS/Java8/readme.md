# Java 8 Features - Complete Guide

Java 8 was released in March 2014 and introduced revolutionary features that transformed how Java developers write code. This guide covers all major Java 8 features with detailed explanations and practical examples.

## Table of Contents
- [Lambda Expressions](#lambda-expressions)
- [Functional Interfaces](#functional-interfaces)
- [Method References](#method-references)
- [Stream API](#stream-api)
- [Optional Class](#optional-class)
- [Default Methods in Interfaces](#default-methods-in-interfaces)
- [Static Methods in Interfaces](#static-methods-in-interfaces)
- [Date Time API](#date-time-api)
- [Nashorn JavaScript Engine](#nashorn-javascript-engine)
- [Parallel Array Sorting](#parallel-array-sorting)
- [Base64 Encoding/Decoding](#base64-encodingdecoding)
- [StringJoiner](#stringjoiner)
- [Collection API Enhancements](#collection-api-enhancements)
- [IO/NIO API Enhancements](#ionio-api-enhancements)
- [Concurrency API Enhancements](#concurrency-api-enhancements)

## Lambda Expressions

Lambda expressions are anonymous functions that can be passed around as values. They enable functional programming in Java.

### Syntax
```java
// Basic syntax
(parameter-list) -> expression
(parameter-list) -> { statements; }

// Examples
() -> 42                           // No parameters
x -> x * 2                        // Single parameter (parentheses optional)
(x, y) -> x + y                   // Multiple parameters
(String s) -> s.length()          // Explicit type
(x) -> { System.out.println(x); return x; }  // Multiple statements
```

### Before Java 8 vs After Java 8

**Before Java 8:**
```java
// Anonymous inner class
Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
};

// Comparator
List<String> names = Arrays.asList("John", "Jane", "Jack");
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});
```

**After Java 8:**
```java
// Lambda expression
Runnable r2 = () -> System.out.println("Hello World");

// Lambda with Comparator
List<String> names = Arrays.asList("John", "Jane", "Jack");
Collections.sort(names, (a, b) -> a.compareTo(b));
// Or even simpler
Collections.sort(names, String::compareTo);
```

### Practical Examples

```java
// Button click handler (in GUI applications)
button.addActionListener(e -> System.out.println("Button clicked!"));

// Thread creation
Thread thread = new Thread(() -> {
    for (int i = 0; i < 10; i++) {
        System.out.println("Thread: " + i);
    }
});

// Custom functional interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

System.out.println(add.calculate(5, 3));      // 8
System.out.println(multiply.calculate(5, 3)); // 15
```

## Functional Interfaces

A functional interface is an interface with exactly one abstract method. They can be used with lambda expressions.

### Built-in Functional Interfaces

#### 1. Predicate<T>
Tests a condition and returns boolean.

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
Predicate<String> isEmpty = String::isEmpty;
Predicate<String> isNotEmpty = isEmpty.negate();

// Combining predicates
Predicate<Integer> isPositive = x -> x > 0;
Predicate<Integer> isPositiveEven = isEven.and(isPositive);

System.out.println(isEven.test(4));           // true
System.out.println(isPositiveEven.test(6));   // true
System.out.println(isPositiveEven.test(-4));  // false
```

#### 2. Function<T, R>
Takes one argument and returns a result.

```java
Function<String, Integer> stringLength = String::length;
Function<Integer, Integer> square = x -> x * x;
Function<Integer, String> intToString = Object::toString;

// Function composition
Function<String, Integer> stringLengthSquared = stringLength.andThen(square);

System.out.println(stringLength.apply("Hello"));        // 5
System.out.println(square.apply(4));                    // 16
System.out.println(stringLengthSquared.apply("Java"));  // 16
```

#### 3. Consumer<T>
Takes one argument and returns void.

```java
Consumer<String> printer = System.out::println;
Consumer<String> upperCasePrinter = s -> System.out.println(s.toUpperCase());

// Consumer chaining
Consumer<String> printAndUpperCase = printer.andThen(upperCasePrinter);

printer.accept("Hello World");                    // Hello World
printAndUpperCase.accept("java 8");              // java 8
                                                  // JAVA 8
```

#### 4. Supplier<T>
Takes no arguments and returns a result.

```java
Supplier<String> messageSupplier = () -> "Hello from Java 8!";
Supplier<Double> randomValue = Math::random;
Supplier<LocalDateTime> currentTime = LocalDateTime::now;

System.out.println(messageSupplier.get());  // Hello from Java 8!
System.out.println(randomValue.get());      // 0.123456789 (random)
System.out.println(currentTime.get());      // Current timestamp
```

#### 5. BiFunction<T, U, R>
Takes two arguments and returns a result.

```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;

System.out.println(add.apply(5, 3));              // 8
System.out.println(concat.apply("Hello", " World")); // Hello World
```

### Custom Functional Interfaces

```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
    
    // Default methods are allowed
    default void printResult(int a, int b) {
        System.out.println("Result: " + operate(a, b));
    }
    
    // Static methods are allowed
    static void showInfo() {
        System.out.println("This is a math operation interface");
    }
}

// Usage
MathOperation addition = (a, b) -> a + b;
MathOperation multiplication = (a, b) -> a * b;

addition.printResult(5, 3);        // Result: 8
multiplication.printResult(5, 3);  // Result: 15
MathOperation.showInfo();          // This is a math operation interface
```

## Method References

Method references provide a way to refer to methods without invoking them. They are shorthand for lambda expressions.

### Types of Method References

#### 1. Static Method Reference
```java
// Lambda
Function<String, Integer> parseInt1 = s -> Integer.parseInt(s);
// Method reference
Function<String, Integer> parseInt2 = Integer::parseInt;

List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
List<Integer> integers = numbers.stream()
    .map(Integer::parseInt)
    .collect(Collectors.toList());
```

#### 2. Instance Method Reference of Particular Object
```java
String prefix = "Hello ";
Function<String, String> greeter = prefix::concat;

System.out.println(greeter.apply("World")); // Hello World

// Using with streams
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println);
```

#### 3. Instance Method Reference of Arbitrary Object
```java
// Lambda
Comparator<String> comp1 = (s1, s2) -> s1.compareToIgnoreCase(s2);
// Method reference
Comparator<String> comp2 = String::compareToIgnoreCase;

List<String> words = Arrays.asList("apple", "Banana", "cherry");
words.sort(String::compareToIgnoreCase);
System.out.println(words); // [apple, Banana, cherry]
```

#### 4. Constructor Reference
```java
// Lambda
Supplier<List<String>> listSupplier1 = () -> new ArrayList<>();
// Constructor reference
Supplier<List<String>> listSupplier2 = ArrayList::new;

Function<String, StringBuilder> sbCreator = StringBuilder::new;
StringBuilder sb = sbCreator.apply("Hello");

// With parameters
Function<Integer, int[]> arrayCreator = int[]::new;
int[] array = arrayCreator.apply(10); // Creates array of size 10
```

## Stream API

The Stream API provides a functional approach to processing collections of data. Streams represent a sequence of elements and support various operations.

### Creating Streams

```java
// From collections
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream1 = list.stream();
Stream<String> parallelStream = list.parallelStream();

// From arrays
String[] array = {"x", "y", "z"};
Stream<String> stream2 = Arrays.stream(array);

// Using Stream.of()
Stream<String> stream3 = Stream.of("hello", "world");

// Infinite streams
Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
Stream<Double> randomStream = Stream.generate(Math::random);

// Range of numbers
IntStream range = IntStream.range(1, 5);        // 1,2,3,4
IntStream rangeClosed = IntStream.rangeClosed(1, 5); // 1,2,3,4,5
```

### Intermediate Operations

Intermediate operations return a new stream and are lazy (not executed until terminal operation is called).

#### filter()
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

List<Integer> evenNumbers = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
// Result: [2, 4, 6, 8, 10]
```

#### map()
```java
List<String> words = Arrays.asList("hello", "world", "java", "stream");

List<Integer> lengths = words.stream()
    .map(String::length)
    .collect(Collectors.toList());
// Result: [5, 5, 4, 6]

List<String> upperCase = words.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
// Result: [HELLO, WORLD, JAVA, STREAM]
```

#### flatMap()
```java
List<List<Integer>> nestedList = Arrays.asList(
    Arrays.asList(1, 2, 3),
    Arrays.asList(4, 5, 6),
    Arrays.asList(7, 8, 9)
);

List<Integer> flatList = nestedList.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
// Result: [1, 2, 3, 4, 5, 6, 7, 8, 9]

// Splitting strings into characters
List<String> sentences = Arrays.asList("Hello World", "Java 8");
List<String> words2 = sentences.stream()
    .flatMap(s -> Arrays.stream(s.split(" ")))
    .collect(Collectors.toList());
// Result: [Hello, World, Java, 8]
```

#### distinct(), sorted(), limit(), skip()
```java
List<Integer> numbers2 = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);

List<Integer> processed = numbers2.stream()
    .distinct()           // Remove duplicates: [3, 1, 4, 5, 9, 2, 6]
    .sorted()            // Sort: [1, 2, 3, 4, 5, 6, 9]
    .skip(2)             // Skip first 2: [3, 4, 5, 6, 9]
    .limit(3)            // Take first 3: [3, 4, 5]
    .collect(Collectors.toList());
```

#### peek()
```java
List<String> result = Arrays.asList("apple", "banana", "cherry")
    .stream()
    .peek(s -> System.out.println("Processing: " + s))
    .map(String::toUpperCase)
    .peek(s -> System.out.println("Processed: " + s))
    .collect(Collectors.toList());
```

### Terminal Operations

Terminal operations trigger the processing of the stream and return a result.

#### collect()
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// To List
List<String> list = names.stream()
    .filter(s -> s.startsWith("A"))
    .collect(Collectors.toList());

// To Set
Set<String> set = names.stream()
    .collect(Collectors.toSet());

// To Map
Map<String, Integer> nameToLength = names.stream()
    .collect(Collectors.toMap(
        name -> name,           // key
        String::length          // value
    ));

// Grouping
Map<Integer, List<String>> groupedByLength = names.stream()
    .collect(Collectors.groupingBy(String::length));

// Joining
String joined = names.stream()
    .collect(Collectors.joining(", "));
// Result: "Alice, Bob, Charlie, David"
```

#### forEach()
```java
Arrays.asList("a", "b", "c")
    .stream()
    .forEach(System.out::println);

// forEachOrdered for parallel streams
Arrays.asList("a", "b", "c")
    .parallelStream()
    .forEachOrdered(System.out::println);
```

#### reduce()
```java
List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);

// Sum
Optional<Integer> sum1 = numbers3.stream()
    .reduce((a, b) -> a + b);

int sum2 = numbers3.stream()
    .reduce(0, (a, b) -> a + b);

// Product
int product = numbers3.stream()
    .reduce(1, (a, b) -> a * b);

// Max/Min
Optional<Integer> max = numbers3.stream()
    .reduce(Integer::max);

Optional<String> longest = Arrays.asList("apple", "banana", "cherry")
    .stream()
    .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
```

#### find() and match() operations
```java
List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie", "David");

// findFirst
Optional<String> first = names2.stream()
    .filter(s -> s.startsWith("C"))
    .findFirst();

// findAny
Optional<String> any = names2.stream()
    .filter(s -> s.length() > 3)
    .findAny();

// anyMatch
boolean hasLongName = names2.stream()
    .anyMatch(s -> s.length() > 6);

// allMatch
boolean allStartWithCapital = names2.stream()
    .allMatch(s -> Character.isUpperCase(s.charAt(0)));

// noneMatch
boolean noneStartWithZ = names2.stream()
    .noneMatch(s -> s.startsWith("Z"));
```

#### count()
```java
long count = Arrays.asList("apple", "banana", "cherry")
    .stream()
    .filter(s -> s.contains("a"))
    .count();
```

### Complex Stream Examples

```java
// Employee class for examples
class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;
    
    // Constructor and getters
    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }
    
    // Getters...
}

List<Employee> employees = Arrays.asList(
    new Employee("Alice", "IT", 75000, 30),
    new Employee("Bob", "HR", 65000, 35),
    new Employee("Charlie", "IT", 80000, 28),
    new Employee("David", "Finance", 70000, 32),
    new Employee("Eve", "HR", 68000, 29)
);

// Average salary by department
Map<String, Double> avgSalaryByDept = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.averagingDouble(Employee::getSalary)
    ));

// Top 2 highest paid employees
List<Employee> topPaid = employees.stream()
    .sorted(Comparator.comparing(Employee::getSalary).reversed())
    .limit(2)
    .collect(Collectors.toList());

// Employees in IT with salary > 70000
List<String> itHighEarners = employees.stream()
    .filter(e -> "IT".equals(e.getDepartment()))
    .filter(e -> e.getSalary() > 70000)
    .map(Employee::getName)
    .collect(Collectors.toList());
```

## Optional Class

Optional is a container that may or may not contain a value. It helps avoid NullPointerException.

### Creating Optional

```java
// Empty Optional
Optional<String> empty = Optional.empty();

// Optional with value
Optional<String> nonEmpty = Optional.of("Hello");

// Optional that may be null
String str = null;
Optional<String> nullable = Optional.ofNullable(str);
```

### Checking for Value

```java
Optional<String> opt = Optional.of("Hello");

// Check if value is present
if (opt.isPresent()) {
    System.out.println(opt.get());
}

// Java 11+
if (opt.isEmpty()) {
    System.out.println("No value");
}
```

### Working with Values

```java
Optional<String> opt = Optional.of("Hello World");

// ifPresent - execute if value exists
opt.ifPresent(System.out::println);

// orElse - provide default value
String value1 = Optional.ofNullable(null).orElse("Default");

// orElseGet - provide default using supplier
String value2 = Optional.ofNullable(null).orElseGet(() -> "Computed Default");

// orElseThrow - throw exception if empty
String value3 = Optional.ofNullable(null)
    .orElseThrow(() -> new RuntimeException("Value not found"));
```

### Transforming Optional Values

```java
Optional<String> opt = Optional.of("hello");

// map - transform the value
Optional<Integer> length = opt.map(String::length);
Optional<String> upper = opt.map(String::toUpperCase);

// flatMap - avoid Optional<Optional<T>>
Optional<String> result = opt.flatMap(s -> 
    s.isEmpty() ? Optional.empty() : Optional.of(s.toUpperCase())
);

// filter - filter based on condition
Optional<String> filtered = opt.filter(s -> s.length() > 3);
```

### Practical Examples

```java
// Before Optional
public String findUserNameById(Long id) {
    User user = userRepository.findById(id);
    if (user != null) {
        return user.getName();
    }
    return "Unknown";
}

// After Optional
public String findUserNameById(Long id) {
    return userRepository.findById(id)
        .map(User::getName)
        .orElse("Unknown");
}

// Chaining operations
Optional.ofNullable(getUserById(123))
    .filter(user -> user.getAge() >= 18)
    .map(User::getEmail)
    .filter(email -> email.contains("@"))
    .ifPresent(email -> sendEmail(email));
```

## Default Methods in Interfaces

Default methods allow interfaces to have method implementations without breaking existing implementations.

### Basic Syntax

```java
interface Vehicle {
    // Abstract method
    void start();
    
    // Default method
    default void stop() {
        System.out.println("Vehicle stopped");
    }
    
    default void honk() {
        System.out.println("Beep beep!");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }
    
    // Can optionally override default methods
    @Override
    public void stop() {
        System.out.println("Car stopped with brakes");
    }
}
```

### Multiple Inheritance of Behavior

```java
interface Flyable {
    default void fly() {
        System.out.println("Flying...");
    }
}

interface Swimmable {
    default void swim() {
        System.out.println("Swimming...");
    }
}

class Duck implements Flyable, Swimmable {
    // Duck inherits both fly() and swim() methods
}

Duck duck = new Duck();
duck.fly();   // Flying...
duck.swim();  // Swimming...
```

### Resolving Conflicts

```java
interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}

// This would cause compilation error without explicit resolution
class C implements A, B {
    @Override
    public void hello() {
        // Option 1: Choose one
        A.super.hello();
        
        // Option 2: Choose other
        // B.super.hello();
        
        // Option 3: Provide own implementation
        // System.out.println("Hello from C");
    }
}
```

### Practical Example - Collection Interface

```java
// Java 8 added default methods to existing interfaces
List<String> list = Arrays.asList("a", "b", "c", "d");

// forEach - default method added to Iterable
list.forEach(System.out::println);

// removeIf - default method added to Collection
list.removeIf(s -> s.equals("b"));

// replaceAll - default method added to List
List<String> mutableList = new ArrayList<>(Arrays.asList("hello", "world"));
mutableList.replaceAll(String::toUpperCase);
System.out.println(mutableList); // [HELLO, WORLD]
```

## Static Methods in Interfaces

Java 8 allows static methods in interfaces.

```java
interface Utility {
    static void printInfo() {
        System.out.println("This is a utility method");
    }
    
    static int add(int a, int b) {
        return a + b;
    }
    
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

// Usage
Utility.printInfo();                    // This is a utility method
System.out.println(Utility.add(5, 3)); // 8
System.out.println(Utility.isEven(4));  // true
```

### Comparator Static Methods

```java
List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");

// Using static methods from Comparator interface
Collections.sort(names, Comparator.naturalOrder());
Collections.sort(names, Comparator.reverseOrder());

// Comparing by length
Collections.sort(names, Comparator.comparing(String::length));

// Comparing by length, then alphabetically
Collections.sort(names, 
    Comparator.comparing(String::length)
              .thenComparing(Comparator.naturalOrder())
);
```

## Date Time API

Java 8 introduced a new Date Time API to replace the problematic `java.util.Date` and `java.util.Calendar`.

### Key Classes

#### LocalDate
```java
// Creating LocalDate
LocalDate today = LocalDate.now();
LocalDate specificDate = LocalDate.of(2023, Month.DECEMBER, 25);
LocalDate parsedDate = LocalDate.parse("2023-12-25");

// Operations
LocalDate nextWeek = today.plusWeeks(1);
LocalDate lastMonth = today.minusMonths(1);
LocalDate nextYear = today.plusYears(1);

// Getting information
int year = today.getYear();
Month month = today.getMonth();
int dayOfMonth = today.getDayOfMonth();
DayOfWeek dayOfWeek = today.getDayOfWeek();

// Comparisons
boolean isAfter = today.isAfter(specificDate);
boolean isBefore = today.isBefore(specificDate);
boolean isLeapYear = today.isLeapYear();
```

#### LocalTime
```java
// Creating LocalTime
LocalTime now = LocalTime.now();
LocalTime specificTime = LocalTime.of(14, 30, 45);
LocalTime parsedTime = LocalTime.parse("14:30:45");

// Operations
LocalTime oneHourLater = now.plusHours(1);
LocalTime thirtyMinutesEarlier = now.minusMinutes(30);

// Getting information
int hour = now.getHour();
int minute = now.getMinute();
int second = now.getSecond();
```

#### LocalDateTime
```java
// Creating LocalDateTime
LocalDateTime now = LocalDateTime.now();
LocalDateTime specific = LocalDateTime.of(2023, 12, 25, 14, 30, 45);
LocalDateTime combined = LocalDate.now().atTime(LocalTime.now());

// Converting
LocalDate date = now.toLocalDate();
LocalTime time = now.toLocalTime();
```

#### ZonedDateTime
```java
// Working with time zones
ZonedDateTime nowInUTC = ZonedDateTime.now(ZoneId.of("UTC"));
ZonedDateTime nowInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));
ZonedDateTime nowInTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

// Converting between time zones
ZonedDateTime utcToNY = nowInUTC.withZoneSameInstant(ZoneId.of("America/New_York"));
```

#### Duration and Period
```java
// Duration - for time-based amounts
LocalTime start = LocalTime.of(10, 0);
LocalTime end = LocalTime.of(14, 30);
Duration duration = Duration.between(start, end);

long hours = duration.toHours();    // 4
long minutes = duration.toMinutes(); // 270

// Period - for date-based amounts
LocalDate startDate = LocalDate.of(2020, 1, 1);
LocalDate endDate = LocalDate.of(2023, 6, 15);
Period period = Period.between(startDate, endDate);

int years = period.getYears();    // 3
int months = period.getMonths();  // 5
int days = period.getDays();      // 14
```

#### Formatting and Parsing
```java
LocalDateTime dateTime = LocalDateTime.now();

// Predefined formatters
String iso = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

// Custom formatters
DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
String formatted = dateTime.format(customFormatter);

// Parsing
LocalDateTime parsed = LocalDateTime.parse("25-12-2023 14:30:45", customFormatter);
```

### Practical Examples

```java
// Age calculation
public int calculateAge(LocalDate birthDate) {
    return Period.between(birthDate, LocalDate.now()).getYears();
}

// Working days calculation (excluding weekends)
public long calculateWorkingDays(LocalDate start, LocalDate end) {
    return start.datesUntil(end)
                .filter(date -> date.getDayOfWeek() != DayOfWeek.SATURDAY)
                .filter(date -> date.getDayOfWeek() != DayOfWeek.SUNDAY)
                .count();
}

// Meeting scheduler
public class MeetingScheduler {
    public ZonedDateTime scheduleInternationalMeeting(
        LocalDateTime meetingTime, 
        ZoneId organizerTimeZone,
        ZoneId participantTimeZone) {
        
        ZonedDateTime organizerTime = meetingTime.atZone(organizerTimeZone);
        return organizerTime.withZoneSameInstant(participantTimeZone);
    }
}
```

## Nashorn JavaScript Engine

Java 8 included the Nashorn JavaScript engine for executing JavaScript code within Java applications.

```java
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        
        // Execute JavaScript code
        Object result = engine.eval("var x = 5; var y = 3; x + y;");
        System.out.println("Result: " + result); // Result: 8
        
        // Call JavaScript functions
        engine.eval("function greet(name) { return 'Hello, ' + name; }");
        Object greeting = engine.eval("greet('Java 8');");
        System.out.println(greeting); // Hello, Java 8
        
        // Access Java objects from JavaScript
        engine.put("javaList", Arrays.asList("apple", "banana", "cherry"));
        engine.eval("javaList.forEach(function(item) { print(item); });");
    }
}
```

**Note:** Nashorn was deprecated in Java 11 and removed in Java 15.

## Parallel Array Sorting

Java 8 introduced parallel sorting for better performance on multi-core systems.

```java
import java.util.Arrays;

// Regular sorting
int[] array1 = {5, 2, 8, 1, 9, 3};
Arrays.sort(array1);

// Parallel sorting (better for large arrays)
int[] array2 = {5, 2, 8, 1, 9, 3, 7, 4, 6, 10, 12, 11};
Arrays.parallelSort(array2);

// Parallel sorting with range
int[] array3 = {5, 2, 8, 1, 9, 3, 7, 4, 6, 10, 12, 11};
Arrays.parallelSort(array3, 2, 8); // Sort from index 2 to 7

// Parallel sorting with custom comparator
String[] names = {"John", "Jane", "Jack", "Jill"};
Arrays.parallelSort(names, String.CASE_INSENSITIVE_ORDER);
```

## Base64 Encoding/Decoding

Java 8 added native Base64 support.

```java
import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalString = "Hello, Java 8!";
        
        // Basic encoding/decoding
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded: " + encodedString);
        
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded: " + decodedString);
        
        // URL and Filename safe encoding
        String urlSafeEncoded = Base64.getUrlEncoder().encodeToString(originalString.getBytes());
        System.out.println("URL Safe Encoded: " + urlSafeEncoded);
        
        // MIME encoding (for email)
        String mimeEncoded = Base64.getMimeEncoder().encodeToString(originalString.getBytes());
        System.out.println("MIME Encoded: " + mimeEncoded);
    }
}
```

## StringJoiner

StringJoiner provides a convenient way to construct delimited strings.

```java
import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        // Basic usage
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("apple").add("banana").add("cherry");
        System.out.println(joiner1.toString()); // apple, banana, cherry
        
        // With prefix and suffix
        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("red").add("green").add("blue");
        System.out.println(joiner2.toString()); // [red, green, blue]
        
        // With empty value
        StringJoiner joiner3 = new StringJoiner(", ", "{", "}");
        joiner3.setEmptyValue("No items");
        System.out.println(joiner3.toString()); // No items
        
        joiner3.add("item1");
        System.out.println(joiner3.toString()); // {item1}
        
        // Merging StringJoiners
        StringJoiner joiner4 = new StringJoiner(", ");
        joiner4.add("x").add("y");
        
        StringJoiner joiner5 = new StringJoiner(", ");
        joiner5.add("z").add("w");
        
        joiner4.merge(joiner5);
        System.out.println(joiner4.toString()); // x, y, z, w
    }
}

// Practical example
public String formatEmployeeList(List<Employee> employees) {
    StringJoiner joiner = new StringJoiner(", ", "Employees: [", "]");
    employees.stream()
             .map(Employee::getName)
             .forEach(joiner::add);
    return joiner.toString();
}
```

## Collection API Enhancements

Java 8 added several new methods to existing collection interfaces.

### List Interface

```java
List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date"));

// forEach with lambda
list.forEach(System.out::println);

// replaceAll
list.replaceAll(String::toUpperCase);
System.out.println(list); // [APPLE, BANANA, CHERRY, DATE]

// removeIf
list.removeIf(s -> s.startsWith("A"));
System.out.println(list); // [BANANA, CHERRY, DATE]

// sort with comparator
list.sort(Comparator.comparing(String::length));
System.out.println(list); // [DATE, CHERRY, BANANA]
```

### Map Interface

```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 5);
map.put("banana", 3);
map.put("cherry", 8);

// forEach with BiConsumer
map.forEach((key, value) -> System.out.println(key + " = " + value));

// getOrDefault
int orangeCount = map.getOrDefault("orange", 0);
System.out.println("Orange count: " + orangeCount); // 0

// putIfAbsent
map.putIfAbsent("date", 4);
map.putIfAbsent("apple", 10); // Won't replace existing value

// computeIfAbsent
map.computeIfAbsent("grape", k -> k.length());
System.out.println(map.get("grape")); // 5

// computeIfPresent
map.computeIfPresent("apple", (key, value) -> value * 2);
System.out.println(map.get("apple")); // 10

// compute
map.compute("banana", (key, value) -> value == null ? 1 : value + 1);

// merge
map.merge("apple", 5, Integer::sum); // Adds 5 to existing value
map.merge("kiwi", 3, Integer::sum);  // Creates new entry with value 3

// replaceAll
map.replaceAll((key, value) -> value * 2);
```

### Collection Stream Integration

```java
// Stream operations directly on collections
List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

// Count fruits with more than 5 characters
long count = fruits.stream()
                  .filter(s -> s.length() > 5)
                  .count();

// Get first fruit starting with 'c'
Optional<String> firstC = fruits.stream()
                               .filter(s -> s.startsWith("c"))
                               .findFirst();

// Convert to uppercase and collect
List<String> upperFruits = fruits.stream()
                                 .map(String::toUpperCase)
                                 .collect(Collectors.toList());
```

## IO/NIO API Enhancements

Java 8 added several utility methods for file operations and stream processing.

### Files Class Enhancements

```java
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;

public class FileEnhancements {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("example.txt");
        
        // Read all lines as Stream
        try (Stream<String> lines = Files.lines(path)) {
            lines.filter(line -> line.contains("Java"))
                 .forEach(System.out::println);
        }
        
        // Walk file tree as Stream
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            paths.filter(Files::isRegularFile)
                 .filter(p -> p.toString().endsWith(".java"))
                 .forEach(System.out::println);
        }
        
        // Find files
        try (Stream<Path> paths = Files.find(Paths.get("."), 2,
                (path1, basicFileAttributes) -> path1.toString().endsWith(".txt"))) {
            paths.forEach(System.out::println);
        }
        
        // List directory contents as Stream
        try (Stream<Path> list = Files.list(Paths.get("."))) {
            list.filter(Files::isDirectory)
                .forEach(System.out::println);
        }
    }
    
    // Practical example: Word count in files
    public static void wordCountExample() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("document.txt"))) {
            long wordCount = lines.flatMap(line -> Arrays.stream(line.split("\\s+")))
                                 .filter(word -> !word.isEmpty())
                                 .count();
            System.out.println("Word count: " + wordCount);
        }
    }
    
    // Find duplicate files by size
    public static void findDuplicateFiles() throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            Map<Long, List<Path>> filesBySize = paths
                .filter(Files::isRegularFile)
                .collect(Collectors.groupingBy(path -> {
                    try {
                        return Files.size(path);
                    } catch (IOException e) {
                        return 0L;
                    }
                }));
                
            filesBySize.entrySet().stream()
                      .filter(entry -> entry.getValue().size() > 1)
                      .forEach(entry -> {
                          System.out.println("Size: " + entry.getKey() + " bytes");
                          entry.getValue().forEach(path -> System.out.println("  " + path));
                      });
        }
    }
}
```

### BufferedReader Enhancements

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEnhancements {
    public static void processLargeFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("large-file.txt"))) {
            // Process file line by line as Stream
            reader.lines()
                  .filter(line -> line.contains("ERROR"))
                  .map(String::toUpperCase)
                  .forEach(System.out::println);
        }
    }
    
    // Count specific pattern in file
    public static long countPattern(String filename, String pattern) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines()
                        .filter(line -> line.contains(pattern))
                        .count();
        }
    }
}
```

## Concurrency API Enhancements

Java 8 introduced several enhancements to the concurrency utilities.

### CompletableFuture

CompletableFuture provides a more powerful and flexible way to handle asynchronous programming.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Simple async computation
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return "Hello";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        
        CompletableFuture<String> future2 = future1.thenApply(s -> s + " World");
        CompletableFuture<Void> future3 = future2.thenAccept(System.out::println);
        
        future3.get(); // Wait for completion
        
        // Combining futures
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> "World");
        
        CompletableFuture<String> combinedFuture = future4.thenCombine(future5, 
            (s1, s2) -> s1 + " " + s2);
        
        System.out.println(combinedFuture.get()); // Hello World
        
        // Exception handling
        CompletableFuture<String> futureWithException = CompletableFuture
            .supplyAsync(() -> {
                if (true) throw new RuntimeException("Something went wrong!");
                return "Success";
            })
            .exceptionally(throwable -> {
                System.out.println("Exception occurred: " + throwable.getMessage());
                return "Default value";
            });
        
        System.out.println(futureWithException.get()); // Default value
    }
    
    // Practical example: Parallel web service calls
    public static void parallelWebServiceCalls() {
        CompletableFuture<String> userService = CompletableFuture.supplyAsync(() -> 
            fetchUserData("123"));
        
        CompletableFuture<String> orderService = CompletableFuture.supplyAsync(() -> 
            fetchOrderData("123"));
        
        CompletableFuture<String> inventoryService = CompletableFuture.supplyAsync(() -> 
            fetchInventoryData("item-456"));
        
        // Wait for all to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(
            userService, orderService, inventoryService);
        
        allOf.thenRun(() -> {
            try {
                String userData = userService.get();
                String orderData = orderService.get();
                String inventoryData = inventoryService.get();
                
                System.out.println("All data fetched:");
                System.out.println("User: " + userData);
                System.out.println("Orders: " + orderData);
                System.out.println("Inventory: " + inventoryData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    private static String fetchUserData(String userId) {
        // Simulate web service call
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        return "User data for " + userId;
    }
    
    private static String fetchOrderData(String userId) {
        try { Thread.sleep(700); } catch (InterruptedException e) {}
        return "Order data for " + userId;
    }
    
    private static String fetchInventoryData(String itemId) {
        try { Thread.sleep(300); } catch (InterruptedException e) {}
        return "Inventory data for " + itemId;
    }
}
```

### ConcurrentHashMap Enhancements

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEnhancements {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("cherry", 15);
        map.put("date", 8);
        
        // forEach with parallelism threshold
        map.forEach(1, (key, value) -> 
            System.out.println(key + " = " + value));
        
        // search - returns first match
        String result = map.search(1, (key, value) -> 
            value > 10 ? key : null);
        System.out.println("First item with value > 10: " + result);
        
        // reduce - combines all values
        Integer sum = map.reduce(1,
            (key, value) -> value,  // transformer
            Integer::sum);          // reducer
        System.out.println("Sum of all values: " + sum);
        
        // Parallel operations on keys, values, entries
        map.forEachKey(1, System.out::println);
        map.forEachValue(1, value -> System.out.println("Value: " + value));
        map.forEachEntry(1, entry -> 
            System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
```

### LongAdder and LongAccumulator

For high-contention scenarios, LongAdder provides better performance than AtomicLong.

```java
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.atomic.LongAccumulator;

public class AdderAccumulatorExample {
    public static void main(String[] args) throws InterruptedException {
        // LongAdder for counting
        LongAdder counter = new LongAdder();
        
        // Multiple threads incrementing
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("Counter value: " + counter.sum()); // 10000
        
        // LongAccumulator for custom operations
        LongAccumulator max = new LongAccumulator(Long::max, Long.MIN_VALUE);
        
        max.accumulate(10);
        max.accumulate(5);
        max.accumulate(15);
        max.accumulate(3);
        
        System.out.println("Max value: " + max.get()); // 15
    }
}
```

## Performance Improvements and Best Practices

### Lambda Performance Tips

```java
// 1. Prefer method references over lambdas when possible
// Less efficient
list.stream().map(s -> s.toUpperCase()).collect(toList());
// More efficient  
list.stream().map(String::toUpperCase).collect(toList());

// 2. Use primitive streams for better performance
// Less efficient
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream().mapToInt(i -> i).sum();
// More efficient
int[] primitiveArray = {1, 2, 3, 4, 5};
int sum2 = Arrays.stream(primitiveArray).sum();

// 3. Parallel streams for CPU-intensive operations on large datasets
List<String> largeList = generateLargeStringList();
// Sequential
long count1 = largeList.stream()
                      .filter(s -> s.length() > 10)
                      .count();
// Parallel (use when processing is CPU-intensive and dataset is large)
long count2 = largeList.parallelStream()
                      .filter(s -> s.length() > 10)
                      .count();
```

### Stream Performance Considerations

```java
// 1. Short-circuit operations
// findFirst() stops as soon as first element is found
Optional<String> first = list.stream()
                            .filter(s -> s.startsWith("A"))
                            .findFirst();

// anyMatch() stops as soon as condition is met
boolean hasLongString = list.stream()
                           .anyMatch(s -> s.length() > 100);

// 2. Order of operations matters
// More efficient - filter first to reduce subsequent operations
list.stream()
    .filter(expensive::condition)  // Reduces dataset
    .map(expensive::transformation) // Applied to fewer elements
    .collect(toList());

// Less efficient
list.stream()
    .map(expensive::transformation)  // Applied to all elements
    .filter(expensive::condition)   // Then filtered
    .collect(toList());

// 3. Use appropriate collectors
// For simple transformations to List
list.stream().map(String::toUpperCase).collect(toList());
// For grouping
Map<Integer, List<String>> grouped = list.stream()
    .collect(groupingBy(String::length));
```

## Migration Guide: Pre-Java 8 to Java 8

### Common Patterns Migration

```java
// 1. Collections iteration
// Before Java 8
for (String item : list) {
    System.out.println(item);
}
// After Java 8
list.forEach(System.out::println);

// 2. Filtering collections
// Before Java 8
List<String> filtered = new ArrayList<>();
for (String item : list) {
    if (item.startsWith("A")) {
        filtered.add(item);
    }
}
// After Java 8
List<String> filtered = list.stream()
                           .filter(s -> s.startsWith("A"))
                           .collect(toList());

// 3. Finding elements
// Before Java 8
String found = null;
for (String item : list) {
    if (item.contains("target")) {
        found = item;
        break;
    }
}
// After Java 8
Optional<String> found = list.stream()
                            .filter(s -> s.contains("target"))
                            .findFirst();

// 4. Transforming collections
// Before Java 8
List<Integer> lengths = new ArrayList<>();
for (String item : list) {
    lengths.add(item.length());
}
// After Java 8
List<Integer> lengths = list.stream()
                           .map(String::length)
                           .collect(toList());

// 5. Anonymous classes to lambdas
// Before Java 8
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked");
    }
});
// After Java 8
button.addActionListener(e -> System.out.println("Button clicked"));
```

## Summary

Java 8 introduced transformative features that revolutionized Java programming:

### Key Benefits:
- **Functional Programming**: Lambda expressions and functional interfaces
- **Stream Processing**: Powerful data processing capabilities
- **Better API Design**: Default methods allow interface evolution
- **Improved Date/Time**: New comprehensive date-time API
- **Performance**: Parallel streams and enhanced collections
- **Code Readability**: More concise and expressive code

### When to Use:
- **Lambda Expressions**: Replace anonymous inner classes, event handlers
- **Streams**: Data processing, filtering, transformations
- **Optional**: Null safety, avoiding NullPointerException
- **New Date/Time API**: All date-time operations (replace Date/Calendar)
- **CompletableFuture**: Asynchronous programming, non-blocking operations

### Best Practices:
1. Use method references when lambda just calls a method
2. Prefer streams for data processing over traditional loops
3. Use Optional to handle potentially null values
4. Leverage parallel streams for CPU-intensive operations on large datasets
5. Use the new Date/Time API for all temporal operations
6. Take advantage of default methods for interface evolution

Java 8 set the foundation for modern Java development and many of its concepts continue to be enhanced in later versions. Understanding these features is crucial for any Java developer working with modern codebases.
