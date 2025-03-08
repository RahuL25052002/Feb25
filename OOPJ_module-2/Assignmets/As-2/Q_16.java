/*
Q16: Write a program that determines whether a given number is positive, negative, or
zero using only the ternay operator
 */
class PosNegZero{
	public static void main(String[]args){
		int num=3;
		System.out.println((num>0)?num+" is positive":(num<0)?num+" is Negative":num+ " is Zero");
	}

}
