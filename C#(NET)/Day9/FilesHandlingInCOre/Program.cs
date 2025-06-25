namespace FilesHandlingInCOre
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    

    private void button4_Click(object sender, EventArgs e)
        {
            //string s = "Hello World";
            //byte[] arr = Encoding.Default.GetBytes(s);

            // FileStream stream = File.Open("C:\\aaaa\\a.txt", FileMode.Create);

            //stream.Write(arr, 0, arr.Length);

            ////stream.Length
            ////stream.Read()
            //stream.Close();






            //-------------------------------
            StreamWriter writer = File.CreateText("C:\\aaaa\\a.txt");
            writer.WriteLine("Hello World");
            writer.WriteLine("Line 2");
            writer.WriteLine("Done for the day");

            writer.Close();
        }

        private void button5_Click(object sender, EventArgs e)
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
