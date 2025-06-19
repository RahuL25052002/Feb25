namespace AnonymousMethods
{
    internal class Program
    {
        static void Main()
        {
            int i = 100;
            Action o1 = delegate()
            {
                Console.WriteLine("Anon method called");
                //anon methods can access local variables declared
                //in the outer function
                Console.WriteLine(++i);
            };
            Console.WriteLine(i);
            o1();

            Func<int, int, int> o2 = delegate (int a, int b)
            {
                return a + b;
            };
            Console.WriteLine(o2(10,20));

        }
        
    }
}
