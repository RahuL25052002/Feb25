//using System.Threading.Tasks;
namespace WorkingWithTasks0
{
    internal class Program
    {
        static void Main1()
        {
            //Task t1 = new Task(new Action(Func1));
            Task t1 = new Task(Func1);//background thread get from threadPool
            t1.Start();
            //t1.Wait();
            Console.ReadLine();
        }
        static void Func1()
        {
            Console.WriteLine("Func1 called");
        }
    }
}

//calling a method with void return type using taskobj.Start
namespace WorkingWithTasks
{
    internal class Program
    {
        static void Main1()
        {
            //Task t0 = new Task(new Action(Func1));

            Task t1 = new Task(Func1);
            Task t2 = new Task(Func2);
            t1.Start();
            //t1.Wait();
            t2.Start();

            //t1.Wait(); //waiting call
            //t2.Wait();

            Console.ReadLine();
        }
        static void Func1()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("First : " + i);
            }
        }
        static void Func2()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("second Func called from {0},{1}",
                    Thread.CurrentThread.ManagedThreadId, i);
            }
        }
    }
}


//calling a method with void return type using Task.Run and Task.Factory.StartNew
namespace Example2
{
    class Program
    {
        static void Main1()
        {
            Task t1 = Task.Run(Func1);
            Task t2 = Task.Factory.StartNew(Func2);
            Console.ReadLine();
        }
        static void Func1()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("first Func called from {0},{1}", Thread.CurrentThread.ManagedThreadId, i);
            }
        }
        static void Func2()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("second Func called from {0},{1}", Thread.CurrentThread.ManagedThreadId, i);
            }
        }
    }
}


//calling a method with void return type and parameters 
namespace Example3
{
    class Program
    {
        static void Main1()
        {
            //Task t1 = new Task(new Action<object>(Func1), "passed value");
            Task t1 = new Task(Func1, "passed value");
            t1.Start();

            Task t2 = Task.Factory.StartNew(Func2, "zzz");

            //Task.Run canot be used to call funcs that have a parameter
            //Task t3 = Task.Run(Func1); //error
            //use anonymous methods instead to access variables declared in calling code
            string s = "ccc";
            Task.Run(delegate () { Console.WriteLine(s); });
            Task.Run(() => { Console.WriteLine(s); });

            Console.ReadLine();
        }
        static void Func1(object obj)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("first Func called {0}{1}", i, obj.ToString());
            }
        }
        static void Func2(object obj)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("second Func called {0},{1}", i, obj.ToString());
            }
        }
    }
}


//calling methods with return value 
namespace Example4
{
    class Program
    {
        static void Main1()
        {
            //Task<int> t1 = new Task<int>(new Func<int>(Func1));
            Task<int> t1 = new Task<int>(Func1);
            Console.WriteLine("before");
            t1.Start();
            Console.WriteLine("after");

            //wait for the return value
            //if (!t1.IsCompleted)
            //    t1.Wait();

            int retval = t1.Result; //Result is also a waiting call
            Console.WriteLine(retval);
            Console.ReadLine();
        }
        static void Main2()
        {
            // Task<int> t1 = new Task<int>(new Func<int>(Func1));
            //Task<int> t2 = new Task<int>(new Func<object?, int>(Func2), "passed value");
            Task<int> t2 = new Task<int>(Func2, "passed value");

            Console.WriteLine("before");
            //t1.Start();
            t2.Start();
            Console.WriteLine("after");

            //wait for the return value
            //if (!t1.IsCompleted)
            //    t1.Wait();

            // int retval = t1.Result; //Result is also a waiting call
            int retval = t2.Result; //Result is also a waiting call
            Console.WriteLine(retval);
            Console.ReadLine();
        }
        static void Main3()
        {
            Task<int> t1 = Task.Run<int>(Func1);
            Task<int> t2 = Task.Factory.StartNew<int>(Func1);

            //Task<int> t4 = Task.Run<int>(Func2,"aaa"); //error //Run dont have to call function which have paramter

            Task<int> t3 = Task.Factory.StartNew<int>(Func2, "passed value");
            Console.WriteLine(t1.Result);
            Console.WriteLine(t2.Result);
            Console.WriteLine(t3.Result);

        }

        static int Func1()
        {
            //Thread.Sleep(5000);
            int i;
            for (i = 0; i < 10; i++)
            {
                Console.WriteLine("first Func called {0}", i);
            }
            return i;
        }
        static int Func2(object obj)
        {
            int i;
            for (i = 0; i < 20; i++)
            {
                Console.WriteLine("second Func called {0},{1}", i, obj.ToString());
            }
            return i;
        }
    }
}