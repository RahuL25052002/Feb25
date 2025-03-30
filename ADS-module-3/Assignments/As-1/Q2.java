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

	static String longest(String s){

		
		String arr[]=s.split(" ");
		int count=0;
		String ans="";
		for(String s1:arr){
			if(s1.length()>count){
				ans=s1;
			}
		}
		return ans;

	}

	static void countVoCon(String s){

		char arr[]=s.toLowerCase().toCharArray();
		ArrayList<Character> l=new ArrayList<>();
		l.add('a');
		l.add('e');
		l.add('i');
		l.add('o');
		l.add('u');
		int vowe=0;
		int cons=0;
		for(char ch:arr){
			if(l.contains(ch)){
				vowe++;
			}else{
				if(ch!=' ')
					cons++;
			}
		}

		System.out.println("Vowels: "+vowe+", Consonants: "+cons);
	}

	public static void main(String[]args){
		String s1="listen";
		String s2="silent";
		boolean ans1=isAnagram(s1,s2);
		System.out.println(ans1);
		String s3="Practise makes a man perfect";
		String ans2=longest(s3);
		System.out.println(ans2);
		countVoCon(s3);


	}

}
