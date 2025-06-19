using System.Collections;
namespace Day4._1
{
    internal class Program
    {
        static void Main()
        {
            ArrayList arrayList = new ArrayList();
            arrayList.Add(1);
            arrayList.Add("raa");
            arrayList.Add(2.2);

            arrayList.Insert(0, "Inserted");//add the element

            arrayList.Remove("raa");

            arrayList.RemoveAt(0);

            Console.WriteLine(arrayList.Count);

            foreach(object obj in arrayList)
            {
                Console.WriteLine(obj);
            }

            //arrayList.BinarySearch(arrayList.ToArray());

        }
    }
}
