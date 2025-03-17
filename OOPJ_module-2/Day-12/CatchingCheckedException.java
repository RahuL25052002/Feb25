import java.io.*;

class StaticallyThrownExceptionsIncludeSubtypes {
    public static void main(String[] args) {
        try {
            throw new FileNotFoundException();
        } catch (IOException ioe) {
            // "catch IOException" catches IOException 
            // and any subtype.
        }

        try {
            throw new FileNotFoundException();
              // Statement "can throw" FileNotFoundException.
              // It is not the case that statement "can throw"
              // a subtype or supertype of FileNotFoundException.
        } catch (FileNotFoundException fnfe) {
            // ... Handle exception ...
        }/* catch (IOException ioe) {
            // Legal, but compilers are encouraged to give
            // warnings as of Java SE 7, because all subtypes of
            // IOException that the try block "can throw" have 
            // already been caught by the prior catch clause.
        }*/

        try {
            m();
              // m's declaration says "throws IOException", so
              // m "can throw" IOException. It is not the case
              // that m "can throw" a subtype or supertype of
              // IOException (e.g. Exception).
        } catch (FileNotFoundException fnfe) {
            // Legal, because the dynamic type of the exception 
            // might be FileNotFoundException.
        } catch (IOException ioe) {
            // Legal, because the dynamic type of the exception
            // might be a different subtype of IOException.
        } catch (Throwable t) {
            // Can always catch Throwable.
        }
    }

    static void m() throws IOException {
        throw new FileNotFoundException();
    }
}
