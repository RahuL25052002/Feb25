
# ➕ Add Two Numbers – LeetCode Problem #2

## 🧠 Problem Statement

You are given two **non-empty** linked lists representing two **non-negative integers**.  
The digits are stored in **reverse order**, and each of their nodes contains a **single digit**.  
Add the two numbers and return the **sum as a linked list**.

You may assume the two numbers **do not contain any leading zero**, except the number `0` itself.

---

## 🧾 Example

### ✅ Example 1:

Input: l1 = [2, 4, 3], l2 = [5, 6, 4]
Output: [7, 0, 8]
Explanation: 342 + 465 = 807

shell
Copy
Edit

### ✅ Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

shell
Copy
Edit

### ✅ Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

yaml
Copy
Edit

---

## 🧾 Java Implementation

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);  // Dummy head node
        ListNode curr = dummyNode;
        int carry = 0;

        ListNode t1 = l1;
        ListNode t2 = l2;

        while (t1 != null || t2 != null) {
            int sum = carry;

            if (t1 != null) {
                sum += t1.val;
            }

            if (t2 != null) {
                sum += t2.val;
            }

            ListNode newNode = new ListNode(sum % 10);
            curr.next = newNode;
            curr = curr.next;

            carry = sum / 10;

            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }

        // If carry remains after the last addition
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
```

# **📌 Logic Explanation

Dummy Node:**
We use a dummy node (-1) to simplify pointer operations and return dummy.next as the result list.

Iterate through both lists:

Add corresponding digits from l1 and l2.

Add any carry from the previous addition.

Create a new node with value = sum % 10 and link it to result list.

Update carry = sum / 10.

Handle remaining carry:

If carry is non-zero after the loop ends, append it as the final node.

Return Result:

Return dummyNode.next, which points to the head of the actual result list.

💡 Key Concepts
=
Use a dummy node to simplify linked list construction.

Always track carry during addition.

Handle different lengths of l1 and l2.

⏱️ Time & Space Complexity
Complexity	Value
Time Complexity	O(max(N, M)) – N and M are lengths of l1 and l2
Space Complexity	O(max(N, M)) – for the resulting list

✅ Final Output Example
=
Input:  l1 = [2, 4, 3], l2 = [5, 6, 4]
Steps: 
  2 + 5 = 7        → Node: 7
  4 + 6 = 10       → Node: 0, Carry: 1
  3 + 4 + 1 = 8    → Node: 8

Result: [7, 0, 8]
