using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
//call a function asynchronously using a delegate
//func has no parameters and void return value
namespace AsyncCodeWithDelegates1
{
    internal class Program
    {
        static void Main1()
        {
            Console.WriteLine("before");
            Action oDel = Display;
            oDel.BeginInvoke(null, null);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void Display()
        {
            Thread.Sleep(3000);
            Console.WriteLine("Display called");
        }
    }
}
//call a function asynchronously using a delegate
//func has parameters and void return value
namespace AsyncCodeWithDelegates2
{
    internal class Program
    {
        static void Main2()
        {
            Console.WriteLine("before");
            Action<string> oDel = Display;
            oDel.BeginInvoke("passed value", null, null);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void Display(string s)
        {
            Thread.Sleep(3000);
            Console.WriteLine("Display called : " + s);
        }
    }
}
//call a function asynchronously using a delegate
//func has parameters and a return value
//uses a callback function
namespace AsyncCodeWithDelegates3
{
    internal class Program
    {
        static void Main3()
        {
            Console.WriteLine("before");
            Func<string, string> oDel = Display;
            //oDel.BeginInvoke("passed value", new AsyncCallback(CallbackFunction), null);
            oDel.BeginInvoke("passed value", CallbackFunction, null);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void CallbackFunction(IAsyncResult ar1)
        {
            Console.WriteLine("callback function called");

        }
        static string Display(string s)
        {
            Thread.Sleep(3000);
            Console.WriteLine("Display called : " + s);
            return s.ToUpper();
        }
    }
}
//call a function asynchronously using a delegate
//func has parameters and a return value
//uses a callback function
//also gets the return value - uses anon method to access oDel
namespace AsyncCodeWithDelegates4
{
    internal class Program
    {
        static void Main4()
        {
            Console.WriteLine("before");
            Func<string, string> oDel = Display;
            IAsyncResult ar = oDel.BeginInvoke("passed value", delegate (IAsyncResult ar1)
            {
                Console.WriteLine("callback function called");
                string retval = oDel.EndInvoke(ar1);
                Console.WriteLine(retval);
            }, null);

            Console.WriteLine("after");
            Console.ReadLine();
        }

        static string Display(string s)
        {
            Thread.Sleep(3000);
            Console.WriteLine("Display called : " + s);
            return s.ToUpper();
        }
    }
}
//call a function asynchronously using a delegate
//func has parameters and a return value
//uses a callback function
//passes oDel as last parameter
namespace AsyncCodeWithDelegates5
{
    internal class Program
    {
        static void Main1()
        {
            Console.WriteLine("before");
            Func<string, string> oDel = Display;
            //oDel.BeginInvoke("passed value", CallbackFunction, "extra data");
            //oDel.BeginInvoke("passed value", CallbackFunction, 100);
            oDel.BeginInvoke("passed value", CallbackFunction, oDel);
            Console.WriteLine("after");
            Console.ReadLine();
        }
        static void CallbackFunction(IAsyncResult ar1)
        {
            //ar1.AsyncState -- last parameter from BeginInvoke
            //string s = ar1.AsyncState.ToString();
            //Console.WriteLine("last parameter - " + s);

            //int i = (int)ar1.AsyncState;
            //Console.WriteLine("last parameter - " + i);
            Console.WriteLine("callback function called");

            Func<string, string> oDel = (Func<string, string>)ar1.AsyncState;
            string retval = oDel.EndInvoke(ar1);
            Console.WriteLine(retval);

        }
        static string Display(string s)
        {
            Thread.Sleep(3000);
            Console.WriteLine("Display called : " + s);
            return s.ToUpper();
        }
    }
}
//call a function asynchronously using a delegate
//func has parameters and a return value
//does not use a callback function
//waits using AsyncWaitHandle
namespace AsyncCodeWithDelegates6
{
    internal class Program
    {
        static void Main()
        {
            Console.WriteLine("before");
            Func<string, string> oDel = Display;
            IAsyncResult ar = oDel.BeginInvoke("passed value", null, null);  //async call
            Console.WriteLine("after");

            Console.WriteLine("waiting...");
            ar.AsyncWaitHandle.WaitOne(); //waiting for Display to get over
            Console.WriteLine("here after wait");
            string retval = oDel.EndInvoke(ar);
            Console.WriteLine("retval=" + retval);

            Console.ReadLine();
        }
        static string Display(string s)
        {
            Thread.Sleep(10000);
            Console.WriteLine("Display " + s);
            return s.ToUpper();
        }
    }
}