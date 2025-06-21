namespace Params
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");

            Console.WriteLine(Add(1, 2, 3, 4, 5, 5));
            //int[]arr = { 1, 2,3,4, 5, 6, 7 };
            //Console.WriteLine(Add(1, arr[]));
        }
        //public static int Add(int x,params int[] values) {
        public static int Add(params int[] values)
        {
            int add = 0;
            for (int i = 0; i < values.Length; i++)
            {
                add += values[i];
            }
            return add;
        }
    }
}
