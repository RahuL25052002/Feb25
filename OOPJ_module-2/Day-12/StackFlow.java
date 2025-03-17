/*import java.io.*;
class StackFlow{
	
	public static void main(String[] args) throws Exception {

    		String line = null;
    		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    		try {
        		// This is protected code. If an problem occurs here, catch block is triggered 
        		while ( (line = br.readLine()) != null ){
            			System.out.println(line);
        		}
    		}
    		catch (IOException e){
        		throw new IOException("Problem reading a line",e);
    		}
	}

}
*/
import java.io.*;
import java.util.*;

class ReadLineTest {
 public static void main(String[] args)throws IOException {
  String s;
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  // WHY IOException here?
  /*  14

The basic idea is that a BufferedReader delegates to a different kind of Reader, so it is passing on that exception.

That different kind of Reader can read from some kind of volatile external resource, say a file system in the case of FileReader. A file system read can fail for many reasons at any time. (The situation is worse if the Reader is getting its underlying data from a Network Stream). The file could get deleted out from under you (depending on the file system and OS involved).

Because you cannot predict what will happen with code, you get a checked exception - the point being that the API is telling you that you should think about the fact that this operation may not work out even if there is nothing wrong with your code.


It won't "continously ignite" them, it just might throw them each time you invoke it. In your case, if it throws something it means something has gone badly wrong with your standard input.
The goal is to ensure that you, the programmer using the API, deals with the problem, since it is in general assumed to be a recoverable problem - although in your particular case it will be fatal for your whole program.
*/
  while((s=in.readLine())!=null){
   System.out.println(s);
  }
 }
}
