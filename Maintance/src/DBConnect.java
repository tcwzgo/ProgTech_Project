import java.sql.*;

public class DBConnect {

    /**
     * function to connect to the database
     * @param dbName the name of the database
     * @return the connection to be used in the statements
     * @throws Exception if the connection fails at the end
     */
    public static Connection Connect(String dbName) throws Exception {

        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(String.format("jdbc:mysql://localhost/%s", dbName), "root","");
            return connection;
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        throw new Exception("Couldn't connect to the database...");
    }
}
