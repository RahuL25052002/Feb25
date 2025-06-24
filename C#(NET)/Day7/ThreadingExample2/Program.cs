using System.Runtime.InteropServices;
using System.Security.Cryptography.X509Certificates;

namespace ThreadingExample2
{
    internal class Program
    {
        static void Main()
        {

            Thread t1 = new Thread(new ParameterizedThreadStart(Func1));
            //t1.Start("passed value");
            //t1.Start(1332122);
            //t1.Start(true);
            //List<int> list= new List<int>();
            //list.Add(1);
            //list.Add(2);
            //list.Add(3);
            //t1.Start(list);

            //create array

            //int[] arr = { 10, 20, 40};
            //t1.Start(arr);

            ///class create
             
            Class1S obj=new Class1S(123,"Rahul");

            t1.Start(obj);
            
        }

        public class Class1S
        {
            public int Id { get; set; }
            public string Name { get; set; }

            public Class1S(int id, string name)
            {
                Id = id;
                Name = name;
            }
        }

        //1. Collection or an Array
        //2. create class/struct
        //3. dont
        static void Func1(Object obj)
        {
            //List<int> list =(List<int>) obj;
            //foreach (var item in list)
            //{
            //    Console.WriteLine(item);
            //}


            //int[]arr = (int[])obj;
            //for (int i = 0; i < arr.Length; i++)
            //{
            //    Console.WriteLine(arr[i]+" ");
            //}


            //for class

            Class1S cls=(Class1S)obj;

            Console.WriteLine($"Name: {cls.Name} Id: {cls.Id}");
            //for(int i = 0; i < 10; i++)
            //{
            //    Console.WriteLine("First: "+i+" "+obj); 
            //}
        }
    }
}
