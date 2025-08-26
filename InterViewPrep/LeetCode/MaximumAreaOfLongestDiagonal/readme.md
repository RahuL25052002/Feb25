# 📐 Maximum Area of Longest Diagonal Rectangle

[![LeetCode](https://img.shields.io/badge/LeetCode-3000-orange.svg)](https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green.svg)]()
[![Java](https://img.shields.io/badge/Language-Java-blue.svg)]()

## 🎯 Problem Statement

Given a 2D array of rectangle dimensions, find the rectangle with the **longest diagonal**. If multiple rectangles have the same longest diagonal, return the one with the **maximum area**.

### 📊 Examples

**Example 1:**
```
Input: dimensions = [[9,3],[8,6]]
Output: 48
```

**Example 2:**
```
Input: dimensions = [[3,4],[4,3]]
Output: 12
```

### ⚡ Constraints
- `1 <= dimensions.length <= 100`
- `dimensions[i].length == 2`
- `1 <= dimensions[i][0], dimensions[i][1] <= 100`

---

## 💡 Solution Approach

The solution uses a **single-pass iteration** strategy:

1. **Track Maximum Diagonal**: Keep track of the maximum diagonal length found so far
2. **Compare Diagonals**: For each rectangle, compare its diagonal with the current maximum
3. **Handle Ties**: When diagonals are equal, choose the rectangle with larger area

### 🔑 Key Insights
- Instead of calculating `sqrt(length² + width²)`, we compare `length² + width²` directly
- This avoids floating-point calculations and improves performance
- We only need to track the maximum diagonal square and corresponding area

---

## 🔍 Algorithm Walkthrough

Let's trace through **Example 1**: `dimensions = [[9,3],[8,6]]`

### Initial State
```
square = Integer.MIN_VALUE  // Maximum diagonal square found
area = 0                    // Area of rectangle with max diagonal
```

### Iteration 1: Rectangle [9,3]
```
Current rectangle: [9,3]
maxSquare = 9² + 3² = 81 + 9 = 90
area = 9 × 3 = 27

Since 90 > Integer.MIN_VALUE:
✓ Update: square = 90, area = 27
```

### Iteration 2: Rectangle [8,6]
```
Current rectangle: [8,6]
maxSquare = 8² + 6² = 64 + 36 = 100
currentArea = 8 × 6 = 48

Since 100 > 90:
✓ Update: square = 100, area = 48
```

### Final Result
```
Return area = 48 ✅
```

The rectangle [8,6] has a longer diagonal (√100 = 10) compared to [9,3] (√90 ≈ 9.487), so we return its area.

---

## 💻 Code Implementation

```java
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int square = Integer.MIN_VALUE;
        int area = 0;
        
        for(int i = 0; i < dimensions.length; i++) {
            int maxSquare = dimensions[i][0] * dimensions[i][0] + 
                           dimensions[i][1] * dimensions[i][1];
            
            if(maxSquare > square) {
                // Found a rectangle with longer diagonal
                square = maxSquare;
                area = dimensions[i][0] * dimensions[i][1];
            } else if(maxSquare == square) {
                // Same diagonal length, check for maximum area
                int check = dimensions[i][0] * dimensions[i][1];
                if(check > area) {
                    area = check;
                }
            }
        }
        
        return area;
    }
}
```

---

## ⏰ Complexity Analysis

### Time Complexity: **O(n)**
- **Single Pass**: We iterate through the array exactly once
- **Constant Operations**: Each iteration performs constant-time arithmetic operations
- **No Nested Loops**: Linear traversal without additional loops

### Space Complexity: **O(1)**
- **Fixed Variables**: Only using `square`, `area`, `maxSquare`, and `check` variables
- **No Extra Data Structures**: No additional arrays, lists, or recursive call stack
- **In-place Processing**: Algorithm works with the given input without extra space

---

## 🎨 Visual Representation

```
Rectangle [9,3]:     Rectangle [8,6]:
┌─────────┐         ┌────────┐
│         │         │        │
│    27   │         │   48   │
│         │         │        │
└─────────┘         │        │
Diagonal ≈ 9.487    │        │
                    └────────┘
                    Diagonal = 10 ✓
```

---

## 🧪 Test Cases

```java
// Test Case 1: Different diagonals
dimensions = [[9,3],[8,6]]
Expected: 48

// Test Case 2: Same diagonals, different areas  
dimensions = [[3,4],[4,3]]
Expected: 12

// Test Case 3: Single rectangle
dimensions = [[5,12]]
Expected: 60
```

---

## 📚 Related Topics
- **Arrays**: 2D array traversal
- **Mathematics**: Pythagorean theorem
- **Optimization**: Finding maximum with constraints

---

*Happy Coding! 🚀*
