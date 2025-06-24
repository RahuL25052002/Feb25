namespace ThreadingExample
{
    internal class Program
    {
        static void Main1()
        {
            //Func1();
            //Func2();

            Thread t1 = new Thread(new ThreadStart(Func1));
            //Thread t2 = new Thread(new ThreadStart(Func2));
            Thread t2 = new Thread(Func2);
            for (int i = 0; i < 1000; i++)
            {
                Console.WriteLine("Main : " + i);
            }
            t1.Start();//thread will run here
            t2.Start();//thread will run here

            //internally
            //t1.join();
            //t2.join();
        }

        static void Main2()
        {
            //Func1();
            //Func2();

            Thread t1 = new Thread(new ThreadStart(Func1));
            //Thread t2 = new Thread(new ThreadStart(Func2));
            Thread t2 = new Thread(Func2);
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Main : " + i);
            }
            t1.IsBackground = true;
            t2.IsBackground = true;
            t1.Start();
            t2.Start();
        }

        static void Main3()
        {

            Thread t1 = new Thread(new ThreadStart(Func1));
            //Thread t2 = new Thread(new ThreadStart(Func2));
            Thread t2 = new Thread(Func2);
          
            t1.Start();//thread will run here
            t2.Start();//thread will run here

            for (int i = 0; i < 1; i++)
            {
                Console.WriteLine("Main : " + i);
            }
            t1.Join();//wating call -waits for t1 to complete
            Console.WriteLine("This code should run after Func1 is Over");
        }

        static void Main4()
        {
        

            Thread t1 = new Thread(new ThreadStart(Func1));
            //Thread t2 = new Thread(new ThreadStart(Func2));
            t1.Priority = ThreadPriority.Highest;
            t1.Start();

            Thread t2 = new Thread(Func2);
            t2.Priority= ThreadPriority.Lowest;
            t2.Start();

            for (int i = 0; i < 1000; i++)
            {
                Console.WriteLine("Main : " + i);
            }
        }

        static void Main5()
        {
            Thread t1 = new Thread(new ThreadStart(Func1));
            Thread t2 = new Thread(Func2);

            //t1.Abort();
            //t1.Suspend();
            //t1.Resume();
            //if(t1.ThreadState == ThreadState.Stopped)


             t1.Start();//thread will run here
          /*  t1.Start();System.Threading.ThreadStateException: Thread is running or terminated; it cannot restart.
   at System.Threading.Thread.StartCore()
   at ThreadingExample.Program.Main() in D:\Feb25\Feb25\C#(NET)\Day7\ThreadingExample\Program.cs:line 86
First : 946*/
            t2.Start();//thread will run here

            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Main : " + i);
            }

        }

        static void Main6()
        { 

           AutoResetEvent wh=new AutoResetEvent(false);
            Thread t1=new Thread(delegate ()
            {
                for (int i = 0; i < 200; i++)
                {

                    Console.WriteLine("f1: "+i);
                    if (i % 50 == 0)
                    {
                        Console.WriteLine("Waiting");
                        wh.WaitOne();
                    }
                }
            }
            );
            t1.Start();
            Thread.Sleep(4000);
            Console.WriteLine("Resuming.....1");
            wh.Set();

            Thread.Sleep(5000);
            wh.Set();
        }

        static void Main()
        {
            AutoResetEvent wh = new AutoResetEvent(false);
            Thread t1 = new Thread(delegate ()
            {
                for (int i = 0; i < 200; i++)
                {
                    Console.WriteLine("f1:" + i);
                    if (i % 50 == 0)
                    {
                        //instead of Suspend, use this
                        Console.WriteLine("waiting");
                        wh.WaitOne();
                    }
                }
            });
            t1.Start();
            Thread.Sleep(5000);
            //Console.ReadLine();
            Console.WriteLine("resuming 1....");
            wh.Set();

            Thread.Sleep(5000);
            //Console.ReadLine();
            Console.WriteLine("resuming 2....");
            wh.Set();

            Thread.Sleep(5000);
            //Console.ReadLine();
            Console.WriteLine("resuming 3....");
            wh.Set();

            Thread.Sleep(5000);
            //Console.ReadLine();
            Console.WriteLine("resuming 4....");
            wh.Set();
        }

        static void Func1()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("First : " + i);
                //Thread.Sleep(3000);
            }
        }

        static void Func2()
        {
            for (int i = 0; i < 1000; i++)
            {
                Console.WriteLine("Second : " + i);
                //Thread.Sleep(3000);//for main5
            } 
        }
    }
}
