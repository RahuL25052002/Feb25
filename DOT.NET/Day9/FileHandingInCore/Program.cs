namespace FileHandingInCore
{
    internal class Program
    {
        static void Main(string[] args)
        {
            WriteToFile();
            ReadFromFile();
        }

        private static void WriteToFile()
        {
            StreamWriter writer = File.CreateText("C:\\aaaa\\a.txt");
            writer.WriteLine("Hello World");
            writer.WriteLine("Line 2");
            writer.WriteLine("Done for the day");

            writer.Close();
        }
        private static void ReadFromFile()
        {
            string s;
            StreamReader reader = File.OpenText("C:\\aaaa\\a.txt");
            while ((s = reader.ReadLine()) != null)
            {
                Console.WriteLine(s);
            }
            reader.Close();
        }
    }
}
