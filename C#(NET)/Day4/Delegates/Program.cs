namespace Delegates
{
    //step 1 : create a delegate class that matches
    //the signature of the function
    public delegate void Del1();

    //Object
    //Delegate
    //MulticastDelegate
    //Del1

    public delegate int DelAdd(int a, int b);

    internal class Program
    {
        static void Main1()
        {
            //Display();
            //step 2 : create a delegate reference.
            //make the reference refer to an object of the delegate class
            //the delegate object has the function to call as a parameter
            Del1 objDel = new Del1(Display);

            //step 3 : call the function indirectly using the delegate reference
            objDel();

        }
        static void Main2()
        {

            //Del1 objDel = new Del1(Display);
            Del1 objDel = Display;
            objDel();

            Console.WriteLine();
            objDel = Show;
            objDel();
        }
        static void Main3()
        {

            //Del1 objDel = new Del1(Display);
            Del1 objDel = Display;
            objDel();

            Console.WriteLine();
            objDel += Show;
            objDel();

            Console.WriteLine();
            objDel += Display;
            objDel();

            Console.WriteLine();
            objDel -= Display;
            objDel();

            Console.WriteLine();
            objDel -= Show;
            objDel();

            Console.WriteLine();
            objDel -= Display;
            objDel();

        }
        static void Main()
        {
            //DelAdd objAdd = new DelAdd(Add);
            DelAdd objAdd = Add;

            Console.WriteLine(objAdd(20, 10));
        }
        static void Display()
        {
            Console.WriteLine("Display");
        }
        static void Show()
        {
            Console.WriteLine("Show");
        }
        static int Add(int a, int b)
        {
            return a + b;
        }
    }
}
