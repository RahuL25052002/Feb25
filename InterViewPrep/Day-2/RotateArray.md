# LeetCode 189. Rotate Array

**Difficulty**: Medium  
**Tags**: Array, Two Pointers, In-place, Reversal, Simulation

---

## 🧾 Problem Statement

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

### ✨ Examples:

#### Example 1:






---

## ✅ Constraints

- 1 <= nums.length <= 10⁵
- -2³¹ <= nums[i] <= 2³¹ - 1
- 0 <= k <= 10⁵

---

## 🧠 Follow-Up

> Can you solve it in-place with O(1) extra space?
> Can you come up with **at least 3 different solutions**?

---

## ✅ Optimal Solution (In-place Reversal Method)

### 🔄 Approach:

To rotate the array `k` steps to the right:
1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n - k` elements.

### ⏱ Time Complexity:
- `O(n)`, where `n` is the length of the array

### 🧠 Space Complexity:
- `O(1)`, in-place operation

---

### ✅ Java Code:

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // In case k > n

        reverse(nums, 0, n - 1);     // Step 1
        reverse(nums, 0, k - 1);     // Step 2
        reverse(nums, k, n - 1);     // Step 3
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

