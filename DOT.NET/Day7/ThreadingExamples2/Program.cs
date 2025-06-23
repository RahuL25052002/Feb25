namespace ThreadingExamples2
{
    internal class Program
    {
        static void Main()
        {
            Thread t1 = new Thread(new ParameterizedThreadStart(Func1));
            //t1.Start("passed value");
            //t1.Start(12345);
            //t1.Start(true);
            
            List<int> list = new List<int>();
            list.Add(10);
            list.Add(20);
            
            
            t1.Start(list);

            //create array -arr
            //t1.Start(arr);


        }
        //1. pass a collection /array
        //2. pass obj of class/struct
        //3. dont pass, use anon methods

        static void Func1( object obj)
        {
           
            List<int> list = (List<int>)obj;
            foreach (int item in list)
            {
                Console.WriteLine(item);
            }

            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("First : " + i + obj);
            }
        }
    }
}
