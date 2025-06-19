using System.Collections;

namespace CollectionExample
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            //Console.WriteLine("Hello, World!");

            ArrayList arrayList=new ArrayList();
            arrayList.Add(1);
            arrayList.Add("rahul");

            /*
             * not type safe if we traverse loop like this so it gave an error
             * Bpxing and UnBoxing we have to do thats why it not suffcient
            foreach (int i in arrayList)
            {
                Console.WriteLine(i);
            }
            */

            arrayList.Insert(0, "Rammmmaaa");//insert at the position that need
             
            //arrayList.RemoveAt(0);//remove item at the indexof 0

            //arrayList.Remove("rahul");


            ArrayList newList = new ArrayList();  
            newList.Add(1);
            newList.Add(2); 
            newList.Add(3);
            //arrayList.AddRange(newList);// add element in arraylist of the newlist element

            arrayList.InsertRange(2, newList);//insert element from index 0 in the arraylist

            Console.WriteLine(arrayList.Count);//give no of items in list
            Console.WriteLine(arrayList.Capacity);//gives capacity of araylist
            foreach (object item in arrayList)
            {
                Console.WriteLine(item);
            }

            //arrayList.Clear();//remove all the elements from the list 


            ArrayList o3=(ArrayList)arrayList.Clone();// it return the Object so we have to typecast

            bool isPresent=arrayList.Contains(1);//if 1 present return true else return false

            Console.WriteLine(isPresent);

            //o3 = arrayList.GetRange(2, 4);//it will return subset of list means from 2 index 4 element will be in o3 list  2=index and 4=count

            //o3.RemoveRange(0, 3);// remove 3 element from index 0

            Object[] arr=new object[arrayList.Count];
            arrayList.CopyTo(arr, 0);

            Object arr2=arrayList.ToArray();

            arrayList[0] = "Rahul";
            //arrayList.this[0]="Rahul";
            

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
            objDictionary[50] = "changed value";//if key present so it override the value

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

        static void Main7()
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

