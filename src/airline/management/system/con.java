package airline.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class con {
    Connection c;
    Statement s;
    con () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///javaproject","root","rushi@21");
            s = c.createStatement();

        }catch (Exception ae) {
            System.out.println(ae);
        }
    }
}
