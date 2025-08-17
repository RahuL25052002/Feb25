
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







# Java Character Class Methods Reference

## Character Classification Methods

### Case Classification
- `isUpperCase(char ch)` - Returns true if character is uppercase letter
- `isUpperCase(int codePoint)` - Returns true if Unicode code point is uppercase letter
- `isLowerCase(char ch)` - Returns true if character is lowercase letter
- `isLowerCase(int codePoint)` - Returns true if Unicode code point is lowercase letter
- `isTitleCase(char ch)` - Returns true if character is titlecase letter
- `isTitleCase(int codePoint)` - Returns true if Unicode code point is titlecase letter

```java
// Examples
Character.isUpperCase('A');    // true
Character.isUpperCase('a');    // false
Character.isLowerCase('z');    // true
Character.isLowerCase('Z');    // false
Character.isTitleCase('ǅ');    // true (some Unicode characters)
```

### Letter Classification
- `isLetter(char ch)` - Returns true if character is a letter
- `isLetter(int codePoint)` - Returns true if Unicode code point is a letter
- `isAlphabetic(int codePoint)` - Returns true if code point is alphabetic
- `isLetterOrDigit(char ch)` - Returns true if character is letter or digit
- `isLetterOrDigit(int codePoint)` - Returns true if code point is letter or digit

```java
// Examples
Character.isLetter('A');         // true
Character.isLetter('5');         // false
Character.isLetterOrDigit('A');  // true
Character.isLetterOrDigit('5');  // true
Character.isLetterOrDigit('@');  // false
Character.isAlphabetic('α');     // true (Greek alpha)
```

### Digit Classification
- `isDigit(char ch)` - Returns true if character is a digit (0-9)
- `isDigit(int codePoint)` - Returns true if Unicode code point is a digit
- `digit(char ch, int radix)` - Returns numeric value of character in given radix
- `digit(int codePoint, int radix)` - Returns numeric value of code point in given radix
- `getNumericValue(char ch)` - Returns numeric value of character
- `getNumericValue(int codePoint)` - Returns numeric value of code point

```java
// Examples
Character.isDigit('5');           // true
Character.isDigit('A');           // false
Character.digit('7', 10);         // 7
Character.digit('F', 16);         // 15 (hexadecimal)
Character.getNumericValue('5');   // 5
Character.getNumericValue('Ⅴ');   // 5 (Roman numeral V)
```

### Whitespace and Control Classification
- `isWhitespace(char ch)` - Returns true if character is whitespace
- `isWhitespace(int codePoint)` - Returns true if code point is whitespace
- `isSpaceChar(char ch)` - Returns true if character is space character
- `isSpaceChar(int codePoint)` - Returns true if code point is space character
- `isISOControl(char ch)` - Returns true if character is ISO control character
- `isISOControl(int codePoint)` - Returns true if code point is ISO control character

```java
// Examples
Character.isWhitespace(' ');     // true
Character.isWhitespace('\t');    // true (tab)
Character.isWhitespace('\n');    // true (newline)
Character.isSpaceChar(' ');      // true
Character.isISOControl('\t');    // true
Character.isISOControl('A');     // false
```

---

## Character Conversion Methods

### Case Conversion
- `toUpperCase(char ch)` - Converts character to uppercase
- `toUpperCase(int codePoint)` - Converts code point to uppercase
- `toLowerCase(char ch)` - Converts character to lowercase
- `toLowerCase(int codePoint)` - Converts code point to lowercase
- `toTitleCase(char ch)` - Converts character to titlecase
- `toTitleCase(int codePoint)` - Converts code point to titlecase

```java
// Examples
Character.toUpperCase('a');      // 'A'
Character.toUpperCase('A');      // 'A' (already uppercase)
Character.toLowerCase('Z');      // 'z'
Character.toLowerCase('z');      // 'z' (already lowercase)
Character.toTitleCase('a');      // 'A'
```

### Numeric Conversion
- `forDigit(int digit, int radix)` - Returns character representation of digit in radix
- `toString(char ch)` - Returns String representation of character
- `toString(int codePoint)` - Returns String representation of code point

```java
// Examples
Character.forDigit(10, 16);      // 'a' (10 in hex is 'a')
Character.forDigit(7, 10);       // '7'
Character.toString('A');         // "A"
Character.toString(65);          // "A" (65 is ASCII for 'A')
```

---

## Unicode and Code Point Methods

