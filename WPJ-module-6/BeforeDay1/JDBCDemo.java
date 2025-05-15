import java.sql.*;
class JDBCDemo {

    public static void main(String[] args)throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1527:XE",
                "rahul",
                "cdac");// it made conncection between java application and databse

        Statement stmt = con.createStatement();//statement object creation for requirement or send sql query
        ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");//result set get from the databse after the operation

        //it can it iterate thoght the result set
        while (rs.next()) {
            int x = rs.getInt("a");
            String s = rs.getString("b");
            float f = rs.getFloat("c");
        }
    }
}


// JDBC Product Components
// JDBC includes four components:

// The JDBC API —  The JDBC™ API provides programmatic access to relational data from the Java™ programming language. Using the JDBC API, applications can execute SQL statements, retrieve results, and propagate changes back to an underlying data source. The JDBC API can also interact with multiple data sources in a distributed, heterogeneous environment.

// The JDBC API is part of the Java platform, which includes the Java™ Standard Edition (Java™ SE ) and the Java™ Enterprise Edition (Java™ EE). The JDBC 4.0 API is divided into two packages: java.sql and javax.sql. Both packages are included in the Java SE and Java EE platforms.

// JDBC Driver Manager —  The JDBC DriverManager class defines objects which can connect Java applications to a JDBC driver. DriverManager has traditionally been the backbone of the JDBC architecture. It is quite small and simple.

// The Standard Extension packages javax.naming and javax.sql let you use a DataSource object registered with a Java Naming and Directory Interface™ (JNDI) naming service to establish a connection with a data source. You can use either connecting mechanism, but using a DataSource object is recommended whenever possible.

// JDBC Test Suite —  The JDBC driver test suite helps you to determine that JDBC drivers will run your program. These tests are not comprehensive or exhaustive, but they do exercise many of the important features in the JDBC API.

// JDBC-ODBC Bridge —  The Java Software bridge provides JDBC access via ODBC drivers. Note that you need to load ODBC binary code onto each client machine that uses this driver. As a result, the ODBC driver is most appropriate on a corporate network where client installations are not a major problem, or for application server code written in Java in a three-tier architecture.

// This Trail uses the first two of these four JDBC components to connect to a database and then build a java program that uses SQL commands to communicate with a test relational database. The last two components are used in specialized environments to test web applications, or to communicate with ODBC-aware DBMSs.