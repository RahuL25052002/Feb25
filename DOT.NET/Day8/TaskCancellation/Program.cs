using System.Threading;
namespace ThreadCancellation
{
    internal class Program
    {
        static void Main()
        {
            CancellationTokenSource cts = new CancellationTokenSource();
            CancellationToken cancellationToken = cts.Token;
            ThreadPool.QueueUserWorkItem(delegate (object? o)
            {
                //long running task
                for (int i = 0; i < 10000000; i++)
                {
                    Console.WriteLine(i);
                    if (cancellationToken.IsCancellationRequested)
                    {
                        Console.WriteLine("task cancelled");
                        break;
                    }
                }
            });
            

            Console.ReadLine();
            cts.Cancel();

            //cts.CancelAfter(2000);

            Console.ReadLine();
        }

        static void Func1()
        {
            //long running task
            for (int i = 0; i < 10000000; i++)
            {
                Console.WriteLine(i);

            }
        }

    }
}

namespace TaskCancellation
{
    internal class Program
    {
        static void Main1()
        {

            CancellationTokenSource cts = new CancellationTokenSource();
            CancellationToken cancellationToken = cts.Token;


            Task t = new Task(delegate()
            {
                //long running task
                for (int i = 0; i < 10000000; i++)
                {
                    Console.WriteLine(i);
                    if (cancellationToken.IsCancellationRequested)
                    {
                        Console.WriteLine("task cancelled");
                        break;
                    }
                }
            },cancellationToken);
            t.Start();

            //Console.ReadLine();
            //cts.Cancel();

            cts.CancelAfter(2000);

            Console.ReadLine();

            Console.WriteLine("Cancelled : " + t.IsCanceled);
            Console.WriteLine("Completed : " + t.IsCompleted);
            Console.WriteLine("Completed Successfully: " + t.IsCompletedSuccessfully);
            Console.WriteLine("IsFaulted : " + t.IsFaulted);
            Console.WriteLine("Status : " + t.Status);


            //Console.ReadLine();

        }
        //using ThrowIfCancellationRequested
        static async Task Main2()
        {
            CancellationTokenSource cts = new CancellationTokenSource();
            CancellationToken cancellationToken = cts.Token;
            
            Task t = new Task(delegate ()
            {
                //long running task
                for (int i = 0; i < 10000000; i++)
                {
                    Console.WriteLine(i);
                    if (cancellationToken.IsCancellationRequested)
                    {
                        Console.WriteLine("task cancelled");
                        cancellationToken.ThrowIfCancellationRequested();
                        break;
                    }
                }
            }, cancellationToken);
            t.Start();

            //Console.ReadLine();
            cts.CancelAfter(2000);
            try
            {
                await t;
            }
            catch (OperationCanceledException e)
            {
                Console.WriteLine("Cancelled : " + t.IsCanceled);
                Console.WriteLine("Completed : " + t.IsCompleted);
                Console.WriteLine("Completed Successfully: " + t.IsCompletedSuccessfully);
                Console.WriteLine("IsFaulted : " + t.IsFaulted);
                Console.WriteLine("Status : " + t.Status);
                

                Console.WriteLine($"Message: {e.Message}");
            }
            finally
            {
                cts.Dispose();
            }
            Console.ReadLine();
        }

    }

}
