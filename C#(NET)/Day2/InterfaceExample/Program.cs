namespace InterfaceExample
{
    internal class Program
    {
        static void Main()
        {
            //IDbFunction o=new IDbFunction();//error not create instance of interface
            IDbFunction Io;
            //Io.Insert();//error  uninitialized variable we can't use
            Io=new DerivedClass();
            //Io.Insert();
            //Io.Display();//error because it not have member function IDFuntion reference 
            DerivedClass o=new DerivedClass();
            Io = o;
            Io.Update();
            Io.Delete();
            Io.Insert();
           
            //Io.Display(); //gives error because Io is ref of IDfunction and in not havae this member
            Io = (IDbFunction)o;
            o.Display();

            //implcit ref
            ((IDbFunction)o).Update();
            ((IDbFunction)o).Delete();
            ((IDbFunction)o).Insert();

            //sam as method
            (o as IDbFunction).Update();
            (o as IDbFunction).Delete();
            (o as IDbFunction).Insert();


          
        }
    }

    public interface IDbFunction
    {
        void Insert();
        void Delete();
        void Update();
    }
    public class DerivedClass : IDbFunction//if we not override any method it gave n error
    {
        public void Insert()
        {
            Console.WriteLine("Insert from DerivedClass");
        }
        public void Update()
        {
            Console.WriteLine("Update from DerivedClass");
        }
        public void Delete()
        {
            Console.WriteLine("Delete from DerivedClass");
        }
        public void Display()
        {
            Console.WriteLine("Display in DerivedClass");
        }
    }
}