### Code Point Operations
- `codePointAt(char[] a, int index)` - Returns code point at index in array
- `codePointAt(char[] a, int index, int limit)` - Returns code point with limit
- `codePointAt(CharSequence seq, int index)` - Returns code point in sequence
- `codePointBefore(char[] a, int index)` - Returns code point before index
- `codePointBefore(char[] a, int index, int start)` - Returns code point before with start
- `codePointBefore(CharSequence seq, int index)` - Returns code point before in sequence
- `codePointCount(char[] a, int offset, int count)` - Counts code points in array range
- `codePointCount(CharSequence seq, int beginIndex, int endIndex)` - Counts code points in sequence

```java
// Examples
String text = "A𝔘";  // 'A' + Unicode mathematical double-struck capital U
Character.codePointAt(text, 0);     // 65 (code point for 'A')
Character.codePointAt(text, 1);     // 119842 (code point for 𝔘)
Character.codePointCount(text, 0, text.length()); // 2
```

### Surrogate Methods (for Unicode beyond BMP)
- `isHighSurrogate(char ch)` - Returns true if char is high surrogate
- `isLowSurrogate(char ch)` - Returns true if char is low surrogate
- `isSurrogate(char ch)` - Returns true if char is surrogate
- `isSurrogatePair(char high, char low)` - Returns true if valid surrogate pair
- `toCodePoint(char high, char low)` - Combines surrogates into code point
- `highSurrogate(int codePoint)` - Returns high surrogate for code point
- `lowSurrogate(int codePoint)` - Returns low surrogate for code point

```java
// Examples (for characters beyond Basic Multilingual Plane)
String emoji = "🚀";  // Rocket emoji
char high = emoji.charAt(0);
char low = emoji.charAt(1);

Character.isHighSurrogate(high);           // true
Character.isLowSurrogate(low);             // true
Character.isSurrogatePair(high, low);      // true
Character.toCodePoint(high, low);          // 128640 (rocket emoji code point)
```

### Unicode Category Methods
- `getType(char ch)` - Returns Unicode category of character
- `getType(int codePoint)` - Returns Unicode category of code point
- `getDirectionality(char ch)` - Returns Unicode directionality
- `getDirectionality(int codePoint)` - Returns Unicode directionality

```java
// Examples
Character.getType('A');          // 1 (UPPERCASE_LETTER)
Character.getType('5');          // 9 (DECIMAL_DIGIT_NUMBER)
Character.getType(' ');          // 12 (SPACE_SEPARATOR)
Character.getDirectionality('A'); // 0 (LEFT_TO_RIGHT)
```

---

## Utility and Comparison Methods

### Comparison Methods
- `compare(char x, char y)` - Compares two char values numerically
- `equals(Object obj)` - Compares with another Character object
- `compareTo(Character anotherCharacter)` - Compares Character objects

```java
// Examples
Character.compare('a', 'b');     // negative value (a < b)
Character.compare('z', 'a');     // positive value (z > a)
Character.compare('x', 'x');     // 0 (equal)

Character c1 = 'A';
Character c2 = 'A';
c1.equals(c2);                   // true
c1.compareTo(c2);                // 0
```

### Hash Code and String Methods
- `hashCode()` - Returns hash code for Character
- `hashCode(char value)` - Static method returning hash code for char
- `toString()` - Returns String representation
- `charValue()` - Returns primitive char value

```java
// Examples
Character c = 'A';
c.hashCode();                    // hash code for 'A'
Character.hashCode('A');         // same hash code (static method)
c.toString();                    // "A"
c.charValue();                   // 'A' (primitive char)
```

---

## Character Constants

### Unicode Categories (getType() return values)
- `UNASSIGNED` = 0
- `UPPERCASE_LETTER` = 1
- `LOWERCASE_LETTER` = 2
- `TITLECASE_LETTER` = 3
- `MODIFIER_LETTER` = 4
- `OTHER_LETTER` = 5
- `NON_SPACING_MARK` = 6
- `ENCLOSING_MARK` = 7
- `COMBINING_SPACING_MARK` = 8
- `DECIMAL_DIGIT_NUMBER` = 9
- `LETTER_NUMBER` = 10
- `OTHER_NUMBER` = 11
- `SPACE_SEPARATOR` = 12
- `LINE_SEPARATOR` = 13
- `PARAGRAPH_SEPARATOR` = 14
- `CONTROL` = 15
- `FORMAT` = 16
- `PRIVATE_USE` = 18
- `SURROGATE` = 19
- `DASH_PUNCTUATION` = 20
- `START_PUNCTUATION` = 21
- `END_PUNCTUATION` = 22
- `CONNECTOR_PUNCTUATION` = 23
- `OTHER_PUNCTUATION` = 24
- `MATH_SYMBOL` = 25
- `CURRENCY_SYMBOL` = 26
- `MODIFIER_SYMBOL` = 27
- `OTHER_SYMBOL` = 28
- `INITIAL_QUOTE_PUNCTUATION` = 29
- `FINAL_QUOTE_PUNCTUATION` = 30

