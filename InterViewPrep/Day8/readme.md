# 📄 Longest Consecutive Sequence (LeetCode 128)

### 📝 Problem Statement

Given an **unsorted array** of integers `nums`, return the length of the **longest consecutive elements sequence**.

⚡️ You must write an algorithm that runs in **O(n)** time.

----------

### 📌 Examples

#### **Example 1**

`Input: nums = [100,4,200,1,3,2] Output:  4  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is  4.` 

#### **Example 2**

`Input: nums = [0,3,7,2,5,8,4,6,0,1] Output:  9  Explanation: The longest consecutive elements sequence is [0,1,2,3,4,5,6,7,8].` 

#### **Example 3**

`Input: nums = [1,0,1,2] Output:  3  Explanation: The longest consecutive elements sequence is [0,1,2].` 

----------

### 🔍 Constraints

-   `0 <= nums.length <= 10^5`
    
-   `-10^9 <= nums[i] <= 10^9`
    

----------

## 🚀 Approach (Your Sorting Method)

1.  **Edge Case:** If array length is `0`, return `0`.
    
2.  **Sort the array** → so consecutive numbers appear next to each other.
    
3.  Initialize:
    
    -   `count = 1` → to track the current consecutive streak.
        
    -   `max = 1` → to track the maximum streak so far.
        
4.  Traverse from index `1` to `n-1`:
    
    -   If `nums[i] == nums[i-1]` → skip duplicates.
        
    -   If `nums[i] == nums[i-1] + 1` → numbers are consecutive → increment `count`.
        
    -   Otherwise → reset `count = 1`.
        
    -   Update `max = Math.max(max, count)`.
        
5.  Return `max`.
    

----------

## 📜 Code

`import java.util.*; class  Solution { public  int  longestConsecutive(int[] nums) { if (nums.length == 0) { return  0;
        }

        Arrays.sort(nums); // Step 1: Sort the array  int  count  =  1; int  max  =  1; for (int  i  =  1; i < nums.length; i++) { if (nums[i] == nums[i - 1]) { continue; // skip duplicates } if (nums[i] == nums[i - 1] + 1) {
                count++; // consecutive number found } else {
                count = 1; // reset if not consecutive }

            max = Math.max(max, count); // update max } return max;
    }
}` 

----------

## 🎬 Dry Run (Step-by-Step Flow)

### Example:



### Example 1 – `nums = [100, 4, 200, 1, 3, 2]`

`After sorting → [1, 2, 3, 4, 100, 200]

| i | nums[i-1] | nums[i] | Action                     | count | max |
|---|-----------|---------|----------------------------|-------|-----|
| 1 | 1         | 2       | Consecutive → count++      | 2     | 2   |
| 2 | 2         | 3       | Consecutive → count++      | 3     | 3   |
| 3 | 3         | 4       | Consecutive → count++      | 4     | 4   |
| 4 | 4         | 100     | Break → reset count = 1    | 1     | 4   |
| 5 | 100       | 200     | Break → reset count = 1    | 1     | 4   |

✅ **Final max = 4**` 

----------

### Example 2 – `nums = [0,3,7,2,5,8,4,6,0,1]`

`After sorting → [0,0,1,2,3,4,5,6,7,8]

| i | nums[i-1] | nums[i] | Action                     | count | max |
|---|-----------|---------|----------------------------|-------|-----|
| 1 | 0         | 0       | Duplicate → continue       | 1     | 1   |
| 2 | 0         | 1       | Consecutive → count++      | 2     | 2   |
| 3 | 1         | 2       | Consecutive → count++      | 3     | 3   |
| 4 | 2         | 3       | Consecutive → count++      | 4     | 4   |
| 5 | 3         | 4       | Consecutive → count++      | 5     | 5   |
| 6 | 4         | 5       | Consecutive → count++      | 6     | 6   |
| 7 | 5         | 6       | Consecutive → count++      | 7     | 7   |
| 8 | 6         | 7       | Consecutive → count++      | 8     | 8   |
| 9 | 7         | 8       | Consecutive → count++      | 9     | 9   |

✅ **Final max = 9**`
----------

## 📊 Complexity Analysis

-   **Sorting:** `O(n log n)`
    
-   **Traversal:** `O(n)`
    
-   **Total:** `O(n log n)`
    
-   **Space:** `O(1)` (in-place sorting)
    

----------

⚡ **Note:** The problem asks for an `O(n)` solution → this sorting approach is valid and accepted but not optimal.  
The **optimal way** is to use a **HashSet** to check consecutive sequences directly in linear time.
