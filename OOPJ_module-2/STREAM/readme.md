
# STREAM API IN JAVA



Java 8 introduced the Stream API, revolutionizing the way we process collections in Java. Streams provide a concise and expressive way to perform bulk operations on data, enabling functional-style programming paradigms. In this article, we’ll explore the Stream API in detail, covering concepts, examples, and outputs in an easy-to-understand manner.

# Before Streams: Problems with Traditional Collection Processing

Before Java 8 Streams, processing collections often involved writing imperative loops, which could lead to verbose and error-prone code. Common problems comes :

-   **Boilerplate Code**: Writing iterative loops (`for`  or  `while`  loops) to perform operations on collections resulted in  verbose and boilerplate code.
-   **Lack of Parallelism:**Achieving parallelism in traditional loop-based code requires explicit management of threads, leading to complexity and potential bugs.
-   **Lack of Composition:**  It was challenging to compose multiple operations (e.g., filter, map, and reduce) in a concise and readable manner.

> With the Streams in Java 8, many of these problems were addressed, offering several advantages:

-   **Declarative Syntax**: Streams provide a declarative syntax for processing collections, enabling concise and readable code.
-   **Functional Style:**  Streams support functional-style programming paradigms, allowing operations to be composed and performed in a fluent and expressive manner.
-   **Immutable Data:**  Streams operate on  _immutable data_, avoiding side effects and promoting thread safety, making them suitable for parallel processing.
-   **Lazy Evaluation:**  Streams use lazy evaluation, meaning intermediate operations are only executed when terminal operations are invoked, resulting in optimized performance.

> I have written one article to understand terminal and intermediate operation . check below
> 
> ([https://www.linkedin.com/pulse/intermediate-terminal-operations-java-streams-jahid-momin/](https://www.linkedin.com/pulse/intermediate-terminal-operations-java-streams-jahid-momin/)) .

## Basics

> Creating Streams: Streams can be created from various sources such as collections, arrays, or even directly from values.
> 
> Intermediate Operations: Intermediate operations transform the elements of a stream. Common operations include  `filter`,  `map`, and  `sorted`.
> 
> Terminal Operations: Terminal operations produce a result or a side-effect, such as  `forEach`,  `collect`, or  `count`.
> 
> Parallel Streams: Streams can be processed sequentially or in parallel for improved performance on multi-core processors.

## Practical:

Creating Streams :

List<String> myList = Arrays.asList("apple", "banana", "orange");  
Stream<String> sequentialStream = myList.stream();  
Stream<String> parallelStream = myList.parallelStream();

Creates a stream from an array :

int[] numbers = {1, 2, 3, 4, 5};  
IntStream stream = Arrays.stream(numbers);

`Stream.of()`  method creates a stream from individual values.

Stream<String> stream = Stream.of("apple", "banana", "orange");

Lets see some Intermeditate operations :

> `filter()`: Filters elements based on a predicate.

  
List<String> filtered = myList.stream()  
                              .filter(s -> s.startsWith("a"))  
                              .collect(Collectors.toList());  
//filter the items startswith a

> `map()`: Transforms elements using a function.

List<Integer> lengths = myList.stream()  
                              .map(String::length)  
                              .collect(Collectors.toList());

`sorted()`: Sorts elements.

List<String> sorted = myList.stream()  
                            .sorted() // we can use comparator here as a arg  
                            .collect(Collectors.toList());

`distinct()`: Removes duplicate elements.

List<String> distinct = myList.stream()  
                              .distinct()  
                              .collect(Collectors.toList());

other operations are there like limit(), skip().

Lets see some terminal operations -

`forEach()`: Performs an action for each element.

myList.stream().forEach(System.out::println);

`collect()`: Accumulates elements into a collection.

List<String> collected = myList.stream()  
                               .collect(Collectors.toList());

`count()`: Returns the number of elements.

long count = myList.stream().count();

Some more operations are ther  `anyMatch()`,  `allMatch()`,  `noneMatch() ,findFirst()`,  `findAny() ,reduce().`

> Additional Operations we will see below :

flatMap() : Transforms each element into a stream of elements and then flattens these streams into a single stream.

List<List<Integer>> nestedList = Arrays.asList(  
    Arrays.asList(1, 2),  
    Arrays.asList(3, 4),  
    Arrays.asList(5, 6)  
);  
  
List<Integer> flattenedList = nestedList.stream()  
                                        .flatMap(List::stream)  
                                        .collect(Collectors.toList());

`Collectors.groupingBy()`: Groups elements based on a classifier function.

`Collectors.partitioningBy()`: Partitions elements into two groups based on a predicate.

Map<Integer, List<String>> groupedByLength = myList.stream()  
                                                   .collect(Collectors.groupingBy(String::length));  
  
Map<Boolean, List<String>> partitioned = myList.stream()  
                                              .collect(Collectors.partitioningBy(s -> s.length() > 4));

`Stream.concat()`: Concatenates two streams.

Stream<String> stream1 = Stream.of("apple", "banana");  
Stream<String> stream2 = Stream.of("orange", "kiwi");  
  
Stream<String> combinedStream = Stream.concat(stream1, stream2);

> Java 8 introduced specialized streams for primitive types to avoid boxing/unboxing overhead.

IntStream intStream = IntStream.range(1, 5);  
DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);

> Stream API with Files:

`Files.lines()`  returns a stream of lines from a file.

try (Stream<String> lines = Files.lines(Paths.get("myfile.txt"))) {  
    lines.forEach(System.out::println);  
} catch (IOException e) {  
    e.printStackTrace();  
}

`peek()`  allows you to perform a side effect on each element of the stream without changing its contents.

List<String> myList = Arrays.asList("apple", "banana", "orange");  
List<String> result = myList.stream()  
                           .peek(System.out::println)  
                           .collect(Collectors.toList());
