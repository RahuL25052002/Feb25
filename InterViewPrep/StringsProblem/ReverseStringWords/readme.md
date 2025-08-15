
## 📄 Reverse Words in a String (LeetCode 151)

### 📝 Problem Statement

Given an input string `s`, **reverse the order of words**.

-   A word is defined as a sequence of **non-space characters**.
    
-   Words in `s` are separated by at least one space.
    
-   The output should:
    
    -   Contain only a single space between words.
        
    -   Not have leading or trailing spaces.
        

----------

### 📌 Example

#### **Example 1**

`Input: s = "the sky is blue"  Output:  "blue is sky the"` 

#### **Example 2**

`Input: s = "  hello world  "  Output:  "world hello"` 

💡 **Note:** Leading and trailing spaces are removed in the result.

#### **Example 3**

`Input: s = "a good   example"  Output:  "example good a"` 

💡 Multiple spaces between words are reduced to a **single space**.

----------

### 🔍 Constraints

-   `1 <= s.length <= 10^4`
    
-   `s` contains English letters (upper & lowercase), digits, and spaces `' '`.
    
-   There is at least one word in `s`.
    

----------

## 🚀 Approach

We can solve this problem in **three main steps**:

1.  **Split** the string into words (ignore extra spaces).
    
2.  **Reverse** the order of words.
    
3.  **Join** them with a single space.
    

----------

### 🛠 Algorithm (Step-by-Step)

#### Input:

`"  hello   world  "` 

#### Step 1: Split words

We use:

`s.split(" +")` 

This splits the string by **one or more spaces** into an array:

`["hello", "world"]` 

#### Step 2: Reverse order

`["world", "hello"]` 

#### Step 3: Join with single space

`"world hello"` 

----------

### 📜 Code

```
`class  Solution {
 public String reverseWords(String s) { 
 // Step 1: Split by one or more spaces 
	 String arr[] = s.split(" +"); 
 // Step 2: Reverse and build the result  
	 String  ans  =  ""; 
	 for (int  i  = arr.length - 1; i >= 0; i--) {
            ans += arr[i];
            if (i != 0) ans += " ";
        }
         // Step 3: Trim just in case  
         return ans.trim();
    }
}` 
```

----------

### 🔄 Dry Run (Interactive Flow)

#### Example:

`Input: "  the   sky  is  blue  "` 

Step

Action

Result

1

Split by spaces

["the", "sky", "is", "blue"]

2

Reverse array

["blue", "is", "sky", "the"]

3

Join with spaces

"blue is sky the"

4

Return result

✅ "blue is sky the"

----------

### 📊 Complexity Analysis

-   **Time Complexity:** `O(n)`
    
    -   Splitting & joining each take linear time.
        
-   **Space Complexity:** `O(n)`
    
    -   We store the split words in an array.
        

🎬 Example Input:
"  the   sky  is  blue  "

Step 1: Remove extra spaces & split
["the", "sky", "is", "blue"]

Step 2: Sliding reversal process
Original:  the   sky   is   blue
             ↑
             └── Start from last word

Step 1: blue
Step 2: blue is
Step 3: blue is sky
Step 4: blue is sky the

ASCII Movement Animation
the   sky   is   blue
                  ↑
blue
the   sky   is   blue
            ↑
blue is
the   sky   is   blue
      ↑
blue is sky
the   sky   is   blue
↑
blue is sky the


✅ Final Output:

"blue is sky the"

</details>
📊 Complexity

Time Complexity: O(n) — split & join each take linear time.

Space Complexity: O(n) — array to store split words.
----------

### 🎯 Follow-Up (O(1) Space)

If strings were **mutable** in Java, we could:

-   Reverse the entire string.
    
-   Reverse each word individually.
    
-   Remove extra spaces in-place.
    

----------

### 📌 Key Takeaways

-   `" +”` in `split()` handles **multiple spaces**.
    
-   `trim()` removes unwanted leading/trailing spaces.
    
-   Efficient solution in **O(n)** time.
