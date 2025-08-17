# Regular Expressions (Regex) - Complete Guide

## Table of Contents
1. [What is Regex?](#what-is-regex)
2. [Basic Syntax](#basic-syntax)
3. [Character Classes](#character-classes)
4. [Quantifiers](#quantifiers)
5. [Anchors and Boundaries](#anchors-and-boundaries)
6. [Groups and Capturing](#groups-and-capturing)
7. [Common Patterns](#common-patterns)
8. [Java Implementation](#java-implementation)
9. [Real-World Examples](#real-world-examples)
10. [Best Practices](#best-practices)
11. [Cheat Sheet](#cheat-sheet)
12. [Resources](#resources)

---

## What is Regex?

**Regular Expression (Regex)** is a sequence of characters that defines a search pattern. It's used for:
- Pattern matching in strings
- Text validation (emails, phone numbers, etc.)
- Search and replace operations
- Data extraction from text
- Input sanitization

### Why Use Regex?
- **Powerful**: Can describe complex patterns in a concise way
- **Flexible**: Works across different programming languages
- **Efficient**: Fast pattern matching for large texts
- **Standardized**: Similar syntax across platforms

---

## Basic Syntax

### Literal Characters
Most characters match themselves exactly:
```regex
hello       # matches "hello"
123         # matches "123"
abc123      # matches "abc123"
```

### Metacharacters (Special Characters)
These characters have special meanings:
```
. ^ $ * + ? { } [ ] \ | ( )
```

To match these literally, escape them with backslash `\`:
```regex
\.          # matches literal dot
\$          # matches literal dollar sign
\\          # matches literal backslash
```

---

## Character Classes

### Basic Character Classes
```regex
[abc]       # matches 'a', 'b', or 'c'
[a-z]       # matches any lowercase letter
[A-Z]       # matches any uppercase letter
[0-9]       # matches any digit
[a-zA-Z]    # matches any letter
[a-zA-Z0-9] # matches any alphanumeric character
```

### Negated Character Classes
```regex
[^abc]      # matches anything EXCEPT 'a', 'b', or 'c'
[^0-9]      # matches anything that's not a digit
[^a-zA-Z]   # matches anything that's not a letter
```

### Predefined Character Classes
```regex
.           # matches any character except newline
\d          # matches any digit [0-9]
\D          # matches any non-digit [^0-9]
\w          # matches any word character [a-zA-Z0-9_]
\W          # matches any non-word character [^a-zA-Z0-9_]
\s          # matches any whitespace character [ \t\n\r\f]
\S          # matches any non-whitespace character [^ \t\n\r\f]
```

---

## Quantifiers

### Basic Quantifiers
```regex
*           # 0 or more times
+           # 1 or more times
?           # 0 or 1 time (optional)
```

### Specific Quantifiers
```regex
{n}         # exactly n times
{n,}        # n or more times
{n,m}       # between n and m times (inclusive)
```

### Examples
```regex
a*          # "", "a", "aa", "aaa", ...
a+          # "a", "aa", "aaa", ... (but not "")
a?          # "", "a"
a{3}        # "aaa"
a{2,4}      # "aa", "aaa", "aaaa"
\d{3}       # exactly 3 digits
\d{1,3}     # 1 to 3 digits
```

### Greedy vs Non-Greedy
```regex
.*          # greedy: matches as much as possible
.*?         # non-greedy: matches as little as possible
.+          # greedy
.+?         # non-greedy
```

---

## Anchors and Boundaries

### String Anchors
```regex
^           # start of string
$           # end of string
^abc$       # matches "abc" exactly (entire string)
```

### Word Boundaries
```regex
\b          # word boundary
\B          # non-word boundary
\bcat\b     # matches "cat" as a whole word
\Bcat\B     # matches "cat" inside another word
```

### Examples
```regex
^Hello      # matches strings starting with "Hello"
world$      # matches strings ending with "world"
^\d+$       # matches strings containing only digits
\b\w{4}\b   # matches 4-letter words
```

---

## Groups and Capturing

### Basic Groups
```regex
(abc)       # capturing group
(?:abc)     # non-capturing group
```

### Alternation (OR)
```regex
cat|dog     # matches "cat" or "dog"
(cat|dog)   # captures "cat" or "dog"
```

### Backreferences
```regex
(\w+) \1    # matches repeated words like "hello hello"
```

### Examples
```java
// Java example with groups
String text = "John Doe";
Pattern pattern = Pattern.compile("(\\w+) (\\w+)");
Matcher matcher = pattern.matcher(text);
if (matcher.find()) {
    System.out.println("First name: " + matcher.group(1));  // John
    System.out.println("Last name: " + matcher.group(2));   // Doe
}
```

---

## Common Patterns

### Email Validation
```regex
^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$

# Breakdown:
^                   # start of string
[a-zA-Z0-9._%+-]+   # username part
@                   # literal @
[a-zA-Z0-9.-]+      # domain name
\.                  # literal dot
[a-zA-Z]{2,}        # domain extension (2+ letters)
$                   # end of string
```

### Phone Numbers
```regex
# US format: (123) 456-7890
^\([0-9]{3}\) [0-9]{3}-[0-9]{4}$

# International format: +1-123-456-7890
^\+\d{1,3}-\d{3,4}-\d{3,4}-\d{4}$

# Flexible format
^[\+]?[1-9][\d]{0,15}$
```

### URLs
```regex
^https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)$
```

### IP Addresses
```regex
# IPv4
^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$

# Simple IPv4
^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$
```

### Dates
```regex
# MM/DD/YYYY
^(0[1-9]|1[0-2])\/(0[1-9]|[12][0-9]|3[01])\/\d{4}$

# YYYY-MM-DD
^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$
```

### Password Validation
```regex
# At least 8 chars, 1 uppercase, 1 lowercase, 1 digit, 1 special
^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$
```

---

## Java Implementation

### String Methods
```java
// matches() - entire string must match
"hello123".matches("\\w+");        // true

// split() - split string using regex
String[] parts = "one,two,three".split(",");

// replaceAll() - replace all matches
String result = "abc123def456".replaceAll("\\d+", "X");  // "abcXdefX"

// replaceFirst() - replace first match only
String result = "abc123def456".replaceFirst("\\d+", "X");  // "abcXdef456"
```

### Pattern and Matcher Classes
```java
import java.util.regex.*;

// Compile pattern for reuse
Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher("abc123def456");

// Find all matches
while (matcher.find()) {
    System.out.println("Found: " + matcher.group());
    System.out.println("Position: " + matcher.start() + "-" + matcher.end());
}

// Check if pattern matches
boolean matches = matcher.matches();

// Find first match
boolean found = matcher.find();

// Replace matches
String result = matcher.replaceAll("NUMBER");
```

### Pattern Flags
```java
// Case insensitive
Pattern pattern = Pattern.compile("hello", Pattern.CASE_INSENSITIVE);

// Multiple flags
Pattern pattern = Pattern.compile("hello", 
    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

// Common flags:
Pattern.CASE_INSENSITIVE    // (?i)
Pattern.MULTILINE          // (?m)
Pattern.DOTALL            // (?s) - dot matches newlines
Pattern.UNICODE_CASE      // (?u)
```

---

## Real-World Examples

### Data Validation
```java
public class Validator {
    
    // Email validation
    public static boolean isValidEmail(String email) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(pattern);
    }
    
    // Phone validation (US format)
    public static boolean isValidPhone(String phone) {
        String pattern = "^\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}$";
        return phone.matches(pattern);
    }
    
    // Strong password validation
    public static boolean isStrongPassword(String password) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(pattern);
    }
}
```

### Log File Processing
```java
public class LogProcessor {
    
    public static void parseLogFile(String logContent) {
        // Extract timestamps: 2024-01-15 10:30:45
        Pattern timestampPattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})");
        
        // Extract IP addresses
        Pattern ipPattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
        
        // Extract error levels
        Pattern levelPattern = Pattern.compile("\\b(ERROR|WARN|INFO|DEBUG)\\b");
        
        Matcher matcher = timestampPattern.matcher(logContent);
        while (matcher.find()) {
            System.out.println("Timestamp: " + matcher.group(1));
        }
    }
}
```

### Data Extraction
```java
public class DataExtractor {
    
    // Extract all URLs from text
    public static List<String> extractUrls(String text) {
        List<String> urls = new ArrayList<>();
        String urlPattern = "https?://[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&:/~\\+#]*[\\w\\-\\@?^=%&/~\\+#])?";
        
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            urls.add(matcher.group());
        }
        return urls;
    }
    
    // Extract credit card numbers (masked for security)
    public static List<String> extractCreditCards(String text) {
        List<String> cards = new ArrayList<>();
        String ccPattern = "\\b(?:\\d{4}[- ]?){3}\\d{4}\\b";
        
        Pattern pattern = Pattern.compile(ccPattern);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            String card = matcher.group();
            // Mask the card number for security
            String masked = card.substring(0, 4) + " **** **** " + card.substring(card.length() - 4);
            cards.add(masked);
        }
        return cards;
    }
}
```

### Text Cleaning and Formatting
```java
public class TextCleaner {
    
    // Remove extra whitespaces
    public static String cleanWhitespace(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
    
    // Remove HTML tags
    public static String removeHtmlTags(String html) {
        return html.replaceAll("<[^>]+>", "");
    }
    
    // Format phone numbers
    public static String formatPhoneNumber(String phone) {
        String digits = phone.replaceAll("[^0-9]", "");
        if (digits.length() == 10) {
            return digits.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
        }
        return phone; // return original if not 10 digits
    }
    
    // Capitalize words
    public static String capitalizeWords(String text) {
        return text.replaceAll("\\b(\\w)(\\w*)", 
            match -> match.group(1).toUpperCase() + match.group(2).toLowerCase());
    }
}
```

---

## Best Practices

### 1. Keep It Simple
```java
// Good: Simple and readable
String phonePattern = "\\d{3}-\\d{3}-\\d{4}";

// Avoid: Overly complex patterns that are hard to maintain
String complexPattern = "^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$";
```

### 2. Use Comments and Documentation
```java
public class RegexPatterns {
    // Email pattern: user@domain.com
    // ^[a-zA-Z0-9._%+-]+  - username part
    // @                   - literal @ symbol  
    // [a-zA-Z0-9.-]+      - domain name
    // \.                  - literal dot
    // [a-zA-Z]{2,}        - domain extension
    // $                   - end of string
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
}
```

### 3. Compile Patterns for Reuse
```java
// Good: Compile once, use many times
public class EmailValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );
    
    public static boolean isValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}

// Avoid: Compiling pattern every time
public static boolean isValidEmail(String email) {
    return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // Inefficient!
}
```

### 4. Handle Edge Cases
```java
public static boolean isValidInput(String input) {
    // Check for null or empty
    if (input == null || input.trim().isEmpty()) {
        return false;
    }
    
    // Apply regex validation
    return input.matches("^[a-zA-Z0-9]+$");
}
```

### 5. Use Appropriate Methods
```java
// Use matches() for entire string validation
boolean isValid = input.matches("\\d+");

// Use find() for searching within text
Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    // Process each match
}

// Use split() for tokenization
String[] parts = text.split("\\s+");

// Use replaceAll() for substitution
String cleaned = text.replaceAll("\\s+", " ");
```

---

## Cheat Sheet

### Character Classes
| Pattern | Description | Example |
|---------|-------------|---------|
| `[abc]` | Any of a, b, c | `[aeiou]` matches vowels |
| `[^abc]` | Not a, b, c | `[^0-9]` matches non-digits |
| `[a-z]` | Range a to z | `[A-Za-z]` matches letters |
| `.` | Any character | `a.c` matches "abc", "axc" |
| `\d` | Digit [0-9] | `\d+` matches "123" |
| `\D` | Non-digit | `\D+` matches "abc" |
| `\w` | Word char [a-zA-Z0-9_] | `\w+` matches "hello_123" |
| `\W` | Non-word char | `\W+` matches "@#$" |
| `\s` | Whitespace | `\s+` matches spaces |
| `\S` | Non-whitespace | `\S+` matches "hello" |

### Quantifiers
| Pattern | Description | Example |
|---------|-------------|---------|
| `*` | 0 or more | `a*` matches "", "a", "aaa" |
| `+` | 1 or more | `a+` matches "a", "aaa" |
| `?` | 0 or 1 | `a?` matches "", "a" |
| `{n}` | Exactly n | `a{3}` matches "aaa" |
| `{n,}` | n or more | `a{2,}` matches "aa", "aaa" |
| `{n,m}` | n to m times | `a{2,4}` matches "aa" to "aaaa" |

### Anchors
| Pattern | Description | Example |
|---------|-------------|---------|
| `^` | Start of string | `^Hello` matches "Hello world" |
| `$` | End of string | `world$` matches "Hello world" |
| `\b` | Word boundary | `\bcat\b` matches "cat" (whole word) |
| `\B` | Non-word boundary | `\Bcat\B` matches "concatenate" |

### Groups
| Pattern | Description | Example |
|---------|-------------|---------|
| `(abc)` | Capturing group | `(cat\|dog)` captures "cat" or "dog" |
| `(?:abc)` | Non-capturing group | `(?:cat\|dog)+` matches patterns |
| `\|` | Alternation (OR) | `cat\|dog` matches "cat" or "dog" |
| `\1` | Backreference | `(\w+) \1` matches "hello hello" |

### Escape Sequences
| Pattern | Description |
|---------|-------------|
| `\.` | Literal dot |
| `\*` | Literal asterisk |
| `\+` | Literal plus |
| `\?` | Literal question mark |
| `\\` | Literal backslash |
| `\[` | Literal opening bracket |
| `\]` | Literal closing bracket |
| `\(` | Literal opening parenthesis |
| `\)` | Literal closing parenthesis |

---

## Resources

### Online Tools
- [regex101.com](https://regex101.com/) - Interactive regex tester with explanations
- [regexpal.com](https://regexpal.com/) - Simple regex testing tool
- [regexr.com](https://regexr.com/) - Visual regex builder and tester
- [regexlib.com](https://regexlib.com/) - Library of common regex patterns

### Documentation
- [Java Pattern Class](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
- [Java Matcher Class](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html)
- [Oracle Regex Tutorial](https://docs.oracle.com/javase/tutorial/essential/regex/)

### Books
- "Mastering Regular Expressions" by Jeffrey Friedl
- "Regular Expressions Cookbook" by Jan Goyvaerts & Steven Levithan

### Practice Sites
- [RegexOne](https://regexone.com/) - Interactive regex tutorial
- [RegexCrossword](https://regexcrossword.com/) - Regex puzzles
- [HackerRank Regex Challenges](https://www.hackerrank.com/domains/regex)

---

## Quick Reference for Java Developers

### Common Validation Methods
```java
public class RegexUtils {
    
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}$");
    
    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
    
    public static boolean isStrongPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }
}
```

**Remember**: Start simple, test thoroughly, and always consider edge cases when using regex in production code!

---

*Last updated: August 2025*


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
