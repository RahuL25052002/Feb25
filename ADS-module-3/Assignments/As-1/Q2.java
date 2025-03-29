/*
 *Problem 2:
Write a program that performs the following operations on strings:
1. Check whether two given strings are anagrams of each other.
2. Identify the longest word in a given sentence.
3. Count the number of vowels and consonants in the same sentence.
Input:
String 1: listen
String 2: silent
Sentence: Practice makes a man perfect
Output:
Are 'listen' and 'silent' anagrams? true
Longest word: Practice
Vowels: 9, Consonants: 17
 */
import java.util.*;


class Q2{

	static boolean isAnagram(String s1,String s2){
		
		char ar1[]=s1.toCharArray();
		char ar2[]=s2.toCharArray();

		for(int i=0;i<ar1.length;i++){
			int count=0;
			for(int j=0;j<ar2.length;j++){

				if(ar1[i]==ar2[j]){
					count++;
				}
			}
			if(count==0){
				return false;
			}
		}
		return true;

	}

	public static void main(String[]args){
		String s1="listen";
		String s2="silent";
		boolean ans=isAnagram(s1,s2);
		System.out.println(ans);

	}

}
