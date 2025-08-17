# HashMap in Java - Complete Guide with Examples

## Table of Contents
1. [Introduction](#introduction)
2. [HashMap Basics](#hashmap-basics)
3. [Problem Types and Solutions](#problem-types-and-solutions)
4. [Advanced Techniques](#advanced-techniques)
5. [Best Practices](#best-practices)
6. [Common Interview Problems](#common-interview-problems)

## Introduction

HashMap is one of the most important data structures in Java, providing efficient key-value storage with O(1) average time complexity for basic operations. This guide covers all concepts with practical examples.

## HashMap Basics

### Creating and Basic Operations

```java
import java.util.*;

public class HashMapBasics {
    public static void main(String[] args) {
        // Creating HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // Adding elements
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);
        
        // Getting elements
        System.out.println(map.get("apple")); // Output: 5
        System.out.println(map.get("grape")); // Output: null
        
        // Check if key exists
        System.out.println(map.containsKey("banana")); // true
        
        // Check if value exists
        System.out.println(map.containsValue(3)); // true
        
        // Size and empty check
        System.out.println(map.size()); // 3
        System.out.println(map.isEmpty()); // false
        
        // Remove element
        map.remove("orange");
        System.out.println(map.size()); // 2
    }
}
```

## Problem Types and Solutions

### 1. Frequency Counting Problems

**Problem**: Count frequency of characters in a string
```java
public class FrequencyCounter {
    // Example 1: Character frequency
    public static Map<Character, Integer> countCharacters(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }
    
    // Example 2: Word frequency
    public static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.merge(word, 1, Integer::sum);
        }
        return freq;
    }
    
    // Example 3: Find first non-repeating character
    public static char firstNonRepeating(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        
        // Count frequencies
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Find first non-repeating
        for (char c : s.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }
        return '\0'; // No non-repeating character found
    }
    
    public static void main(String[] args) {
        // Test character frequency
        String text = "programming";
        System.out.println("Character frequencies: " + countCharacters(text));
        
        // Test word frequency
        String[] words = {"java", "python", "java", "c++", "python", "java"};
        System.out.println("Word frequencies: " + countWords(words));
        
        // Test first non-repeating
        System.out.println("First non-repeating in 'programming': " + 
                         firstNonRepeating("programming")); // 'p'
    }
}
```

### 2. Two Sum and Complement Finding

**Problem**: Find pairs that sum to target
```java
public class TwoSumProblems {
    // Example 1: Classic Two Sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // No solution found
    }
    
    // Example 2: Two Sum - All Pairs
    public static List<int[]> twoSumAllPairs(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        
        // Store all indices for each number
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                for (int j : map.get(complement)) {
                    if (i < j) { // Avoid duplicates and same element
                        String pair = nums[i] + "," + nums[j];
                        if (!seen.contains(pair)) {
                            result.add(new int[]{i, j});
                            seen.add(pair);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    // Example 3: Three Sum using HashMap
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // Skip duplicates
            
            Map<Integer, Integer> map = new HashMap<>();
            int target = -nums[i];
            
            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];
                if (map.containsKey(complement)) {
                    result.add(Arrays.asList(nums[i], complement, nums[j]));
                    // Skip duplicates
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                }
                map.put(nums[j], j);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 6};
        int target = 9;
        
        System.out.println("Two Sum indices: " + Arrays.toString(twoSum(nums, target)));
        
        int[] threeNums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Three Sum: " + threeSum(threeNums));
    }
}
```

### 3. Caching and Memoization

**Problem**: Optimize recursive algorithms using caching
```java
public class MemoizationExamples {
    private static Map<Integer, Long> fibCache = new HashMap<>();
    private static Map<String, Integer> dpCache = new HashMap<>();
    
    // Example 1: Fibonacci with memoization
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }
        
        long result = fibonacci(n-1) + fibonacci(n-2);
        fibCache.put(n, result);
        return result;
    }
    
    // Example 2: Climbing Stairs with memoization
    public static int climbStairs(int n) {
        return climbStairsHelper(n, new HashMap<>());
    }
    
    private static int climbStairsHelper(int n, Map<Integer, Integer> memo) {
        if (n <= 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        
        int result = climbStairsHelper(n-1, memo) + climbStairsHelper(n-2, memo);
        memo.put(n, result);
        return result;
    }
    
    // Example 3: Coin Change with memoization
    public static int coinChange(int[] coins, int amount) {
        return coinChangeHelper(coins, amount, new HashMap<>());
    }
    
    private static int coinChangeHelper(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo.containsKey(amount)) return memo.get(amount);
        
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin, memo);
            if (result != -1) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        
        int finalResult = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        memo.put(amount, finalResult);
        return finalResult;
    }
    
    public static void main(String[] args) {
        System.out.println("Fibonacci(40): " + fibonacci(40));
        System.out.println("Climb 10 stairs: " + climbStairs(10));
        
        int[] coins = {1, 3, 4};
        System.out.println("Min coins for 6: " + coinChange(coins, 6));
    }
}
```

### 4. Grouping and Classification

**Problem**: Group elements by common properties
```java
public class GroupingExamples {
    // Example 1: Group Anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }
    
    // Example 2: Group numbers by their digit sum
    public static Map<Integer, List<Integer>> groupByDigitSum(int[] numbers) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        
        for (int num : numbers) {
            int digitSum = getDigitSum(num);
            groups.computeIfAbsent(digitSum, k -> new ArrayList<>()).add(num);
        }
        
        return groups;
    }
    
    private static int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    // Example 3: Group students by grade
    static class Student {
        String name;
        char grade;
        
        Student(String name, char grade) {
            this.name = name;
            this.grade = grade;
        }
        
        @Override
        public String toString() {
            return name + "(" + grade + ")";
        }
    }
    
    public static Map<Character, List<Student>> groupStudentsByGrade(Student[] students) {
        Map<Character, List<Student>> groups = new HashMap<>();
        
        for (Student student : students) {
            groups.computeIfAbsent(student.grade, k -> new ArrayList<>()).add(student);
        }
        
        return groups;
    }
    
    public static void main(String[] args) {
        // Test anagram grouping
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Anagram groups: " + groupAnagrams(words));
        
        // Test digit sum grouping
        int[] numbers = {12, 21, 345, 543, 678, 876};
        System.out.println("Groups by digit sum: " + groupByDigitSum(numbers));
        
        // Test student grouping
        Student[] students = {
            new Student("Alice", 'A'),
            new Student("Bob", 'B'),
            new Student("Charlie", 'A'),
            new Student("David", 'C'),
            new Student("Eve", 'B')
        };
        System.out.println("Students by grade: " + groupStudentsByGrade(students));
    }
}
```

### 5. Sliding Window with HashMap

**Problem**: Find substrings/subarrays with specific properties
```java
public class SlidingWindowHashMap {
    // Example 1: Longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // Shrink window while we have duplicates
            while (window.get(c) > 1) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Example 2: Find all anagrams in string
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand window
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // Shrink window if too large
            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }
                left++;
            }
            
            // Check if current window is anagram
            if (window.equals(pCount)) {
                result.add(left);
            }
        }
        
        return result;
    }
    
    // Example 3: Minimum window substring
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int valid = 0; // Number of characters that satisfy the condition
        int start = 0, len = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                
                char d = s.charAt(left);
                left++;
                
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
    
    public static void main(String[] args) {
        System.out.println("Longest substring without repeating: " + 
                         lengthOfLongestSubstring("abcabcbb")); // 3
        
        System.out.println("Anagram indices: " + 
                         findAnagrams("abab", "ab")); // [0, 2]
        
        System.out.println("Minimum window: " + 
                         minWindow("ADOBECODEBANC", "ABC")); // "BANC"
    }
}
```

### 6. Custom Objects as Keys

**Problem**: Using complex objects as HashMap keys
```java
public class CustomKeyExamples {
    // Example 1: Point class as key
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return x == p.x && y == p.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
    
    // Example 2: Interval class as key
    static class Interval {
        int start, end;
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Interval)) return false;
            Interval interval = (Interval) obj;
            return start == interval.start && end == interval.end;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
        
        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
    
    public static void demonstrateCustomKeys() {
        // Using Point as key
        Map<Point, String> pointMap = new HashMap<>();
        pointMap.put(new Point(1, 2), "First Point");
        pointMap.put(new Point(3, 4), "Second Point");
        pointMap.put(new Point(1, 2), "Updated First Point"); // Overwrites
        
        System.out.println("Point Map:");
        for (Map.Entry<Point, String> entry : pointMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Using Interval as key
        Map<Interval, Integer> intervalMap = new HashMap<>();
        intervalMap.put(new Interval(1, 5), 100);
        intervalMap.put(new Interval(6, 10), 200);
        intervalMap.put(new Interval(1, 5), 150); // Overwrites
        
        System.out.println("\nInterval Map:");
        for (Map.Entry<Interval, Integer> entry : intervalMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        demonstrateCustomKeys();
    }
}
```

## Advanced Techniques

### HashMap Methods Deep Dive

```java
public class AdvancedHashMapMethods {
    public static void demonstrateAdvancedMethods() {
        Map<String, Integer> map = new HashMap<>();
        
        // 1. getOrDefault - Safe getting with default
        map.put("apple", 5);
        System.out.println(map.getOrDefault("banana", 0)); // Returns 0
        
        // 2. computeIfAbsent - Compute value if key is absent
        map.computeIfAbsent("banana", k -> k.length()); // Puts "banana" -> 6
        
        // 3. computeIfPresent - Compute new value if key exists
        map.computeIfPresent("apple", (k, v) -> v * 2); // Updates "apple" to 10
        
        // 4. compute - Always compute new value
        map.compute("orange", (k, v) -> (v == null) ? 1 : v + 1); // Puts "orange" -> 1
        
        // 5. merge - Merge values
        map.merge("apple", 3, Integer::sum); // Updates "apple" to 13
        
        // 6. putIfAbsent - Put only if key doesn't exist
        map.putIfAbsent("grape", 4); // Puts "grape" -> 4
        map.putIfAbsent("apple", 100); // Doesn't change "apple"
        
        // 7. replace and replaceAll
        map.replace("banana", 10); // Replaces value for "banana"
        map.replaceAll((k, v) -> v + 1); // Increments all values
        
        System.out.println("Final map: " + map);
        
        // 8. forEach with lambda
        System.out.println("Map contents:");
        map.forEach((k, v) -> System.out.println(k + " = " + v));
    }
    
    public static void main(String[] args) {
        demonstrateAdvancedMethods();
    }
}
```

## Common Interview Problems

### Problem Collection

```java
public class InterviewProblems {
    // 1. Isomorphic Strings
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            
            if (mapS.containsKey(c1)) {
                if (mapS.get(c1) != c2) return false;
            } else {
                mapS.put(c1, c2);
            }
            
            if (mapT.containsKey(c2)) {
                if (mapT.get(c2) != c1) return false;
            } else {
                mapT.put(c2, c1);
            }
        }
        return true;
    }
    
    // 2. Subarray Sum Equals K
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Important: empty subarray sum
        
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    
    // 3. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) { // Start of sequence
                int currentNum = num;
                int currentStreak = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    
    // 4. Top K Frequent Elements
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );
        
        pq.addAll(freq.entrySet());
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test all problems
        System.out.println("Isomorphic 'egg' and 'add': " + isIsomorphic("egg", "add"));
        
        int[] arr1 = {1, 1, 1, 2, 2};
        System.out.println("Subarray sum equals 2: " + subarraySum(arr1, 2));
        
        int[] arr2 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive: " + longestConsecutive(arr2));
        
        int[] arr3 = {1, 1, 1, 2, 2, 3};
        System.out.println("Top 2 frequent: " + Arrays.toString(topKFrequent(arr3, 2)));
    }
}
```

## Best Practices

### Performance Tips

```java
public class HashMapBestPractices {
    public static void performanceTips() {
        // 1. Initialize with proper capacity to avoid resizing
        Map<String, Integer> map1 = new HashMap<>(16); // Default
        Map<String, Integer> map2 = new HashMap<>(100); // If you know size
        
        // 2. Use appropriate load factor
        Map<String, Integer> map3 = new HashMap<>(16, 0.75f); // Default load factor
        
        // 3. Use Objects.hash() for custom hashCode
        class Person {
            String name;
            int age;
            
            @Override
            public int hashCode() {
                return Objects.hash(name, age); // Good practice
            }
        }
        
        // 4. Avoid using mutable objects as keys
        List<String> mutableKey = new ArrayList<>(); // Don't use as key!
        String immutableKey = "safe"; // Good to use as key
        
        // 5. Handle null keys carefully
        Map<String, String> map4 = new HashMap<>();
        map4.put(null, "null key allowed"); // Only one null key allowed
        
        // 6. Use appropriate iteration method
        Map<String, Integer> map5 = new HashMap<>();
        map5.put("a", 1);
        map5.put("b", 2);
        
        // Efficient iteration methods:
        // For keys only
        for (String key : map5.keySet()) {
            System.out.println(key);
        }
        
        // For values only
        for (Integer value : map5.values()) {
            System.out.println(value);
        }
        
        // For both key and value (most efficient)
        for (Map.Entry<String, Integer> entry : map5.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        // Using streams (Java 8+)
        map5.entrySet().stream()
            .filter(entry -> entry.getValue() > 0)
            .forEach(entry -> System.out.println(entry.getKey()));
    }
    
    public static void main(String[] args) {
        performanceTips();
    }
}
```

---

## Quick Reference

### Time Complexities
- **get()**: O(1) average, O(n) worst case
- **put()**: O(1) average, O(n) worst case  
- **remove()**: O(1) average, O(n) worst case
- **containsKey()**: O(1) average, O(n) worst case

### Common Patterns
1. **Frequency Counting**: `map.getOrDefault(key, 0) + 1`
2. **Grouping**: `map.computeIfAbsent(key, k -> new ArrayList<>())`
3. **Caching**: Check if key exists before computing
4. **Two Pointers**: Store complement in map
5. **Sliding Window**: Use map to track window contents

### When to Use HashMap
- ✅ Need fast lookups by key
- ✅ Counting frequencies
- ✅ Caching/memoization
- ✅ Grouping elements
- ✅ Finding complements/pairs
- ❌ Need sorted order (use TreeMap)
- ❌ Thread safety required (use ConcurrentHashMap)
- ❌ Memory is very limited (consider alternatives)


# HashMap in Java - Complete Learning Resource 📚

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![HashMap](https://img.shields.io/badge/Data_Structure-HashMap-blue?style=for-the-badge)
![Learning](https://img.shields.io/badge/Level-Beginner_to_Advanced-green?style=for-the-badge)

## 🎯 Overview

This repository contains a comprehensive guide to HashMap in Java, covering everything from basics to advanced problem-solving techniques. Perfect for students, interview preparation, and competitive programming.

## 📋 Table of Contents

- [🚀 Quick Start](#quick-start)
- [📚 What You'll Learn](#what-youll-learn)
- [🎯 Problem Categories](#problem-categories)
- [💡 Key Concepts](#key-concepts)
- [🧪 Running Examples](#running-examples)
- [📖 Study Guide](#study-guide)
- [🎤 Interview Preparation](#interview-preparation)
- [🤝 Contributing](#contributing)

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- Basic understanding of Java syntax
- Familiarity with arrays and loops

