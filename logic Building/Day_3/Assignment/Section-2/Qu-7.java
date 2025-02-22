//Snippet 7:
class NestedIncrement {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		int result = ++a * b-- - --a + b++;
		System.out.println(result);
	}
}
// Guess the output of this code snippet.
/*

Dry Run:-
	int a=10;
	int b=5;
	int result=++a * b-- - --a + b++;
            result=11*5 - 10+4;
	    result=49;
	print 49
	o/p: 49
*/