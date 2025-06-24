namespace ThreadExaample3
{
    internal class Program
    {
        static void Main()
        {

            //ThreadPool.QueueUserWorkItem(new WaitCallback(Func1!));
            //ThreadPool.QueueUserWorkItem(new WaitCallback(Func1!),"Passed value");

            //ThreadPool.QueueUserWorkItem(Func1!);
            //ThreadPool.QueueUserWorkItem(Func1!,"Passed value");
  
            Console.WriteLine();
            Console.ReadLine();

            int workerthreads, iothreads;
            ThreadPool.GetAvailableThreads(out workerthreads
                , out iothreads);

            ////ThreadPool.SetMinThreads()
            ////ThreadPool.SetMaxThreads
            //ThreadPool.GetMinThreads(out workerthreads, out iothreads);
            //ThreadPool.GetMaxThreads(out workerthreads, out iothreads);
            Console.WriteLine(workerthreads);
            Console.WriteLine(iothreads);
        }
        static void Func1(Object obj)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("First "+i+" "+obj);
            }
        }
    }
}