### Directionality Constants (getDirectionality() return values)
- `DIRECTIONALITY_LEFT_TO_RIGHT` = 0
- `DIRECTIONALITY_RIGHT_TO_LEFT` = 1
- `DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC` = 2
- `DIRECTIONALITY_EUROPEAN_NUMBER` = 3
- `DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR` = 4
- `DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR` = 5
- `DIRECTIONALITY_ARABIC_NUMBER` = 6
- `DIRECTIONALITY_COMMON_NUMBER_SEPARATOR` = 7
- `DIRECTIONALITY_NONSPACING_MARK` = 8
- `DIRECTIONALITY_BOUNDARY_NEUTRAL` = 9
- `DIRECTIONALITY_PARAGRAPH_SEPARATOR` = 10
- `DIRECTIONALITY_SEGMENT_SEPARATOR` = 11
- `DIRECTIONALITY_WHITESPACE` = 12
- `DIRECTIONALITY_OTHER_NEUTRALS` = 13
- `DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING` = 14
- `DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE` = 15
- `DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING` = 16
- `DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE` = 17
- `DIRECTIONALITY_POP_DIRECTIONAL_FORMAT` = 18

### Size Constants
- `MIN_VALUE` = '\u0000' (minimum char value)
- `MAX_VALUE` = '\uffff' (maximum char value)
- `MIN_HIGH_SURROGATE` = '\uD800' (minimum high surrogate)
- `MAX_HIGH_SURROGATE` = '\uDBFF' (maximum high surrogate)
- `MIN_LOW_SURROGATE` = '\uDC00' (minimum low surrogate)
- `MAX_LOW_SURROGATE` = '\uDFFF' (maximum low surrogate)
- `MIN_SURROGATE` = '\uD800' (minimum surrogate)
- `MAX_SURROGATE` = '\uDFFF' (maximum surrogate)
- `MIN_CODE_POINT` = 0 (minimum Unicode code point)
- `MAX_CODE_POINT` = 1114111 (maximum Unicode code point)
- `MIN_RADIX` = 2 (minimum radix for digit methods)
- `MAX_RADIX` = 36 (maximum radix for digit methods)
- `SIZE` = 16 (number of bits in char)
- `BYTES` = 2 (number of bytes in char)

---

## Common Usage Patterns

### Validating Input Characters
```java
public static boolean isValidUsername(String username) {
    for (char c : username.toCharArray()) {
        if (!Character.isLetterOrDigit(c) && c != '_') {
            return false;
        }
    }
    return true;
}
```

### Converting String Cases Manually
```java
public static String toAlternatingCase(String str) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (i % 2 == 0) {
            result.append(Character.toUpperCase(c));
        } else {
            result.append(Character.toLowerCase(c));
        }
    }
    return result.toString();
}
```

### Counting Character Types
```java
public static void analyzeString(String str) {
    int letters = 0, digits = 0, spaces = 0, others = 0;

    for (char c : str.toCharArray()) {
        if (Character.isLetter(c)) letters++;
        else if (Character.isDigit(c)) digits++;
        else if (Character.isWhitespace(c)) spaces++;
        else others++;
    }

    System.out.println("Letters: " + letters);
    System.out.println("Digits: " + digits);
    System.out.println("Spaces: " + spaces);
    System.out.println("Others: " + others);
}
```

### Working with Unicode
```java
public static void printUnicodeInfo(String str) {
    for (int i = 0; i < str.length(); ) {
        int codePoint = Character.codePointAt(str, i);
        System.out.println("Character: " + new String(Character.toChars(codePoint)));
        System.out.println("Code Point: " + codePoint);
        System.out.println("Category: " + Character.getType(codePoint));

        i += Character.charCount(codePoint); // Handle surrogate pairs
    }
}
```

---

*This reference covers all major Character class methods. The Character class is essential for text processing, validation, and Unicode handling in Java applications.*
