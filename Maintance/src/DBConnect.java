import org.apache.log4j.*;
import org.apache.log4j.chainsaw.Main;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.sql.*;

public class DBConnect {
    private static Logger logger = Logger.getLogger(DBConnect.class);
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

    /***
     *
     * @param tableName name of the table in the db
     * @throws Exception inherited from Connect()
     */
    protected void SelectAll(String tableName) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect("maintanence");

        try
        {
            query = connection.prepareStatement(String.format("select * from %s", tableName));
            ResultSet rs = query.executeQuery();
            //table_1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
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
        Connection connection = this.Connect("maintanence");

        try {
            query = connection.prepareStatement(String.format("delete from %s where %s = ?", tableName, field));
            query.setString(1, txtFieldValue);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record deleted successfully!");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    /***
     *
     * @param tableName name of the table in db
     * @param fields the fields to insert (more readable if we use an array of Strings)
     * @throws Exception
     */
    protected void Insert(String tableName, String[] fields, String[] txtFieldValues) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect("maintanence");
        try {
            query = connection.prepareStatement(String.format(
                    "insert into %s(name, email, personal_number, salary)values(?, ?, ?, ?)", tableName));
            query.setString(1, fields[0]);
            query.setString(2, fields[1]);
            query.setString(3, fields[2]);
            query.setString(4, fields[3]);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record ");
            //table_load();
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }


    }

    /***
     *
     * @param tableName name of the table in db
     * @param fields fields to update in db
     * @param txtFieldValues the values to update the fields with
     * @throws Exception
     */
    protected void Update(String tableName, String[] fields, String[] txtFieldValues) throws Exception {

        PreparedStatement query = null;
        Connection connection = this.Connect("maintanence");

        try {
            query = connection.prepareStatement(String.format(
                    "update %s set %s = ?, %s = ?, %s = ?, %s = ? where %s = ?",
                    tableName, fields[0], fields[1], fields[2], fields[3], fields[0]));
            query.setString(1, txtFieldValues[0]);
            query.setString(2, txtFieldValues[1]);
            query.setString(3, txtFieldValues[2]);
            query.setString(4, txtFieldValues[3]);
            query.setString(5, txtFieldValues[4]);

            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record updated successfully!");
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}
