
//Snippet 1:
class NestedLoopOutput {
	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
	}
}
// Guess the output of this nested loop.

/* 
Dry run
--->   int i=1;   i<=3 ie. true 
	-------->it goes to ineer loop
			int j=1; j<=2 means 1<=2 ie. true  print SOPLine 1 1  then j++
		            j=2;            2<=2 ie. true  printsopLine  1 2  then j++
			    j=3;            3<=2 ie. false  terminate loop
		it goes to next line beacuse there Sop line is present
	
	then i++

	i=2;   2<=3 ie. true 
	-------->it goes to ineer loop
			int j=1; j<=2 means 1<=2 ie. true  print SOPLine 2 1  then j++
		            j=2;            2<=2 ie. true  printsopLine  2 2  then j++
			    j=3;            3<=2 ie. false  terminate loop
		it goes to next line beacuse there Sop line is present
	then i++;

	i=3;   3<=3 ie. true 
	-------->it goes to ineer loop
			int j=1; j<=2 means 1<=2 ie. true  print SOPLine 3 1  then j++
		            j=2;            2<=2 ie. true  printsopLine  3 2  then j++
			    j=3;            3<=2 ie. false  terminate loop
		it goes to next line beacuse there Sop line is present
	i=4; 4<=3 ie. false it get terminate the loop


	means o/p will be
	1 1 1 2
	2 1 2 2
	3 1 3 2

*/
				