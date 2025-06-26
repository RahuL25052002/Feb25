using System.Runtime.Serialization.Formatters.Soap;
using System.Runtime.Serialization.Json;
using System.Xml.Serialization;

namespace SerializAayionWitCore
{
    internal class Program
    {
        static void Main(string[] args)
        {
            JSON_Serialize();
            JSON_DeSerialize();
            Soap_Serialize();
            Soap_DeSerializ();
        }

        private static void Soap_Serialize()
        {
            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            SoapFormatter sf = new SoapFormatter();
            Stream s = new FileStream("C:\\o.soap", FileMode.Create);
            sf.Serialize(s, o);
            s.Close();
        }
        private static void Soap_DeSerializ()
        {
            SoapFormatter sf = new SoapFormatter();
            Stream s = new FileStream("C:\\o.soap", FileMode.Open);
            Class1 o = (Class1)sf.Deserialize(s);
            s.Close();
            //MessageBox.Show(o.i.ToString());
            //MessageBox.Show(o.P1);
            //MessageBox.Show(o.P2.ToString());
            Console.WriteLine(o.i.ToString());
            Console.WriteLine(o.P1);
            Console.WriteLine(o.P2.ToString());
        }
        
        private static void JSON_Serialize()
        {
            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            DataContractJsonSerializer js = new DataContractJsonSerializer(typeof(Class1));
            Stream s = new FileStream("C:\\o.json", FileMode.Create);
            js.WriteObject(s, o);
            s.Close();
        }

        private static void JSON_DeSerialize()
        {
            DataContractJsonSerializer js = new DataContractJsonSerializer(typeof(Class1));
            Stream s = new FileStream("C:\\o.json", FileMode.Open);
            Class1 o = (Class1)js.ReadObject(s);
            s.Close();
            //MessageBox.Show(o.i.ToString());
            //MessageBox.Show(o.P1);
            //MessageBox.Show(o.P2.ToString());
            Console.WriteLine(o.i.ToString());
            Console.WriteLine(o.P1);
            Console.WriteLine(o.P2.ToString());
        }
    }

    [Serializable]
    public class Class1 //:ISerializable
    {
        private int private_data;
        public int i;
        [XmlElement]
        public string P1
        {
            get;
            set;
        }
        private int mP2;
        [XmlAttribute]
        public int P2
        {
            get { return mP2; }
            set { mP2 = value; }
        }


        //public void GetObjectData(SerializationInfo info, StreamingContext context)
        //{
        //    //called during Serialize
        //    info.AddValue("i", i);
        //    info.AddValue("mP2", mP2);
        //}
        //public Class1()
        //{

        //}
        //public Class1(SerializationInfo info, StreamingContext context)
        //{
        //    //called during Deserialize
        //    i = info.GetInt32("i");
        //    mP2 = info.GetInt32("mP2");
        //}
    }


}
