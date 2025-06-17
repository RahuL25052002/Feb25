namespace DefaultImplementationInterfaces1
{
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
        void Select()
        {
            Console.WriteLine("IDb.select - DEFAULT");
        }
       
    }

    public class Class1 : IDbFunctions
    {
        public void Delete()
        {
            Console.WriteLine("Delete");
        }
        public void Insert()
        {
            Console.WriteLine("Insert from class1");
        }
        public void Update()
        {
            Console.WriteLine("Update");
        }
        public void Show()
        {
            Console.WriteLine("Show");
        }
    }

    internal class Program
    {
        static void Main1()
        {
            Class1 obj = new Class1();
            obj.Insert();
            //scenario 1 
            //Select method not available thru method1
            //obj.Select();  // error

            //available with method 2/3/4
            (obj as IDbFunctions).Select();
            //def imple code will be called

        }
    }
}

namespace DefaultImplementationInterfaces2
{
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
        void Select()
        {
            Console.WriteLine("def implentation code for select");
        }
    }

    public class Class1 : IDbFunctions
    {
        public void Delete()
        {
            Console.WriteLine("Delete");
        }
        public void Insert()
        {
            Console.WriteLine("Insert from class1");
        }
        public void Update()
        {
            Console.WriteLine("Update");
        }
        public void Show()
        {
            Console.WriteLine("Show");
        }
        //scenario 2
        //Select has been implemented in class
        public void Select()
        {
            Console.WriteLine("Select code from class1");
        }
    }

    internal class Program
    {
        static void Main2(string[] args)
        {
            Class1 obj = new Class1();
            obj.Insert();
            //scenario 2 
            //Select method available thru method1
            obj.Select();  //calls class1 select code

            //also available with method 2/3/4
            (obj as IDbFunctions).Select();
            //calls class1 select code
        }
    }
}
namespace DefaultImplementationInterfaces3
{
    public interface IDbFunctions
    {
        //public int i; //error - cannot contain fields
        //can contain properties
        //can contain static members
        public static int i;

        void Insert();
        void Update();
        void Delete();
        void Select()
        {
            Console.WriteLine("IDB def implentation code for select");
        }
    }
    public interface I2
    {

        void Select()
        {
            Console.WriteLine("I2 def implentation code for select");
        }
    }
    public class Class1 : IDbFunctions, I2
    {
        public void Delete()
        {
            Console.WriteLine("Delete");
        }
        public void Insert()
        {
            Console.WriteLine("Insert from class1");
        }
        public void Update()
        {
            Console.WriteLine("Update");
        }
        public void Show()
        {
            Console.WriteLine("Show");
        }
        //scenario 2
        //Select has been implemented in class
        void IDbFunctions.Select()
        {
            Console.WriteLine("Select code from class1 - idb");
        }
        void I2.Select()
        {
            Console.WriteLine("Select code from class1 - I2");
        }
    }

    internal class Program
    {
        static void Main(string[] args)
        {
            Class1 obj = new Class1();
            obj.Insert();
            //scenario 3 
            //Select method NOT available thru method1
            //obj.Select();  //error

            // available with method 2/3/4
            (obj as IDbFunctions).Select();
            //calls class1 idb select code

            (obj as I2).Select();
            //calls class1 I2 select code



        }
    }
}