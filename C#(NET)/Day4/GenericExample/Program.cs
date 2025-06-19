namespace GenericExample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            MyStack<int> mystack=new MyStack<int>(4);
            for (int i = 0; i < 4; i++)
            {
                mystack.push(i);
            }

            for(int i = 0;i < 7; i++)
            {
                Console.WriteLine(mystack.pop());
            }
        }
    }


    class IntegerStack
    {
        int[] arr;
        public IntegerStack(int Size)
        {
            arr = new int[Size];
        }
        int Pos = -1;
        public void Push(int i)
        {
            if (Pos == (arr.Length - 1))
                throw new Exception("Stack full");
            arr[++Pos] = i;
        }
        public int Pop()
        {
            if (Pos == -1)
                throw new Exception("Stack Empty");
            return arr[Pos--];
        }
    }
    class StringStack
    {
        string[] arr;
        public StringStack(int Size)
        {
            arr = new string[Size];
        }
        int Pos = -1;
        public void Push(string i)
        {
            if (Pos == (arr.Length - 1))
                throw new Exception("Stack full");
            arr[++Pos] = i;
        }
        public string Pop()
        {
            if (Pos == -1)
                throw new Exception("Stack Empty");
            return arr[Pos--];
        }
    }

    public class MyStack<T>
        //where T: class//if we write Mystack<int> so it give an error
        /*
         * this constraint means T must be a reference type (like string, class, interface, delegate, or an array).
         */
        //where T:new()
    {

        public T[]arr;
        public MyStack(int size)
        {
            arr= new T[size];
        }
        int pos = -1;
        public void push(T item)
        {
            if (pos == arr.Length - 1)
            {
                throw new Exception("array size full");
            }
            arr[++pos] = item;
        }

        public void DoSomething()
        {
            //T obj = new T();
        }

        public T pop()
        {
            if (pos == -1)
                throw new Exception("Empty array");
           return arr[pos--]; 

        }


    }
}
