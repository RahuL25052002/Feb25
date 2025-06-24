using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace AsyncCodeWithDelegates
{
    internal class Program
    {
        static void Main1()
        {
            Action oDel = Display;
            Console.WriteLine("before");
            //oDel(); //sync call
            oDel.BeginInvoke(null, null); //async call
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void Display()
        {
            System.Threading.Thread.Sleep(5000);
            Console.WriteLine("display called");
        }

    }
}


namespace AsyncCodeWithDelegates2
{
    internal class Program
    {
        static void Main2()
        {
            Action<string> oDel = Display;
            Console.WriteLine("before");
            //oDel(); //sync call
            oDel.BeginInvoke("passed value", null, null); //async call
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void Display(string s)
        {
            System.Threading.Thread.Sleep(5000);
            Console.WriteLine("display called" + s);
        }

    }
}


namespace AsyncCodeWithDelegates3
{
    internal class Program
    {
        static void Main3()
        {
            Func<string, string> oDel = Display;
            Console.WriteLine("before");
            oDel.BeginInvoke("passed value", new AsyncCallback(CallbackFunction), null); //async call
            Console.WriteLine("after");
            Console.ReadLine();
        }
        //will be called after Display
        static void CallbackFunction(IAsyncResult ar)
        {
            Console.WriteLine("callback func called");
        }
        static string Display(string s)
        {
            System.Threading.Thread.Sleep(5000);
            Console.WriteLine("display called" + s);
            return s.ToUpper();
        }

    }
}

namespace AsyncCodeWithDelegates4
{
    internal class Program
    {
        static void Main()
        {
            Func<string, string> oDel = Display;
            Console.WriteLine("before");
           IAsyncResult ar1 =oDel.BeginInvoke("passed value", delegate(IAsyncResult ar)
        {
                Console.WriteLine("callback func called");
            }, null); //async call


            string retVal=oDel.EndInvoke(ar1);
            Console.WriteLine(retVal);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        //will be called after Display
        static void CallbackFunction(IAsyncResult ar)
        {
            Console.WriteLine("callback func called");
        }
        static string Display(string s)
        {
            System.Threading.Thread.Sleep(5000);
            Console.WriteLine("display called" + s);
            return s.ToUpper();
        }

    }
}
