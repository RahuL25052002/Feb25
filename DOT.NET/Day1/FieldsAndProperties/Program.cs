   namespace FieldsAndProperties
{
    internal class Program
    {
        static void Main1()
        {
            Class1 obj = new Class1();
            obj.Prop1 = 10;  //assign - set
            Console.WriteLine(obj.Prop1); //read - get

            //obj.i = 12345;
            //Console.WriteLine(obj.i);
            //obj.i = ++obj.i + obj.i++ - --obj.i - obj.i--;


            //obj.Seti(101);
            //Console.WriteLine(obj.Geti());
        }
        static void Main()
        {
            Class1 o = new Class1();
            o.Prop4 = "a";
            Console.WriteLine(o.Prop4);
        }
    }

    public class Class1
    {
        //private int i;//field - class level variable
        //public void Seti(int VALUE)
        //{
        //    if(VALUE < 100)
        //        i = VALUE;
        //    else
        //        Console.WriteLine("invalid i");
        //}
        //public int Geti()
        //{
        //    return i;
        //}
        private int prop1;
        //why property? - validations
        public int Prop1
        {
            set 
            {
                if (value < 100)
                    prop1 = value;
                else
                    Console.WriteLine("invalid Prop1");
            }
            get 
            { 
                return prop1;
            }
        }
        private string prop2;
        public string Prop2
        {
            set
            {
                prop2 = value;
            }
            get
            {
                return prop2;
            }
        }
        public string Prop3;
        //automatic property /auto 
        //when there is no validation
        //compiler generates code for get/set
        //compiler generates private variable
        public string Prop4 { get; set; }

        //TO DO - create a read only property (only get, no set)
    }
}
