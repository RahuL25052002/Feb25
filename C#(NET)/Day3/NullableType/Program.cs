namespace NullableType
{
    internal class Program
    {
        static void Main1(string[] args)
        { 
            int? i;//nllable type 
            //int j = null;
            i = 10;
            i = null;

            int j;
            //if (i != null)
            //{
            //    j = (int)i;
            //}
            //else
            //    j = 0;

            j =i.GetValueOrDefault();//return value if null then return default value of that 
            Console.WriteLine(j);

            j = i.GetValueOrDefault(999);
            Console.WriteLine(j);

            j = i ?? 0;//null coalescennce operator

            Console.WriteLine(j);
        }

        static void Main()
        {
            String? s;
            s = null;
            s=Console.ReadLine()!; // ! bang  operator it supress the warning

            Console.WriteLine(s);
        }
    }
}
