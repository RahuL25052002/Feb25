//Snippet 6:
class IncrementDecrement {
	public static void main(String[] args) {
		int x = 5;
		int y = ++x - x-- + --x + x++;
		System.out.println(y);
	
	}
}

// Guess the output of this code snippet.
/*
Dry run:
	int x=5;
	int y=++x - x-- + --x + x++
	    y=	6 - 6  +  4 + 4  ie. y=8
	now x=5
	print(y) means y=8;

o/p:-- > 8

*/