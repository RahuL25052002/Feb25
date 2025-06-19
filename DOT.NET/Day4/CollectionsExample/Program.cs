using System.Collections;

namespace CollectionsExample
{
    internal class Program
    {
        static void Main1()
        {
            ArrayList objArrayList = new ArrayList();
            objArrayList.Add("Vikram");
            objArrayList.Add(123); //object = int
            objArrayList.Add(1.234);
            objArrayList.Add(true);

            objArrayList.Insert(0, "inserted");

            objArrayList.RemoveAt(2);
            objArrayList.Remove("Vikram");

            ArrayList objArrayList2 = new ArrayList();
            //add items here

            objArrayList.AddRange(objArrayList2);
            objArrayList.InsertRange(0,objArrayList2);

            Console.WriteLine(objArrayList.Count);

            foreach (object item in objArrayList)
            {
                Console.WriteLine(item);
            }

            //objArrayList.Clear(); //remove all
            ArrayList o3 = (ArrayList)objArrayList.Clone();
            bool isPresent = objArrayList.Contains("Vikram");
            

            //o3 = objArrayList.GetRange(2, 3); //index, count

            //objArrayList.RemoveRange(0, 3); //remove first 3

            //objArrayList - 10 20 30 40 50 60 70
            //objArrayList2 - 9 8 7
            objArrayList.SetRange(0, objArrayList2);
            //objArrayList - 9 8 7 40 50 60 70

            object[] arr = new object[objArrayList.Count];
            objArrayList.CopyTo(arr);
            
            object arr2 = objArrayList.ToArray();

            objArrayList[0] = "changed";
            //objArrayList.this[0] = "changed";

        }
        static void Main2()
        {
            ArrayList objArrayList = new ArrayList();
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");


            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");


            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.Add("a");
            Console.WriteLine($"Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

            objArrayList.TrimToSize();
            Console.WriteLine($"after trim Count={objArrayList.Count}, Capacity={objArrayList.Capacity}");

        }
        static void Main3()
        {
            //Hashtable objDictionary = new Hashtable();
            SortedList objDictionary = new SortedList();
            objDictionary.Add(50, "Isha");
            objDictionary.Add(30, "Shriram");
            objDictionary.Add(10, "Shubham");
            objDictionary.Add(20, "Rohan");
            objDictionary.Add(40, "Ritik");

            objDictionary[60] = "Vikram";
            objDictionary[50] = "changed value";

            objDictionary.Remove(60); //key
            objDictionary.RemoveAt(0); //index

            foreach (DictionaryEntry item in objDictionary)
            {
                Console.WriteLine(item.Key);
                Console.WriteLine(item.Value);
            }

            objDictionary.GetByIndex(0); //value at index 0
            objDictionary.GetKey(0);//key at index 0
            IList keys = objDictionary.GetKeyList();
            IList value = objDictionary.GetValueList();

            //objDictionary.IndexOfKey(key);
            //objDictionary.IndexOfValue(value);

            ICollection keys2 = objDictionary.Keys;
            ICollection values2 = objDictionary.Values;

            //objDictionary.SetByIndex(index, value);

        }
        static void Main4()
        {
            Stack stack = new Stack();
            stack.Push(10);
            Console.WriteLine(stack.Peek());
            Console.WriteLine(stack.Pop());

            Queue queue = new Queue();
            queue.Enqueue(10);

            Console.WriteLine(queue.Peek());
            Console.WriteLine(queue.Dequeue());

        }

        static void Main5()
        {
            List<int> list1 = new List<int>();
            list1.Add(1);
            foreach (int item in list1)
            {

            }
            List<string> list2 = new List<string>();

            List<Employee> lstEmps = new List<Employee>();
            lstEmps.Add(new Employee { EmpNo = 1, Name = "Rohan" });
            lstEmps.Add(new Employee { EmpNo = 2, Name = "Anish" });

            foreach (Employee item in lstEmps)
            {
                Console.WriteLine(item.EmpNo);
                Console.WriteLine(item.Name);
            }
        }

        static void Main6()
        {
            SortedList<int, Employee> objSortedList = new SortedList<int, Employee>();
            objSortedList.Add(1, new Employee { EmpNo = 1, Name = "Rohan" });
            objSortedList.Add(2, new Employee { EmpNo = 2, Name = "Anish" });

            foreach (KeyValuePair<int, Employee> item in objSortedList)
            {
                Console.WriteLine(item.Key); //EmpNo
                Console.WriteLine(item.Value.Name); //Value is of type Employee 
            }
        }

        static void Main()
        {
            Stack<int> stack = new Stack<int>();
            stack.Push(10);
            Console.WriteLine(stack.Peek());
            Console.WriteLine(stack.Pop());

            Queue<int> queue = new Queue<int>();
            queue.Enqueue(10);
            Console.WriteLine(queue.Peek());
            Console.WriteLine(queue.Dequeue());



        }
    }
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }

    }
}
