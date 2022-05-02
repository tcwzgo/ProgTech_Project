import org.apache.log4j.*;
import org.apache.log4j.chainsaw.Main;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.sql.*;

public class DBConnect {
    protected String dbName;
    public DBConnect(String dbName) { this.dbName = dbName; }
    private static Logger logger = Logger.getLogger(DBConnect.class);

    /**
     * function to connect to the database
     * @return the connection to be used in the statements
     * @throws Exception if the connection fails at the end
     */
    public Connection Connect() throws Exception {

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

    /***
     *
     * @param tableName name of the table in the db
     * @throws Exception inherited from Connect()
     */
    protected void SelectAll(String tableName) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect();

        try
        {
            query = connection.prepareStatement(String.format("select * from %s", tableName));
            ResultSet rs = query.executeQuery();
            logger.info("Select was successful.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            logger.warn("Select was unsuccessful.");
        }
    }

    /***
     *
     * @param tableName the name of the table
     * @param field the field name in the db
     * @param txtFieldValue the value from the GUI (textfield)
     * @throws Exception inherited from Connect()
     */
    protected void Delete(String tableName, String field, String txtFieldValue) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect();

        try {
            query = connection.prepareStatement(String.format("delete from %s where %s = ?", tableName, field));
            query.setString(1, txtFieldValue);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record deleted successfully!");
            logger.info("Record deleted successfully.");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            logger.warn("Delete was unsuccessful.");
        }
    }

    /***
     * @param sqlQuery Insert query
     * @throws Exception
     */
    protected void Insert(String sqlQuery) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect();
        try {
            query = connection.prepareStatement(sqlQuery);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record was inserted.");
            logger.info("A record was inserted successfully.");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            logger.warn("Insert was unsuccessful.");
        }
    }

    /***
     * @param sqlQuery query
     * @throws Exception
     */
    protected void Update(String sqlQuery) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect();

        try {
            query = connection.prepareStatement(sqlQuery);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record updated successfully!");
            logger.info("A record was successfully updated.");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
            logger.warn("Update was unsuccessful!");
        }
    }
}
