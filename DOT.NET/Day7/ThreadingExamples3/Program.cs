namespace ThreadingExamples3
{
    internal class Program
    {
        static void Main()
        {
            //ThreadPool.QueueUserWorkItem(new WaitCallback(Func1));
            //ThreadPool.QueueUserWorkItem(new WaitCallback(Func1), "passed value");

            //ThreadPool.QueueUserWorkItem(Func1);
            //ThreadPool.QueueUserWorkItem(Func1, "passed value");

            int workerthreads, iothreads;
            ThreadPool.GetAvailableThreads(out workerthreads, out iothreads);
            ////ThreadPool.SetMinThreads()
            ////ThreadPool.SetMaxThreads
            //ThreadPool.GetMinThreads(out workerthreads, out iothreads);
            //ThreadPool.GetMaxThreads(out workerthreads, out iothreads);
            Console.WriteLine(workerthreads);
            Console.WriteLine(iothreads);

            Console.ReadLine();
        }
        static void Func1(object obj)
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("First : " + i + " " + obj);
            }
        }
    }
}
