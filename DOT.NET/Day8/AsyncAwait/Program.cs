namespace AsyncAwait
{
    internal   class Program
    {
        static async Task Main1()
        {
            Console.WriteLine("Before");
           // string message = DoWork();  //waiting call, blocking call
            string message = await DoWorkAsync();  //waiting call, non blocking call
            Console.WriteLine(message);
            Console.WriteLine("After");
            Console.ReadLine();
        }
        static async Task<string> DoWorkAsync()
        {
            return await Task.Run(() =>
            {
                Thread.Sleep(5000);
                return "Work Done";
            });
        }
        static string DoWork()
        {
                Thread.Sleep(5000);
                return "Work Done";
        }
        static async Task Main2()
        {
            Console.WriteLine("Before");
            Task<Task<string>> t1 = new Task<Task<string>>(DoWorkAsync);
            t1.Start();
            Console.WriteLine("After");


            //do other unrelated things here

            string message = await t1.Result;
            //string message =  t1.Result.Result;
           

            Console.WriteLine(message);
            Console.ReadLine();
        }
    }
}

