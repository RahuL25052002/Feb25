
# String and Collection Methods Reference Guide

## String Methods (Java)

### Basic String Operations

#### Length and Character Access

-   `length()` - Returns the length of the string
-   `charAt(int index)` - Returns character at specified index
-   `isEmpty()` - Checks if string is empty (length = 0)
-   `isBlank()` - Checks if string is empty or contains only whitespace (Java 11+)

#### String Comparison

-   `equals(Object obj)` - Compares strings for equality (case-sensitive)
-   `equalsIgnoreCase(String str)` - Compares strings ignoring case
-   `compareTo(String str)` - Lexicographically compares strings
-   `compareToIgnoreCase(String str)` - Case-insensitive lexicographic comparison

#### String Search

-   `indexOf(String str)` - Returns index of first occurrence
-   `indexOf(String str, int fromIndex)` - Returns index of first occurrence from specified index
-   `lastIndexOf(String str)` - Returns index of last occurrence
-   `contains(CharSequence seq)` - Checks if string contains specified sequence
-   `startsWith(String prefix)` - Checks if string starts with specified prefix
-   `endsWith(String suffix)` - Checks if string ends with specified suffix

#### String Modification (Returns new String)

-   `toLowerCase()` - Converts to lowercase
-   `toUpperCase()` - Converts to uppercase
-   `trim()` - Removes leading and trailing whitespace
-   `strip()` - Removes leading and trailing whitespace (Unicode-aware, Java 11+)
-   `replace(char oldChar, char newChar)` - Replaces all occurrences of character
-   `replace(CharSequence target, CharSequence replacement)` - Replaces all occurrences of sequence
-   `replaceAll(String regex, String replacement)` - Replaces using regex
-   `replaceFirst(String regex, String replacement)` - Replaces first match using regex

#### String Splitting and Joining

-   `split(String regex)` - Splits string into array using regex
-   `split(String regex, int limit)` - Splits with limit on number of splits
-   `join(CharSequence delimiter, CharSequence... elements)` - Static method to join strings
-   `concat(String str)` - Concatenates strings

#### String Conversion

-   `valueOf(Object obj)` - Static method to convert object to string
-   `toString()` - Returns string representation
-   `toCharArray()` - Converts string to character array
-   `getBytes()` - Converts string to byte array

#### Substring Operations

-   `substring(int beginIndex)` - Returns substring from index to end
-   `substring(int beginIndex, int endIndex)` - Returns substring between indices

----------

## Collection Framework Methods

### List Interface Methods

#### Basic Operations

-   `add(E element)` - Adds element to end of list
-   `add(int index, E element)` - Inserts element at specified position
-   `remove(Object obj)` - Removes first occurrence of object
-   `remove(int index)` - Removes element at specified index
-   `get(int index)` - Returns element at specified index
-   `set(int index, E element)` - Replaces element at specified index
-   `size()` - Returns number of elements
-   `isEmpty()` - Checks if list is empty
-   `clear()` - Removes all elements

#### Search Operations

-   `contains(Object obj)` - Checks if list contains object
-   `indexOf(Object obj)` - Returns index of first occurrence
-   `lastIndexOf(Object obj)` - Returns index of last occurrence

#### Bulk Operations

-   `addAll(Collection<? extends E> c)` - Adds all elements from collection
-   `addAll(int index, Collection<? extends E> c)` - Inserts all elements at index
-   `removeAll(Collection<?> c)` - Removes all elements in collection
-   `retainAll(Collection<?> c)` - Retains only elements in collection
-   `containsAll(Collection<?> c)` - Checks if contains all elements

#### List-Specific Operations

-   `subList(int fromIndex, int toIndex)` - Returns view of portion of list
-   `sort(Comparator<? super E> c)` - Sorts list using comparator
-   `replaceAll(UnaryOperator<E> operator)` - Replaces all elements using function

### ArrayList Specific Methods

-   `ensureCapacity(int minCapacity)` - Ensures capacity for elements
-   `trimToSize()` - Trims capacity to current size

### LinkedList Specific Methods

-   `addFirst(E element)` - Adds element to beginning
-   `addLast(E element)` - Adds element to end
-   `removeFirst()` - Removes first element
-   `removeLast()` - Removes last element
-   `getFirst()` - Gets first element
-   `getLast()` - Gets last element
-   `offer(E element)` - Adds element (Queue operation)
-   `poll()` - Removes and returns head (Queue operation)
-   `peek()` - Returns head without removing (Queue operation)

