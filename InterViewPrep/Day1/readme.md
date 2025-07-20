**

# [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)


> A peak element is an element that is strictly greater than its
> neighbors. Given a **0-indexed** integer array `nums`, find a peak
> element, and return its index. If the array contains multiple peaks,
> return the index to **any of the peaks**. You may imagine that
> `nums[-1] = nums[n] = -∞`. In other words, an element is always
> considered to be strictly greater than a neighbor that is outside the
> array. You must write an algorithm that runs in `O(log n)` time.

**Example 1:**
**Input:** nums = [1,2,3,1]
**Output:** 2
**Explanation:** 3 is a peak element and your function should return the index number 2.
**Example 2:**
**Input:** nums = [1,2,1,3,5,6,4]
**Output:** 5
**Explanation:** Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
**Constraints:**
-   `1 <= nums.length <= 1000`
-   `-231 <= nums[i] <= 231 - 1`
-   `nums[i] != nums[i + 1]`  for all valid  `i


# Approach

We have to solve this question with  O(logn)  time. Let's solve this question with binary search.

First of all, let's think about a solution with a small example.

```
Input: nums = [1,2,3,1]
```

```csharp
[1,2,3,1]
 L     R
```

Calculate middle index.

```csharp
(L + R) // 2
= (0 + 3) // 2
= 1

[1,2,3,1]
 L M   R
```

In the next step, we have to move a left or a right pointer. The description says "an element is always considered to be strictly greater than a neighbor that is outside the array."

**In other words, if a number at  `middle + 1`  index is less than a number at  `middle index`, we have one of peaks on the left side of middle index, so move the right pointer to middle. Middle pointer itself may be one of peaks.**

**On the other hand,  `middle + 1`  is greater than middle, we should move left pointer to  `middle + 1`.**

##### Why + 1 for only left?

Because  `middle + 1`  is greater than  `middle`.  **That means middle is definitely not one of peaks.**  Just in case for right pointer,  `middle`  is greater than  `middle + 1`,  **that means there is a possibility that middle is one of peaks.**

That's why we move right to middle and move left to middle + 1.

In this case, move left pointer to  `middle + 1`.

```csharp
[1,2,3,1]
   M L R
```

Next, calculate a new middle index.

```csharp
(L + R) // 2
= (2 + 3) // 2
= 2

[1,2,3,1]
     L R
     M
```

In this case, middle is greater than middle + 1, so move the right pointer to middle.

```csharp
[1,2,3,1]
     L
     M
     R
```

Now the left and right pointer are the same index, so we stop.

```sql
return left(= 2)
```

##### Why we return left pointer instead of middle pointer?

Simply, there are cases where we get wrong answer if we return middle index.

Let's see this case quickly.

```
Input: nums = [1,2,1,3,5,6,4]
```

```csharp
[1,2,1,3,5,6,4]
 L     M     R

middle = (0 + 6) // 2 
= 3

# Move Left to middle + 1
= middle vs middle + 1
= 3 vs 5
--------------------------------
[1,2,1,3,5,6,4]
       M L   R

middle = (4 + 6) // 2 
= 5

[1,2,1,3,5,6,4]
         L M R

# Move Left to middle + 1
= middle vs middle + 1
= 6 vs 4
--------------------------------
[1,2,1,3,5,6,4]
         L M
           R

middle = (4 + 5) // 2 
= 4

[1,2,1,3,5,6,4]
         L R 
         M

# Move Left to middle + 1
= middle vs middle + 1
= 5 vs 6

--------------------------------
[1,2,1,3,5,6,4]
           R 
         M L
```

Now Left is the same as Right. we stop.

```kotlin
return middle (= 4)
```

That is wrong.

```sql
return left (= 5)
```

