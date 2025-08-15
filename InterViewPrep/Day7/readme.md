
# 268. Missing Number

## 📝 Problem Statement
Given an array `nums` containing **n** distinct numbers in the range `[0, n]`, return the **only number** in the range that is missing from the array.

---

## 📌 Examples

### Example 1
**Input:**
nums = [3, 0, 1]

**Output:**
2

**Explanation:**  
`n = 3` → numbers in range `[0, 3]` should be `{0, 1, 2, 3}`. Missing number is **2**.

---

### Example 2
**Input:**
nums = [0, 1]

**Output:**
2

**Explanation:**  
`n = 2` → numbers in range `[0, 2]` should be `{0, 1, 2}`. Missing number is **2**.

---

### Example 3
**Input:**
nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]

**Output:**
8

pgsql
Copy code
**Explanation:**  
`n = 9` → numbers in range `[0, 9]` should be `{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}`. Missing number is **8**.

---

## 🎯 Constraints
- `n == nums.length`
- `1 <= n <= 10^4`
- `0 <= nums[i] <= n`
- All numbers in `nums` are unique.

---

## 💡 Approach (Cycle Sort Method)

We can place each number at its **correct index** using **Cycle Sort**:
1. Iterate through the array.
2. If the current number is within `[0, n-1]` and **not already at the correct index**, swap it with the number at its target index.
3. Otherwise, move to the next index.
4. After sorting, the first index where `nums[i] != i` is the missing number.
5. If all positions are correct, the missing number is `n`.

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## 🔄 Flow Diagram


flowchart TD
    A[Start] --> B[Set i = 0]
    B --> C{ i < nums.length ? }
    C -- No --> G[Go to check loop]
    C -- Yes --> D[correct = nums[i]]
    D --> E{ nums[i] >= 0 AND nums[i] < nums.length AND nums[i] != nums[correct] ? }
    E -- Yes --> F[Swap nums[i] and nums[correct]]
    F --> C
    E -- No --> H[i++]
    H --> C
    G --> I[For j from 0 to nums.length - 1]
    I --> J{ nums[j] != j ? }
    J -- Yes --> K[Return j]
    J -- No --> L[Return nums.length]
    K --> M[End]
    L --> M
💻 Java Code (Cycle Sort Approach)

```
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] >= 0 && nums[i] < nums.length && nums[i] != nums[correct]) {
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return nums.length;
    }
}
```
✅ Key Insights
The Cycle Sort approach ensures O(n) time complexity without extra space.

Instead of summing or using XOR, we directly position each number at its index.

The first mismatch in index → missing number found.


