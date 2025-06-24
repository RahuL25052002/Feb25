namespace TPLExamples
{
    internal class Program
    {
        
        static void Main()
        {
            
            int[] arr = new int[10];
            //for (int i = 0; i < arr.Length; i++)
            //{
            //    Thread.Sleep(1000);
            //    arr[i] = i * 10;
            //    Console.WriteLine(arr[i]);
            //}

            //Parallel.For(0, 10, delegate (int i)
            //{
            //    Thread.Sleep(1000);
            //    arr[i] = i * 10;
            //    //Console.WriteLine(arr[i]);
            //});

            //Parallel.For(0, arr.Length, new Action<int>(i =>
            //{
            //    Thread.Sleep(1000);
            //    arr[i] = i * 10;
            //    Console.WriteLine(arr[i]);
            //}));
            //Console.WriteLine("done");
            //Console.WriteLine("after init");
            //foreach (int item in arr)
            //{
            //    Thread.Sleep(1000);
            //    Console.WriteLine(item);
            //}

            //string[] arr2 = new string[10];
            //Parallel.ForEach<string>(arr2, new Action<string>(item =>
            //{
            //    Thread.Sleep(1000);
            //    Console.WriteLine(item);
            //}));


            //Parallel.ForEach<int>(arr, new Action<int>(item =>
            //{
            //    Thread.Sleep(1000);
            //    Console.WriteLine(item);
            //}));


            //use this 
            Parallel.Invoke(Func1, Func2, Func3, Func4, Func5);

            //instead of ...
            //Task.Run(Func1);
            //Task.Run(Func2);
            //Task.Run(Func3);
            //Task.Run(Func4);
            //Task.Run(Func5);


            Console.ReadLine();

        }

        static void Func1()
        {
            Console.WriteLine("Func1");
        }
        static void Func2()
        {
            Console.WriteLine("Func2");
        }
        static void Func3()
        {
            Console.WriteLine("Func3");
        }
        static void Func4()
        {
            Console.WriteLine("Func4");
        }
        static void Func5()
        {
            Console.WriteLine("Func5");
        }
    }
}