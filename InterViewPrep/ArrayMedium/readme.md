
# Array Concepts: Ceil, Floor, Peak, and Pivot

This document explains four important array concepts often asked in coding interviews: **Ceil, Floor, Peak Index, and Pivot**.

----------

## 🔹 1. Ceil in Array

**Definition**: The **smallest element in the array that is greater than or equal to the target**.

### Example

`arr = {2, 4, 6, 8}, target = 5 ceil = 6` 

### Algorithm (Binary Search)

1.  If target > last element → no ceil.
    
2.  Use binary search:
    
    -   If `arr[mid] == target` → return mid.
        
    -   If `arr[mid] < target` → search right.
        
    -   If `arr[mid] > target` → store as possible ceil, search left.
        

----------

## 🔹 2. Floor in Array

**Definition**: The **largest element in the array that is smaller than or equal to the target**.

### Example

`arr = {2, 4, 6, 8}, target = 5 floor = 4` 

### Opposite of Ceil

-   Ceil → nearest higher
    
-   Floor → nearest lower
    

----------

## 🔹 3. Peak Index

**Definition**: A peak element is one that is **greater than or equal to its neighbors**.

### Example

`arr = {1, 3, 20, 4, 1}  
peak = 20 (index 2)` 

### Special Case: Mountain Array

In a mountain array (increasing then decreasing), the **peak index** is the **highest point**.

`arr = {1, 3, 5, 7, 6, 4, 2}  
peak = 7 (index 3)` 

### Algorithm (Binary Search)

-   If `arr[mid] < arr[mid+1]` → peak on right.
    
-   Else → peak on left or at mid.
    

----------

## 🔹 4. Pivot Element

The meaning of **pivot** depends on the problem:

### (a) Pivot in Rotated Sorted Array

-   Pivot = **smallest element** (point of rotation).
    

`arr = {4, 5, 6, 7, 0, 1, 2}  
pivot = 0 (index 4)` 

### (b) Pivot Index Problem

-   Pivot index = index where **left sum = right sum**.
    

`arr = {1, 7, 3, 6, 5, 6} pivot  index  =  3 (value 6)` 

### (c) Pivot in Binary Search

-   Pivot often means the **mid element used for splitting**.
    

----------

## 🔹 Comparison Table

Concept

Definition

Example

Result

**Ceil**

Smallest element ≥ target

`{2,4,6,8}`, target=5

6

**Floor**

Largest element ≤ target

`{2,4,6,8}`, target=5

4

**Peak**

Greater than or equal to neighbors

`{1,3,20,4}`

20

**Pivot**

Rotation point OR balance index

`{4,5,6,7,0,1,2}` → pivot=0  
`{1,7,3,6,5,6}` → pivot index=3

Varies

----------

## 🔹 Why Important?

-   **Ceil/Floor** → Binary search problems, range queries.
    
-   **Peak Index** → Mountain array problems.
    
-   **Pivot** → Rotated sorted array search, equilibrium index problems.
