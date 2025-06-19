namespace DelegatesExample
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
        static void Main4()
        {
            //DelAdd objAdd = new DelAdd(Add);
            DelAdd objAdd = Add;
            Console.WriteLine(objAdd(20,10));

            Console.WriteLine();
            objAdd += Subtract;
            //ans = objAdd(20,10);
            Console.WriteLine(objAdd(20, 10));

            //int ans;
            //ans = Add(20, 10);
            //ans = Subtract(20, 10);
            //Console.WriteLine(ans);
        }
        static void Main5()
        {
            Del1 objDel = (Del1) Delegate.Combine(new Del1(Display), new Del1(Show), new Del1(Display));
            objDel();

            Console.WriteLine();
            //objDel = (Del1)Delegate.Remove(objDel, new Del1(Display));
            objDel = (Del1)Delegate.RemoveAll(objDel, new Del1(Display));
            objDel();
        }
        static void Main6()
        {
            //Console.WriteLine(CallMathOperation(new DelAdd(Add)));
            Console.WriteLine(CallMathOperation(Add,1,2));
            Console.WriteLine(CallMathOperation(Subtract,5,3));

        }
        static void Display()
        {
            Console.WriteLine("Display");
        }
        static void Show()
        {
            Console.WriteLine("Show");
        }

        //func to call is passed as a paramter
        static int CallMathOperation(DelAdd objDel, int a, int b)//objDel = Add
        {
            //return objDel(20, 10);
            return objDel(a, b);
        }
        static int Add(int a, int b)
        {
            return a + b;
        }
        static int Subtract(int a, int b)
        {
            return a - b;
        }

        static void Main()
        {
            //Class1.Display();

            Del1 o1 = Class1.Display;
            o1();

            Class1 objClass1 = new Class1();
            //objClass1.Show();
            o1 = objClass1.Show;
            o1();
        }
    }

    public class Class1
    {
        public static void Display()
        {
            Console.WriteLine("Display");
        }
        public void Show()
        {
            Console.WriteLine("Show");
        }
    }
}
