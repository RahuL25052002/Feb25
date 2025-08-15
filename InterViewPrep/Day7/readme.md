
# First Missing Positive

## Problem Description
Given an unsorted integer array `nums`, return the smallest positive integer that is **not present** in the array.

You must implement an algorithm that:
- Runs in **O(n)** time
- Uses **O(1)** auxiliary space

---

## Examples

### Example 1:
**Input:**
nums = [1, 2, 0]


**Output:**
3

**Explanation:**  
The numbers in the range `[1, 2]` are all present in the array, so the next smallest positive integer is `3`.

---

### Example 2:
**Input:**
nums = [3, 4, -1, 1]

**Output:**
2

**Explanation:**  
The number `1` exists in the array, but `2` is missing.

---

### Example 3:
**Input:**
nums = [7, 8, 9, 11, 12]

**Output:**
1

**Explanation:**  
The smallest positive integer `1` is missing.

---

## Constraints
- `1 <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Approach

This problem can be solved using the **Cyclic Sort** technique:

1. Iterate through the array.
2. If the current number is in the range `[1, n]` (where `n` is the array length) and is not in its correct position, swap it to its correct position.
3. Once all numbers are placed correctly, iterate again to find the first index where `nums[i] != i + 1`.  
   That index + 1 is the missing positive number.
4. If all positions are correct, return `n + 1`.

**Time Complexity:** `O(n)`  
**Space Complexity:** `O(1)`

---

## Java Solution
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }
        return nums.length + 1;
    }
}
```

## How It Works

Swap logic: Places each positive integer x in the position x - 1 if possible.

Final scan: Finds the first missing positive integer by checking mismatched indices.


---

# First Missing Positive

## Problem Statement

Given an **unsorted** integer array `nums`, return the **smallest positive integer** that is **not present** in the array.

You must implement an algorithm that runs in **O(n)** time and uses **O(1)** extra space.

---

### Examples

**Example 1:**
Input: nums = [1, 2, 0]
Output: 3
Explanation: Numbers 1 and 2 are present, so the smallest missing positive is 3.


**Example 2:**
Input: nums = [3, 4, -1, 1]
Output: 2
Explanation: 1 is present, but 2 is missing.

markdown
Copy
Edit

**Example 3:**
Input: nums = [7, 8, 9, 11, 12]
Output: 1
Explanation: 1 is missing, so it is the answer.


---

## Constraints
- `1 <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Approach

The problem can be solved using **index mapping**:
1. Ignore all non-positive numbers and numbers greater than `n` (array length) since they can't be the smallest missing positive.
2. Place each number `x` (where `1 <= x <= n`) at index `x-1`.
3. After rearrangement, iterate through the array:
   - The first index `i` where `nums[i] != i+1` means `i+1` is the missing number.
4. If all indices are correct, the answer is `n+1`.

---

## Algorithm Flow

pgsql
Copy
Edit
        ┌─────────────────────────────┐
        │    Input unsorted array      │
        └──────────────┬──────────────┘
                       ▼
      ┌──────────────────────────────────┐
      │ For each index i:                 │
      │   While nums[i] in [1, n]         │
      │   and nums[i] != nums[nums[i]-1]  │
      │       Swap nums[i] with nums[x-1] │
      └───────────────────┬──────────────┘
                          ▼
         ┌─────────────────────────────────┐
         │ Iterate from i = 0 to n-1:       │
         │   If nums[i] != i+1              │
         │       Return i+1                 │
         └──────────────────┬──────────────┘
                            ▼
           ┌────────────────────────────────┐
           │ If no mismatch found: return n+1│
           └────────────────────────────────┘

---

## Example Walkthrough

**Example:**
nums = [3, 4, -1, 1]
n = 4
Step 1: Rearrange so that nums[i] = i+1
[1, -1, 3, 4] → [1, 3, -1, 4] → [1, -1, 3, 4]
Step 2: First mismatch is at index 1 → Missing number = 2

---

## Time & Space Complexity
- **Time Complexity:** O(n) (each number is swapped at most once)
- **Space Complexity:** O(1) (in-place rearrangement)
