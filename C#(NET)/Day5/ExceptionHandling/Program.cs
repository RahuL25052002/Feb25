namespace ExceptionHandling
{
    internal class Program
    {
        static void Main0()
        {
            Class1 obj= new Class1();
            //obj=null;  
            int x=int.Parse(Console.ReadLine()!);
            obj.P1 = 100 / x;
            Console.WriteLine(obj.P1);

        }

        static void Main1() //simple try block with catch
        {
            Class1 obj = new Class1();
            try
            {
                //
                //obj = null;
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = 100 / x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
            }
            catch
            {
                Console.WriteLine("Exception occurred");
            }
            Console.WriteLine("code after try");
        }

        static void Main2()//try with multiple catch blocks
        {
            Class1 obj = new Class1();
            try
            {
                obj = null;
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = 100 / x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
            }
            catch (DivideByZeroException)
            {
                Console.WriteLine("DBException occurred");
            }
            catch (NullReferenceException)
            {
                Console.WriteLine("NRException occurred");
            }
            catch (FormatException)
            {
                Console.WriteLine("FormatException occurred");
            }
            Console.WriteLine("code after try");


        }

        static void Main3()// catching base class exceptions
        {
            Class1 obj = new Class1();
            try
            {
                obj = null;
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = 100 / x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
            }

            //catch (SystemException ex)
            catch (FormatException ex)
            {
                Console.WriteLine("FormatException occurred");
            }
            catch (NullReferenceException)
            {
                Console.WriteLine("NRException occurred");
            }
            catch (DivideByZeroException)
            //catch (ArithmeticException) 
            //catch (SystemException) //base class exception has to caught after derived class exceptions
            {
                Console.WriteLine("DBException occurred");
            }
            catch (Exception ex) //catches all unhandled exceptions
            {
                Console.WriteLine(ex.Message);
            }
            Console.WriteLine("code after try");
        }


        static void Main4()// finally block
        {
            Class1 obj = new Class1();
            try
            {
                //obj = null;
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = 100 / x;
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
            //catch (DivideByZeroException ex) 
            //catch (ArithmeticException ex) 
            //catch (SystemException ex) //base class exception has to caught after derived class exceptions
            //{
            //    Console.WriteLine("DBException occurred");
            //}
            //catch (Exception ex) //catches all unhandled exceptions
            //{
            //    Console.WriteLine(ex.Message);
            //}
            //finally runs when Exception does not occur, 
            //or Exception occurs and is handled or 
            //Exception occurs and is NOT handled 
            finally
            {
                Console.WriteLine("finally");

            }
            Console.WriteLine("after try");
        }

        static int DoSomething()// finally block
        {
            Class1 obj = new Class1();
            try
            {
                //obj = null;
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = 100 / x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
                return 1;
            }
            catch (FormatException ex)
            {
                Console.WriteLine("FormatException occurred");
                return -1;
            }
            catch (NullReferenceException ex)
            {
                Console.WriteLine("NRException occurred");
                return -2;
            }
            //catch (DivideByZeroException ex) 
            //catch (ArithmeticException ex) 
            catch (SystemException ex) //base class exception has to caught after derived class exceptions
            {
                Console.WriteLine("DBException occurred");
                return -3;
            }
            catch (Exception ex) //catches all unhandled exceptions
            {
                Console.WriteLine(ex.Message);
                return -100;
            }
            //finally runs when Exception does not occur, 
            //or Exception occurs and is handled or 
            //Exception occurs and is NOT handled 
            finally
            {
                Console.WriteLine("finally");

            }
            Console.WriteLine("after finally");
        }



        static void Main()// nested try block
        {
            Class1 obj = new Class1();
            try
            {
                //obj = null;
                int x = Convert.ToInt32(Console.ReadLine());
                obj.P1 = 100 / x;
                Console.WriteLine(obj.P1);
                Console.WriteLine("No Exceptions");
            }

            catch (FormatException ex)
            {
                try
                {
                    Console.WriteLine("FormatException occurred. Enter only numbers");
                    int x = Convert.ToInt32(Console.ReadLine());
                    obj.P1 = 100 / x;
                    Console.WriteLine(obj.P1);
                }
                catch
                {
                    Console.WriteLine("nested try catch example");
                }
                finally
                {
                    Console.WriteLine("nested try finally example");
                }
            }
            catch (NullReferenceException ex)
            {
                Console.WriteLine("NRException occurred");
            }
            catch (DivideByZeroException ex)
            {
                Console.WriteLine("DBException occurred");
            }
            catch (Exception ex) //catches all unhandled exceptions
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                Console.WriteLine("outer finally");

            }
            Console.ReadLine();
        }
    }



    public class Class1
    {

        private int p1;
        public int P1
        {
            set
            {
                p1 = value;
            }
            get
            {

                return p1;
            }
        }
    }
}
