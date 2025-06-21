namespace ExtensionMethods
{
    internal class Program
    {
        static void Main1()
        {
            int a = 100;
            a = a.Add(10);
            a.Display();
            a.ExtMethodForBaseClass();
            
            string s = "a";
            s.Show();
            s.ExtMethodForBaseClass();
        }

        static void Main2()
        {
            int a = 100;
            a = MyExtClass.Add(a, 10);
            MyExtClass.Display(a);

            string s = "a";
            MyExtClass.Show(s);
        }

        static void Main()
        {
            ClsMaths objClsMaths = new ClsMaths();
            Console.WriteLine(objClsMaths.Add(10, 5));
            Console.WriteLine(objClsMaths.Multiply(10, 5));
            Console.WriteLine(objClsMaths.Subtract(10, 5)); //ext method for interface

        }
    }

    //to create extension methods
    //step 1 : create a static method in a static class
    public static class MyExtClass
    {
        //step 2 : the first parameter must be the type for which you
        //are writing the extension method, preceded by the 'this' keyword
        public static void Display(this int i)
        {
            Console.WriteLine(i);
        }

        public static int Add(this int i, int j)
        {
            return i + j;
        }
        public static void Show(this string s)
        {
            Console.WriteLine(s);
        }

        //if you add an ext method for the base class,
        //it is also available for the derived class
        public static void ExtMethodForBaseClass(this object o)
        {
            Console.WriteLine(o);
        }
        //if you add an ext method for an Interface,
        //it is also available for the classes that
        //implement the interface
        public static int Subtract(this IMathOperations oIM, int a, int b)
        {
            return a - b;
        }

    }
    public interface IMathOperations
    {
        int Add(int a, int b);
        int Multiply(int a, int b);
    }
    public class ClsMaths : IMathOperations
    {
        public int Add(int a, int b)
        {
            return a + b;
        }
        public int Multiply(int a, int b)
        {
            return a * b;
        }
    }

}