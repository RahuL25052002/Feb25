
using Microsoft.Data.SqlClient;
using System.Data;

namespace DataSetExample
{
    public partial class Form1 : Form

    {
        DataSet ds;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //MessageBox.Show("Hello World");
            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True";
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees";

                ds = new DataSet();
                SqlDataAdapter da = new SqlDataAdapter();
                da.SelectCommand = cmd;
                da.Fill(ds, "Emps");

                cmd.CommandText = "select * from Departments";
                da.Fill(ds, "Deps");

                //Primary key
                DataColumn[] arrCols = new DataColumn[1];
                arrCols[0] = ds.Tables["Emps"].Columns["EmpNo"];
                ds.Tables["Emps"].PrimaryKey = arrCols;

                //foreign key
                ds.Relations.Add(ds.Tables["Deps"].Columns["DeptNo"],
                    ds.Tables["Emps"].Columns["DeptNo"]);

                //dataGridView1.DataSource = ds.Tables[0];
                dataGridView1.DataSource = ds.Tables["Emps"];

            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            ////Data Adapter
            ////
            //SqlDataAdapter da = new SqlDataAdapter();

            ////da.UpdateCommand = cmdUpdate;
            ////da.InsertCommand = cmdInsert;
            ////da.DeleteCommand = cmdDelete;
            ////da.Update(ds, "Emps");
            ///

            SqlConnection cn = new SqlConnection();
            try
            {
                cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=JKJune2025;Integrated Security=True";
                cn.Open();

                //UPDATE COMMAND
                SqlCommand cmdUpdate = new SqlCommand();
                cmdUpdate.Connection = cn;
                cmdUpdate.CommandType = CommandType.Text;
                cmdUpdate.CommandText = "update Employees set Name=@Name,Basic=@Basic,DeptNo=@DeptNo where EmpNo =@EmpNo";

                //cmdUpdate.Parameters.AddWithValue("@Name", obj.Name);

                //SqlParameter p;
                //p = new SqlParameter();
                //p.ParameterName = "@Name";
                //p.SourceColumn = "Name";
                //p.SourceVersion = DataRowVersion.Current;
                //cmdUpdate.Parameters.Add(p);

                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@Name", SourceColumn = "Name", SourceVersion = DataRowVersion.Current });
                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@Basic", SourceColumn = "Basic", SourceVersion = DataRowVersion.Current });
                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@DeptNo", SourceColumn = "DeptNo", SourceVersion = DataRowVersion.Current });
                cmdUpdate.Parameters.Add(new SqlParameter { ParameterName = "@EmpNo", SourceColumn = "EmpNo", SourceVersion = DataRowVersion.Original });
                //END OF UPDATE COMMAND

                //INSERT COMMAND
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = CommandType.Text;
                cmdInsert.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";

                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@Name", SourceColumn = "Name", SourceVersion = DataRowVersion.Current });
                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@Basic", SourceColumn = "Basic", SourceVersion = DataRowVersion.Current });
                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@DeptNo", SourceColumn = "DeptNo", SourceVersion = DataRowVersion.Current });
                cmdInsert.Parameters.Add(new SqlParameter { ParameterName = "@EmpNo", SourceColumn = "EmpNo", SourceVersion = DataRowVersion.Current });
                //END OF INSERT COMMAND

                //DELETE COMMAND
                SqlCommand cmdDelete = new SqlCommand();
                cmdDelete.Connection = cn;
                cmdDelete.CommandType = CommandType.Text;
                cmdDelete.CommandText = "delete from Employees where EmpNo =@EmpNo";

                cmdDelete.Parameters.Add(new SqlParameter { ParameterName = "@EmpNo", SourceColumn = "EmpNo", SourceVersion = DataRowVersion.Original });
                //END OF DELETE COMMAND


                SqlDataAdapter da = new SqlDataAdapter();
                da.UpdateCommand = cmdUpdate;
                da.InsertCommand = cmdInsert;
                da.DeleteCommand = cmdDelete;
                da.Update(ds, "Emps");


            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            ds.RejectChanges();//it reject the chnages you made and revert to original value
        }
    }
}
