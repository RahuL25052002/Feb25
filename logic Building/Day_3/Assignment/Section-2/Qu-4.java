//Snippet 4:
class DoWhileLoop {
	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.print(i + " ");
			i++;
		} while (i < 5);
		System.out.println(i);
	}
}
// Guess the output of this do-while loop.

/*

Dry Run:
	int i=1
		do block 
			-- print i means 1 then i++  ie. i=2;
		while(i<5)  ie. 2<5 ie. true
		do block 
			-- print i means 2 then i++  ie. i=3;
		while(i<5)  ie. 3<5 ie. true
		do block 
			-- print i means 3 then i++  ie. i=4;
		while(i<5)  ie. 4<5 ie. true
		do block 
			-- print i means 4 then i++  ie. i=5;
		while(i<5)  ie. 5<5 ie. false
				then terminate loop
		and print i means i=5

	o/p: 1 2 3 4 5

*/
	
				