----------

### Set Interface Methods

#### Basic Operations

-   `add(E element)` - Adds element if not present
-   `remove(Object obj)` - Removes element
-   `contains(Object obj)` - Checks if set contains element
-   `size()` - Returns number of elements
-   `isEmpty()` - Checks if set is empty
-   `clear()` - Removes all elements

#### Bulk Operations

-   `addAll(Collection<? extends E> c)` - Union operation
-   `removeAll(Collection<?> c)` - Difference operation
-   `retainAll(Collection<?> c)` - Intersection operation
-   `containsAll(Collection<?> c)` - Subset check

### TreeSet Specific Methods

-   `first()` - Returns first (lowest) element
-   `last()` - Returns last (highest) element
-   `lower(E element)` - Returns greatest element less than given
-   `floor(E element)` - Returns greatest element less than or equal
-   `ceiling(E element)` - Returns least element greater than or equal
-   `higher(E element)` - Returns least element greater than given
-   `pollFirst()` - Removes and returns first element
-   `pollLast()` - Removes and returns last element
-   `headSet(E toElement)` - Returns elements less than toElement
-   `tailSet(E fromElement)` - Returns elements greater than or equal to fromElement
-   `subSet(E fromElement, E toElement)` - Returns elements in range

----------

### Map Interface Methods

#### Basic Operations

-   `put(K key, V value)` - Associates value with key
-   `get(Object key)` - Returns value for key
-   `remove(Object key)` - Removes mapping for key
-   `containsKey(Object key)` - Checks if map contains key
-   `containsValue(Object value)` - Checks if map contains value
-   `size()` - Returns number of mappings
-   `isEmpty()` - Checks if map is empty
-   `clear()` - Removes all mappings

#### Bulk Operations

-   `putAll(Map<? extends K, ? extends V> m)` - Copies all mappings
-   `keySet()` - Returns set of keys
-   `values()` - Returns collection of values
-   `entrySet()` - Returns set of key-value pairs

#### Java 8+ Methods

-   `putIfAbsent(K key, V value)` - Puts if key not present
-   `replace(K key, V value)` - Replaces value for key
-   `replace(K key, V oldValue, V newValue)` - Conditional replace
-   `getOrDefault(Object key, V defaultValue)` - Returns value or default
-   `forEach(BiConsumer<? super K, ? super V> action)` - Performs action on each entry
-   `compute(K key, BiFunction<? super K, ? super V, ? extends V> function)` - Computes new value
-   `computeIfAbsent(K key, Function<? super K, ? extends V> function)` - Computes if key absent
-   `computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> function)` - Computes if key present
-   `merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> function)` - Merges values

### TreeMap Specific Methods

-   `firstKey()` - Returns first (lowest) key
-   `lastKey()` - Returns last (highest) key
-   `lowerKey(K key)` - Returns greatest key less than given
-   `floorKey(K key)` - Returns greatest key less than or equal
-   `ceilingKey(K key)` - Returns least key greater than or equal
-   `higherKey(K key)` - Returns least key greater than given
-   `firstEntry()` - Returns first key-value mapping
-   `lastEntry()` - Returns last key-value mapping
-   `pollFirstEntry()` - Removes and returns first entry
-   `pollLastEntry()` - Removes and returns last entry
-   `headMap(K toKey)` - Returns mappings with keys less than toKey
-   `tailMap(K fromKey)` - Returns mappings with keys greater than or equal
-   `subMap(K fromKey, K toKey)` - Returns mappings in key range

----------

### Queue Interface Methods

#### Basic Operations

-   `add(E element)` - Inserts element (throws exception if fails)
-   `offer(E element)` - Inserts element (returns false if fails)
-   `remove()` - Removes head (throws exception if empty)
-   `poll()` - Removes head (returns null if empty)
-   `element()` - Returns head (throws exception if empty)
-   `peek()` - Returns head (returns null if empty)

### Deque Interface Methods

#### Insertion

-   `addFirst(E element)` - Inserts at front
-   `addLast(E element)` - Inserts at rear
-   `offerFirst(E element)` - Inserts at front (capacity-restricted)
-   `offerLast(E element)` - Inserts at rear (capacity-restricted)

#### Removal

