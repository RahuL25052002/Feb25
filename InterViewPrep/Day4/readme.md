
# 🧮 Maximum Subarray Sum – Brute-force Approach (Java)

This project solves the **Maximum Subarray Sum** problem using a **brute-force** technique implemented in Java.

---

## 🧠 Problem Statement

> Given an integer array `arr`, find the **contiguous subarray** (containing at least one element) which has the **largest sum**, and return its sum.

This is a classic problem also known as the **Maximum Subarray Problem** (Kadane's Problem).

---

## 🧾 Java Implementation

```java
class Solution {
    public int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
```
## 🧩 Explanation – Step-by-Step

1.  **Outer loop (`i`)**:
    
    -   Represents the **starting index** of the subarray.
        
2.  **Inner loop (`j`)**:
    
    -   Represents the **ending index** of the subarray (starting from `i`).
        
    -   Adds `arr[j]` to `sum` to calculate the **subarray sum from index `i` to `j`**.
        
3.  **Comparison**:
    
    -   After each addition, check if the current `sum` is **greater than or equal to** the current `max`.
        
    -   If yes, update `max`.
        
4.  **Return value**:
    
    -   After iterating through all possible subarrays, return the **maximum sum** found.
        

----------

## 🧪 Example

java

CopyEdit

`Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6 Explanation:
The maximum sum subarray is: [4, -1, 2, 1]
Sum = 4 + (-1) + 2 + 1 = 6` 

----------

## ⏱️ Time & Space Complexity

Approach

Time Complexity

Space Complexity

Brute-force

O(n²)

O(1)

-   Since it checks all subarrays (n*(n+1)/2), the time grows quadratically.
    
-   Space usage is constant because no extra array or structure is used.
    

----------

## 📌 Notes

-   This is not the optimal solution. For a better time complexity of **O(n)**, check out [Kadane’s Algorithm](https://youtu.be/AHZpyENo7k4).
    
-   The brute-force approach is still useful for **learning and understanding** how subarrays work.


## ✅ Java Code

java

CopyEdit

`class  Solution { public  int  maxSubArray(int[] arr) { int  max  = Integer.MIN_VALUE; int  sum  =  0; for (int  i  =  0; i < arr.length; i++) {
            sum += arr[i]; if (sum > max) {
                max = sum;
            } if (sum < 0)
                sum = 0;
        } return max;
    }
}` 

----------

## 🧠 Explanation — Step-by-Step (Kadane’s Algorithm)

### 👇 Objective:

Find the **maximum sum** of a contiguous subarray from a given integer array.

----------

### 🔄 How the code works:

1.  **Initialization**:
    
    java
    
    CopyEdit
    
    `int  max  = Integer.MIN_VALUE; // Start with smallest possible integer value  int  sum  =  0; // To keep running sum` 
    
2.  **Loop through the array**:
    
    -   Add each element to `sum`.
        
    -   If `sum > max`, update `max`.
        
    -   If `sum < 0`, reset `sum = 0` (because negative sum will not help future subarrays).
        
    
    java
    
    CopyEdit
    
    `sum += arr[i]; if (sum > max) max = sum; if (sum < 0) sum = 0;` 
    
3.  **Return the maximum subarray sum** after the loop ends.
    



### 🔍 Example Trace:

**Input**: `arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`
### 🔍 Dry Run Example

**Input**: `arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`

| i  | arr[i] | sum  | max  | Action                         |
|----|--------|------|------|--------------------------------|
| 0  | -2     | -2   | -2   | sum < 0 → reset sum = 0        |
| 1  | 1      | 1    | 1    | sum > max → update max = 1     |
| 2  | -3     | -2   | 1    | sum < 0 → reset sum = 0        |
| 3  | 4      | 4    | 4    | sum > max → update max = 4     |
| 4  | -1     | 3    | 4    | —                              |
| 5  | 2      | 5    | 5    | update max = 5                 |
| 6  | 1      | 6    | 6    | update max = 6                 |
| 7  | -5     | 1    | 6    | —                              |
| 8  | 4      | 5    | 6    | —                              |

**Output**: `6`

**Subarray**: `[4, -1, 2, 1]` has the **max sum = 6**


----------

## 📈 Time & Space Complexity

Aspect

Value

**Time Complexity**

O(n)

**Space Complexity**

O(1)

-   Only one pass through the array.
    
-   No extra space used.
    

----------

## 🔍 Why reset `sum = 0` when it becomes negative?

Because a **negative running sum** will always reduce the total sum of any upcoming subarray.  
So it's **better to start fresh** from the next index.

----------

## 🧾 Summary

-   This is **Kadane’s Algorithm**, the most efficient approach to solve this problem.
    
-   It’s used in many interview questions and coding contests.
    
-   Optimal, clean, and works with both positive and negative numbers.
    
