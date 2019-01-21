
import static java.lang.System.out;
import java.sql.*;

public class dbConnection 
{
    Connection cn;
    
    public Connection createConnection()
    {
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String dburl = "jdbc:derby://localhost:1527/temp_medikart";
            String name = "vvs";
            String pass = "vvs";
            cn = DriverManager.getConnection(dburl, name, pass);
            return cn;
        }
        catch(Exception e)
        {
            out.println(e.getMessage().toString());
        }
        return null;
    }
    
}
