using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ThreadingExample5
{
    internal class Program
    {
        private static Object LockObj=new Object();
        static void Main1()
        {
            for (int i = 0; i < 5; i++) {
                new Thread(Display).Start();
            }
        }

        static void Display()
        {
            lock (LockObj)
            {

                Console.WriteLine($"Thread {Thread.CurrentThread.ManagedThreadId}  starting.....");
                Thread.Sleep(2000);
                Console.WriteLine($"Thread {Thread.CurrentThread.ManagedThreadId}  ending.....");
            }

        }
    }
}

namespace ThreadingExample6
{
    internal class Program
    {
        private static Object LockObj = new Object();
        static void Main()
        {
            for (int i = 0; i < 5; i++)
            {
                new Thread(Display).Start();
            }
        }

        static void Display()
        {
            try
            {
                Monitor.Enter(LockObj);

                Console.WriteLine($"Thread {Thread.CurrentThread.ManagedThreadId}  starting.....");
                Thread.Sleep(2000);
                //throw new Exception();
                Console.WriteLine($"Thread {Thread.CurrentThread.ManagedThreadId}  ending.....");

            }
            catch (Exception ex)
            {
                //logger
            }
            finally
            {
                Monitor.Exit(LockObj);
            }
          
           
        }
    }
}
