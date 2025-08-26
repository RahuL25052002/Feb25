
### Check if a String is Subsequence of Other

Difficulty:  **Easy**Accuracy:  **51.68%**Submissions:  **25K+**Points:  **2**

Given two strings  **s1**  and  **s2**. You have to check that  **s1**  is a subsequence of  **s2** or not.  
**Note:**  A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.

**Examples:**

**Input:** s1 = "AXY", s2 = "YADXCP"
**Output:** false
**Explanation:** s1 is not a subsequence of s2 as 'Y' appears before 'A'.

**Input:** s1 = "gksrek", s2 = "geeksforgeeks"
**Output:** true
**Explanation:** If we combine the bold character of "**g**ee**ks**fo**r**g**e**e**k**s", it equals to s1. So s1 is a subsequence of s2. 

**Constraints:**  
1 ≤ s1.size(), s2.size() ≤ 106
```
class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        if(s1.length()>s2.length())
            return false;
        int j=0;
        for(int i=0;i<s2.length();i++){
            if(j<s1.length() && s1.charAt(j)==s2.charAt(i)){
                j++;
            }
        }
        if(j==s1.length())
            return true;
        else
            return false;
    }
};
```

