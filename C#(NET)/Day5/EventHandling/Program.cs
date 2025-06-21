namespace EventHandling
{
    class Program
    {
        static void Main()
        {
            Class1 obj = new Class1();
            try
            {
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
            }
            catch (FormatException ex)
            {
                Console.WriteLine("FormatException occurred");
            }
            catch (NullReferenceException ex)
            {
                Console.WriteLine("NRException occurred");
            }
            catch (InvalidP1Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            catch (ApplicationException ex) //all user defined exceptions that have not been handled before
            {
                Console.WriteLine(ex.Message);
            }
            catch (SystemException ex) //all .net exceptions that have not been handled before
            {
                Console.WriteLine(ex.Message);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }

    public class InvalidP1Exception : ApplicationException
    {
        public InvalidP1Exception(string message) : base(message)
        {

        }
    }

    public class InvalidEx : Exception {

        public InvalidEx(string message) : base(message)
        {

        }
    }


    public class Class1
    {
        private int p1;
        public int P1
        {
            get
            {
                return p1;
            }
            set
            {
                if (value < 100)
                    p1 = value;
                else
                {
                    //Console.WriteLine("invalid p1");
                    //Exception ex = new Exception();
                    //throw ex;

                    //Exception ex = new Exception("Invalid P1");
                    //throw ex;

                    //throw new Exception("Invalid P1");
                    //throw new InvalidP1Exception();
                    throw new InvalidP1Exception("Invalid P1");
                }
            }
        }
    }
}
