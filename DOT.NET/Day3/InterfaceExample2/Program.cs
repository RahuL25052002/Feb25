namespace InterfaceExample1
{
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }
    public class Class1 : IDbFunctions
    {
        public void Delete()
        {
            Console.WriteLine("Delete");
        }

        public void Insert()
        {
            Console.WriteLine("Insert");
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
            //method 1
            obj.Insert();
            obj.Update();
            obj.Delete();
            obj.Show();
            //method 2 - explicit reference
            IDbFunctions oIDb;
            oIDb = obj;
            oIDb.Insert();
            //method 3 - implicit reference
            ((IDbFunctions)obj).Insert();
            //method 4 - implicit reference
            (obj as IDbFunctions).Insert();

        }
    }
}
namespace InterfaceExample2
{
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }
    public interface IFileFunctions
    {
        void Open();
        void Close();
        void Delete();
    }
    public class Class1 : IDbFunctions, IFileFunctions
    {
        void IDbFunctions.Delete()
        {
            Console.WriteLine("IDb.Delete");
        }

        public void Insert()
        {
            Console.WriteLine("IDb.Insert");
        }

        public void Update()
        {
            Console.WriteLine("IDb.Update");
        }
        public void Show()
        {
            Console.WriteLine("Show");
        }

        //void IFileFunctions.Open()
        //{
        //    Console.WriteLine("IFile.Open");
        //}
        //void IFileFunctions.Close()
        //{
        //    Console.WriteLine("IFile.Close");
        //}
        void IFileFunctions.Delete()
        {
            Console.WriteLine("IFile.Delete");
        }
        public void Open()
        {
            Console.WriteLine("IFile.Open");
        }

        public void Close()
        {
            Console.WriteLine("IFile.Close");
        }
    }
    internal class Program
    {
        static void Main1()
        {
            Class1 obj = new Class1();
            //method 1

            obj.Insert();
            obj.Update();
            obj.Open();
            obj.Close();
            //obj.Delete();
            obj.Show();
            //method 2 - explicit reference
            IDbFunctions oIDb;
            oIDb = obj;
            oIDb.Insert();
            oIDb.Delete();

            IFileFunctions oIFile;
            oIFile = obj;
            oIFile.Open();
            oIFile.Delete();

            //method 3 - implicit reference
            ((IDbFunctions)obj).Insert();
            ((IFileFunctions)obj).Open();

            //method 4 - implicit reference
            (obj as IDbFunctions).Insert();
            (obj as IFileFunctions).Open();


        }
    }
}
namespace Interfaces3
{
    internal class Program
    {
        static void Main()
        {
            Class1 obj1 = new Class1();
            Class2 obj2 = new Class2();

            IDbFunctions oIDb;
            oIDb = obj1;
            oIDb.Insert();

            oIDb = obj2;
            oIDb.Insert();

        }
        static void Main2()
        {
            Class1 obj1 = new Class1();
            Class2 obj2 = new Class2();

            InsertObject(obj1);
            InsertObject(obj2);

        }

        //can receive an object of any class that implements the interface
        static void InsertObject(IDbFunctions oIDb) //oIDb = obj1
        {
            oIDb.Insert();
        }
    }
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }

    public class Class1 : IDbFunctions
    {
        public void Delete()
        {
            Console.WriteLine("Idb.Delete from class1");
        }
        public void Insert()
        {
            Console.WriteLine("Idb.Insert from class1");
        }

        public void Update()
        {
            Console.WriteLine("Idb.Update from class1");
        }

    }

    public class Class2 : IDbFunctions
    {
        public void Delete()
        {
            Console.WriteLine("Idb.Delete from class2");
        }
        public void Insert()
        {
            Console.WriteLine("Idb.Insert from class2");
        }

        public void Update()
        {
            Console.WriteLine("Idb.Update from class2");
        }

    }
}
//advantages of interfaces

//contract - class MUST implement all the interface methods
//similar code in entire project for all developers
//polymorphic code
//design patterns 


//TO DO - try interface inheritance
//I1 - A()B()
//I2 : I1 - C() D()
//Class1 :I2
