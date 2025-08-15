class Palindrome{
	
	public static boolean palindromeString(String s){
		int left=0;
		int right=s.length()-1;

		while(left<right){
			if(s.charAt(left)==s.charAt(right)){
				left++;
				right--;
			}else{
				return false;
			}
		}
		return true;
	}

	public static boolean palindromeString2(String s){
               
		String rev="";
		for(int i=s.length()-1;i>=0;i--){
			rev=rev+s.charAt(i);
		}
	
		System.out.println(s.hashCode());
		System.out.println(rev.hashCode());
		System.out.println(s==rev);
		if(rev.equals(s)){
			return true;
		}else{
			return false;
		}
        }
	public static void main(String[]args){
		String s="level";
		boolean ans=palindromeString2(s);
		if(ans){
			System.out.println(s+" is palidrome String!");
		}else{
			System.out.println(s+" is not palidrome String!");
		}
	}
}
/*
 * 1️⃣ String Constant Pool Basics

A String literal like "level" is stored in the String Constant Pool (SCP).

Any time you write the same literal again in your code, Java reuses the SCP reference.

But newly created strings at runtime via operations (like concatenation) are not automatically placed into the SCP — they live in the heap unless explicitly interned.

2️⃣ Your Case: rev Creation

You built rev like this:

String rev = "";
for (int i = s.length() - 1; i >= 0; i--) {
    rev = rev + s.charAt(i);
}


rev = rev + s.charAt(i) creates a new String object in heap memory on every loop iteration (because String is immutable).

At the end, the final rev object is in the heap, not the SCP.

Even though rev contains "level", it’s not the same reference as the "level" literal in the SCP.

3️⃣ Why == is false

s → points to "level" in the SCP.

rev → points to a different object in the heap with the same characters.

== compares memory addresses → returns false.

4️⃣ If You Want It in the SCP

You can force it into the SCP by:

rev = rev.intern();


Then:

rev will point to the SCP "level".

(s == rev) will return true.

💡 Key takeaway:
Your rev string content is "level", but it’s a heap object, not SCP.
The SCP will only hold it if it’s a literal in source code or if you explicitly call .intern().
 */
