
# Single Number — LeetCode Problem 136

## 📜 Problem Statement
Given a **non-empty** array of integers `nums`, every element appears **twice** except for **one**. Find that single one.

You must implement a solution with:
- **Linear runtime complexity** `O(n)`
- **Constant extra space** `O(1)` (or `O(n)` if using a HashSet)

---

## 💡 Examples

### Example 1
**Input:**
nums = [2, 2, 1]


**Output:**
1

### Example 2
**Input:**
nums = [4, 1, 2, 1, 2]

**Output:**
4

### Example 3
**Input:**
nums = [1]

**Output:**
1

---

## 🔒 Constraints
- `1 <= nums.length <= 3 * 10^4`
- `-3 * 10^4 <= nums[i] <= 3 * 10^4`
- Every element appears twice except for **one element** which appears only once.

---

## 🧠 Approach

The solution uses a **HashSet** to store unique numbers and a `sum` variable to track the result:

1. **Iterate** through the array.
2. If the number is already in the set → **subtract** it from `sum` (as it’s a duplicate).
3. If the number is not in the set → **add** it to `sum` and insert it into the set.
4. At the end, `sum` will hold the single number.

---

## ⏱ Complexity Analysis
- **Time Complexity:** `O(n)` — We iterate over the array once.
- **Space Complexity:** `O(n)` — HashSet to store unique elements.

---

## 💻 Code Implementation
```java
import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                sum -= num;
            } else {
                sum += num;
                hashSet.add(num);
            }
        }
        return sum;
    }
}
🚀 Alternative Optimal Solution (Bit Manipulation)
We can solve this problem in O(n) time and O(1) space using XOR:

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR cancels out duplicates
        }
        return result;
    }
}
```

---

## Flow Diagram

```mermaid
flowchart TD
    A[Start] --> B[Initialize sum=0, hashSet={}]
    B --> C[For each num in nums[]]
    C --> D{hashSet contains num?}
    D -- Yes --> E[sum = sum - num]
    E --> F[Continue loop]
    D -- No --> G[sum = sum + num]
    G --> H[Add num to hashSet]
    H --> F[Continue loop]
    F --> I[End loop]
    I --> J[Return sum]
    J --> K[End]
