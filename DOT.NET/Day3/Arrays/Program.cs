namespace Arrays
{
    internal class Program
    {
        static void Main1()
        {
           
            int[] arr = new int[5];
            //arr[0] ... arr[4]
            for (int i = 0; i < arr.Length; i++)
            {
                //Console.WriteLine("enter value for arr[__] : ");
                //Console.WriteLine("enter value for arr[" + i + "] : "); //string concatenation
                //Console.WriteLine("enter value for arr[{0}] : ", i);  //placeholder
                Console.Write($"enter value for arr[{i}] : ");  //string interpolation
                arr[i] = int.Parse(Console.ReadLine());
                //arr[i] = Convert.ToInt32(Console.ReadLine());
            }
            foreach (int item in arr)
            {
                Console.WriteLine(item);
            }

        }
        static void Main2()
        {
            int[] arr = { 10, 20, 30, 40, 50,60,50,80 };
            int[] arr2 = new int[5] { 1,2,3,4,5};

            int index = Array.IndexOf(arr, 50); //4
            index = Array.LastIndexOf(arr, 50);  //6
            index = Array.BinarySearch(arr2, 4);  //3 //returns  negative number if not found
            //if (index < 0)
            if (index == -1)
                Console.WriteLine("not found");

            //Array.(arr);
            Array.Copy(arr2, arr, arr2.Length);
            //Array.ConstrainedCopy
            Array.Sort(arr2);
            Array.Reverse(arr2);


        }
        static void Main3()
        {
            int[,] arr = new int[5, 3]; //5 batches, 3 students

            //arr[0,0] arr[0,1] arr[0,2]
            //arr[1,0] arr[1,1] arr[1,2]
            //arr[2,0] arr[2,1] arr[2,2]
            //arr[3,0] arr[3,1] arr[3,2]
            //arr[4,0] arr[4,1] arr[4,2]

            for (int i = 0;i < arr.GetLength(0); i++)
                for (int j = 0;j < arr.GetLength(1); j++)
                {
                    Console.Write($"enter value for arr[{i},{j}] : ");  //string interpolation
                    arr[i,j] = int.Parse(Console.ReadLine());
                }
            Console.WriteLine();
            for (int i = 0; i < arr.GetLength(0); i++)
                for (int j = 0; j < arr.GetLength(1); j++)
                {
                    Console.WriteLine($"value for arr[{i},{j}] is {arr[i,j]} ");  //string interpolation
                }


            //Console.WriteLine(arr.Rank); //no of dimensions -2
            //Console.WriteLine(arr.Length); //15
            //Console.WriteLine(arr.GetLength(0)); //length of first dimension -5
            //Console.WriteLine(arr.GetLength(1)); //length of second dimension -3
            //Console.WriteLine(arr.GetUpperBound(0)); //upper bound of first dimension -5
        }

        static void Main4()
        {


            Employee[] arrEmps = new Employee[5];

            for (int i = 0; i < arrEmps.Length ; i++)
            {
                arrEmps[i] = new Employee();
            }
            foreach (Employee item in arrEmps)
            {
                //item = new Employee(); //read only
                //item.EmpNo = 10; //okay
                //item.Name = "aaaa";
            }
        }

        static void Main5()
        {
            //jagged
            int[][] arr = new int[4][];

            //for (int i = 0; i < arr.Length; i++)
            //{
            //    arr[i] = new int[x]
            //}

            arr[0] = new int[3]; // arr[0][0] arr[0][1] arr[0][2]
            arr[1] = new int[4]; // arr[1][0] arr[1][1] arr[1][2] arr[1][3]
            arr[2] = new int[2];//  arr[2][0] - arr [2][1]
            arr[3] = new int[3];//  arr[3][0] arr[3][1] arr[3][2]

            for (int i = 0; i < arr.Length; i++)
            {
                for (int j = 0; j < arr[i].Length; j++)
                {
                    Console.Write("enter value for subscript [{0}][{1}] : ", i, j);
                    arr[i][j] = Convert.ToInt32(Console.ReadLine());
                }
                Console.WriteLine();
                Console.WriteLine();
            }


            Console.WriteLine();
            Console.WriteLine();
            for (int i = 0; i < arr.Length; i++)
            {
                for (int j = 0; j < arr[i].Length; j++)
                {
                    Console.WriteLine("value for subscript {0},{1} is {2}  ", i, j, arr[i][j]);

                }
            }
            Console.ReadLine();
        }



    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }

    }
}
