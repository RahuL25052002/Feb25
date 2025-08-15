import java.util.*;
class ReverseWordsInString{
	
    public static String reverseWords(String s) {
        String arr[]=s.split(" +");// (" +") use for any number of the spaces thats why


        // System.out.println(arr);

        String ans="";
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==" ")
                continue;
            ans=ans+arr[i];
            if(i==0)
                continue;
            ans+=" ";
        }
        return ans.trim();
    }
  

	public static void main(String[]args){
		String s=" hello world ";
		System.out.println(reverseWords(s));
	}
}
