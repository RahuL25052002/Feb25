//Snippet 8:
class LoopIncrement {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count += i++ - ++i;	
		}	
		System.out.println(count);
	}
}
// Guess the output of this code snippet.

/*

Dry run:-
	int count=0
	for loop
	  int i=0  0<4 ie. true  
		count=count+ i++ - ++i
			0  + 0  - 2  ie. count =-2;then i++
	      i=2  2<4 ie. true  
		count=count+ i++ - ++i
			-2  + 2  - 4  ie. count =-4;then i++;
	      i=5  5<4 ie. false 
		then loop end
		print count ie. -4

o/p: -4

*/