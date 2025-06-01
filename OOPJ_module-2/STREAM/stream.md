# Java Stream API - Method Reference Guide

This document provides an overview of key methods available in Java's Stream API, introduced in Java 8. Streams allow you to perform functional-style operations on collections with concise and readable code.

---

## 🔄 Stream Creation

You can create a stream from various sources:

```java
Stream<String> stream = Stream.of("apple", "banana", "cherry");
List<String> list = Arrays.asList("one", "two", "three");
Stream<String> listStream = list.stream();
```

---

## 🔧 Common Stream Methods

### 1. **`map()`**
Transforms each element in the stream.

```java
List<String> names = List.of("alice", "bob", "charlie");
List<String> upperNames = names.stream()
    .map(String::toUpperCase)
    .toList(); // [ALICE, BOB, CHARLIE]
```

---

### 2. **`filter()`**
Filters elements based on a condition.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
List<Integer> even = numbers.stream()
    .filter(n -> n % 2 == 0)
    .toList(); // [2, 4]
```

---

### 3. **`sorted()`**
Sorts the stream elements.

```java
List<String> sorted = List.of("dog", "apple", "banana").stream()
    .sorted()
    .toList(); // [apple, banana, dog]
```

With custom comparator:

```java
List<String> reverseSorted = List.of("dog", "apple", "banana").stream()
    .sorted(Comparator.reverseOrder())
    .toList(); // [dog, banana, apple]
```

---

### 4. **`distinct()`**
Removes duplicate elements.

```java
List<Integer> unique = List.of(1, 2, 2, 3, 3, 3).stream()
    .distinct()
    .toList(); // [1, 2, 3]
```

---

### 5. **`collect()`**
Collects results into a collection or summary.

```java
List<String> list = Stream.of("a", "b", "c")
    .collect(Collectors.toList());

Set<String> set = Stream.of("a", "b", "a")
    .collect(Collectors.toSet());
```

---

### 6. **`limit(n)`**
Limits the stream to `n` elements.

```java
List<Integer> limited = Stream.of(10, 20, 30, 40, 50)
    .limit(3)
    .toList(); // [10, 20, 30]
```

---

### 7. **`skip(n)`**
Skips the first `n` elements.

```java
List<Integer> skipped = Stream.of(10, 20, 30, 40, 50)
    .skip(2)
    .toList(); // [30, 40, 50]
```

---

### 8. **`forEach()`**
Performs an action for each element (terminal operation).

```java
Stream.of("A", "B", "C").forEach(System.out::println);
```

---

### 9. **`anyMatch()`, `allMatch()`, `noneMatch()`**
Predicate-based match operations:

```java
boolean hasEven = List.of(1, 3, 5).stream().anyMatch(n -> n % 2 == 0); // false
boolean allPositive = List.of(1, 2, 3).stream().allMatch(n -> n > 0); // true
boolean noneNegative = List.of(1, 2, 3).stream().noneMatch(n -> n < 0); // true
```

---

### 10. **`findFirst()` / `findAny()`**
Returns an `Optional` for the first or any matching element.

```java
Optional<String> first = Stream.of("a", "b", "c").findFirst(); // "a"
```

---

### 11. **`reduce()`**
Combines elements using an accumulator.

```java
int sum = Stream.of(1, 2, 3).reduce(0, Integer::sum); // 6
```

---

### 12. **`peek()`**
Used for debugging (does not change the stream):

```java
Stream.of("one", "two", "three")
    .peek(System.out::println)
    .map(String::toUpperCase)
    .toList();
```

---

## 🔚 Terminal Operations vs Intermediate Operations

| Operation Type     | Methods                                                                 |
|--------------------|-------------------------------------------------------------------------|
| Intermediate       | `map`, `filter`, `sorted`, `distinct`, `limit`, `skip`, `peek`         |
| Terminal           | `collect`, `forEach`, `reduce`, `count`, `findFirst`, `anyMatch`, etc. |

---

## 🔄 Stream Pipeline Example

```java
List<String> result = List.of("apple", "banana", "apple", "orange", "banana").stream()
    .filter(fruit -> fruit.length() > 5)
    .distinct()
    .sorted()
    .map(String::toUpperCase)
    .limit(2)
    .toList(); // [BANANA, ORANGE]
```

---

## 📖 References

- [Oracle Stream API Docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
- [Baeldung Java Streams Guide](https://www.baeldung.com/java-8-streams)
- [Java 8 Stream Cheatsheet](https://github.com/venkatperi/java8-streams-cheatsheet)

---

## ✅ Best Practices

- Prefer `map()` over `forEach()` for transformations.
- Use `collect(Collectors.toList())` for compatibility with older Java versions (before 16).
- Avoid stateful operations like modifying external variables inside `map()` or `forEach()`.

---

Happy Streaming! 🚀