-   `removeFirst()` - Removes from front
-   `removeLast()` - Removes from rear
-   `pollFirst()` - Removes from front (returns null if empty)
-   `pollLast()` - Removes from rear (returns null if empty)

#### Examination

-   `getFirst()` - Gets first element
-   `getLast()` - Gets last element
-   `peekFirst()` - Peeks at first element
-   `peekLast()` - Peeks at last element

----------

### Stack Class Methods (Legacy)

-   `push(E item)` - Pushes item onto stack
-   `pop()` - Removes and returns top item
-   `peek()` - Returns top item without removing
-   `empty()` - Checks if stack is empty
-   `search(Object obj)` - Searches for object (1-based index from top)

----------

### Collections Utility Class Methods

#### Sorting and Searching

-   `sort(List<T> list)` - Sorts list in natural order
-   `sort(List<T> list, Comparator<? super T> c)` - Sorts with comparator
-   `binarySearch(List<? extends Comparable<? super T>> list, T key)` - Binary search
-   `reverse(List<?> list)` - Reverses order of elements
-   `shuffle(List<?> list)` - Randomly shuffles elements

#### Finding Extremes

-   `max(Collection<? extends T> coll)` - Returns maximum element
-   `min(Collection<? extends T> coll)` - Returns minimum element
-   `max(Collection<? extends T> coll, Comparator<? super T> comp)` - Max with comparator
-   `min(Collection<? extends T> coll, Comparator<? super T> comp)` - Min with comparator

#### Element Operations

-   `frequency(Collection<?> c, Object o)` - Counts occurrences
-   `disjoint(Collection<?> c1, Collection<?> c2)` - Checks if no common elements
-   `addAll(Collection<? super T> c, T... elements)` - Adds elements to collection

#### List Operations

-   `rotate(List<?> list, int distance)` - Rotates elements
-   `swap(List<?> list, int i, int j)` - Swaps elements at indices
-   `fill(List<? super T> list, T obj)` - Replaces all elements with specified
-   `copy(List<? super T> dest, List<? extends T> src)` - Copies list
-   `replaceAll(List<T> list, T oldVal, T newVal)` - Replaces all occurrences

#### Creating Unmodifiable Collections

-   `unmodifiableList(List<? extends T> list)` - Returns unmodifiable list
-   `unmodifiableSet(Set<? extends T> s)` - Returns unmodifiable set
-   `unmodifiableMap(Map<? extends K, ? extends V> m)` - Returns unmodifiable map
-   `unmodifiableCollection(Collection<? extends T> c)` - Returns unmodifiable collection

#### Creating Synchronized Collections

-   `synchronizedList(List<T> list)` - Returns synchronized list
-   `synchronizedSet(Set<T> s)` - Returns synchronized set
-   `synchronizedMap(Map<K,V> m)` - Returns synchronized map
-   `synchronizedCollection(Collection<T> c)` - Returns synchronized collection

#### Creating Empty/Singleton Collections

-   `emptyList()` - Returns empty list
-   `emptySet()` - Returns empty set
-   `emptyMap()` - Returns empty map
-   `singletonList(T o)` - Returns list with single element
-   `singleton(T o)` - Returns set with single element
-   `singletonMap(K key, V value)` - Returns map with single mapping

----------

## Common Patterns and Tips

### String Operations

```java
// Check if string is null or empty
if (str == null || str.isEmpty()) { ... }

// Safe string comparison
Objects.equals(str1, str2)

// String building for multiple operations
StringBuilder sb = new StringBuilder();
sb.append("text").append(123);
String result = sb.toString();

```

### Collection Operations

```java
// Safe collection iteration
for (String item : collection) { ... }

// Stream operations (Java 8+)
list.stream()
    .filter(x -> x.length() > 5)
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// Initialize collections
List<String> list = Arrays.asList("a", "b", "c");
Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));

```

### Performance Considerations

-   Use `StringBuilder` for multiple string concatenations
-   Use `ArrayList` for frequent access by index
-   Use `LinkedList` for frequent insertion/deletion
-   Use `HashMap` for key-based lookups
-   Use `TreeMap` for sorted key operations
-   Use `HashSet` for uniqueness checking
-   Use `TreeSet` for sorted unique elements

----------

_This reference guide covers the most commonly used methods. Always refer to the official Java documentation for complete method signatures and detailed behavior._
