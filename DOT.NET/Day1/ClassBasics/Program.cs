//using System;  //current file
global using System; //entire project
namespace ClassBasics
{
    internal class Program
    {
        static void Main1()
        {
            Console.WriteLine("Hello, World!");
            System.Console.WriteLine("h w");
            System.Console.WriteLine("aa");
        }
        static void Main()
        {
            Class1 obj; //obj is reference of type Class1
            obj = new Class1(); //new Class1() is the object

            //Class1 o2 = new Class1();
            obj.Display();
            obj.Display("abc");

            //positional parameters
            Console.WriteLine(obj.Add(10, 20, 30));
            Console.WriteLine(obj.Add(10, 20));
            Console.WriteLine(obj.Add(10));
            Console.WriteLine(obj.Add());

            //named parameters
            Console.WriteLine(obj.Add(a: 10, b: 20, c: 30));
            Console.WriteLine(obj.Add(c: 30, a: 10, b: 20));
            Console.WriteLine(obj.Add(c: 30));
            Console.WriteLine(obj.Add(a: 10, c: 30));

            Console.WriteLine(obj.Add(10, c: 30));
            //Console.WriteLine(obj.Add(10, a: 30)); //error

            obj.DoSomething1();
        }
    }
    public class Class1 //: Object
    {
        public void Display()
        {
            System.Console.WriteLine("Display called");
        }
        //overload 
        public void Display(string s)
        {
            System.Console.WriteLine("Display called:" + s);
        }
        //public int Add(int a, int b)
        //{
        //    return a + b;
        //}
        //public int Add(int a, int b, int c)
        //{
        //    return a + b + c;
        //}

        //def values are given from right to left
        public int Add(int a=0, int b=0, int c=0)
        {
            return a + b + c;
        }

        public void DoSomething1()
        {
            int i= 100; //local variable is a variable declared in a function
            //local variables are unassigned
           
            DoSomething2();
            Console.WriteLine(i);

            //local function - func defined within another func
            //only available from the outer function
            //implicitly private
            void DoSomething2()
            {
                //local func can access local variables declared in the outer function
                Console.WriteLine(++i);
            }
            //void DoSomething2(string s) //error - cannot overload a local func
            //{
            //    //local func can access local variables declared in the outer function
            //    Console.WriteLine(++i);
            //}

            static void DoSomething3()
            {
                //static local func CANNOT access local variables declared in the outer function
                //Console.WriteLine(++i); //error
            }
        }
        
    }
}
namespace Payroll
{
    public class Employee { }
    public class Manager{ }
    public class Department { }
}
namespace Cricket
{
    public class Player { }
    public class Manager { }
}
namespace n1
{
    namespace n2
    {
        public class Employee { }
    }
}