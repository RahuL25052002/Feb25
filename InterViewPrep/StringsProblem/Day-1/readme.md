
# 28. Find the Index of the First Occurrence in a String

## 📜 Problem Statement

Given two strings `needle` and `haystack`, return **the index of the first occurrence** of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

----------

## 💡 Examples

**Example 1**

`Input: haystack = "sadbutsad", needle = "sad"  Output:  0  Explanation:  "sad" occurs at index 0  and index 6.
The first occurrence is at index 0 → return  0.` 

**Example 2**

`Input: haystack = "leetcode", needle = "leeto"  Output: -1  Explanation:  "leeto" does not occur in  "leetcode" → return -1.` 

----------

## 📏 Constraints

-   `1 <= haystack.length, needle.length <= 10^4`
    
-   `haystack` and `needle` consist of lowercase English characters only.
    

----------

## 🚀 Approach 1 — Manual Matching with Loop

### **Idea**

1.  If `needle` is longer than `haystack`, return `-1` immediately.
    
2.  Slide over `haystack` from index `0` to `haystack.length() - needle.length()`.
    
3.  At each position `i`:
    
    -   If `haystack.charAt(i)` matches `needle.charAt(0)`,  
        check the substring of length `needle.length()` starting from `i`.
        
    -   If it matches `needle`, return `i`.
        
4.  If no match is found, return `-1`.
    

----------

## 🔄 Flow of the Program

`Start
 ↓ Is haystack length < needle length?
 → Yes → return -1 ↓ For i from  0  to haystack.length - needle.length
   ↓ If haystack[i] == needle[0]
       ↓ Compare substring haystack[i : i+needle.length] with needle
       ↓ If equal → return i End  Loop ↓ Return -1` 

----------

## 🖥 Code Implementation (Approach 1 — Manual Search)
```
`class  Solution { 
	public  int  strStr(String haystack, String needle) { 	
		if(haystack.length() < needle.length()) {
			 return -1;
        } 
	    for(int  i  =  0; i <= haystack.length() - needle.length(); i++) { 
		    if(haystack.charAt(i) == needle.charAt(0)) { 
			    if(haystack.substring(i, i + needle.length()).equals(needle)) { return i;
                }
            }
        } return -1;
    }
}` 
```
----------

## 🛠 Approach 2 — Using Built-in Methods

Java provides:

-   `haystack.contains(needle)` → checks if present
    
-   `haystack.indexOf(needle)` → returns first index or `-1`
    
```
`class  Solution {
 public  int  strStr(String haystack, String needle) {
	  int  index  = -1;
	  if (haystack.contains(needle)) {
            index = haystack.indexOf(needle);
      } 
      return index;
    }
}` 
```

----------

## 📊 Dry Run Example

**Input:**

`haystack = "sadbutsad"  needle = "sad"` 

Step

i

haystack.charAt(i)

Substring Checked

Match?

Action

1

0

's'

"sad" (0–2)

✅ Yes

return 0

End

Answer = 0

**Output:** `0`

----------

## ⏳ Time & Space Complexity

-   **Time Complexity:** O((n-m+1) * m) in worst case (n = haystack length, m = needle length)
    
-   **Space Complexity:** O(1) (no extra data structure used)
