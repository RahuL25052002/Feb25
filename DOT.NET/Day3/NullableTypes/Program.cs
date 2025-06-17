namespace NullableTypes
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            int? i;
            i = 10;
            i = null;


            int j;
            if (i != null)
                j = (int)i;
            else
                j = 0;

            if (i.HasValue)
                j = i.Value;
            else
                j = 0;

            j = i.GetValueOrDefault();
            j = i.GetValueOrDefault(999);

            j = i ?? 0; //null coalescence operator

            Console.WriteLine(j);
        }
        static void Main()
        {
            string? s;
            //string s;
            s = null;
            s = Console.ReadLine()!; //suppress warning for this line

            Console.WriteLine(s);
        }
    }
}
