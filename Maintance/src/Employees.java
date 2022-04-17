import net.proteanit.sql.DbUtils;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employees {
    private JPanel Main;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel postLabel;
    private JLabel salaryLabel;
    private JTextField nameText;
    private JTextField emailText;
    private JTextField postText;
    private JTextField salaryText;
    private JButton addBtn;
    private JTable table;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton showBtn;
    private JButton cleartableBtn;

    private static Logger logger = Logger.getLogger(Employees.class);
    private static DBConnect dbcon = new DBConnect();

    public Employees() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name, email, post, salary;
                name = nameText.getText();
                email = emailText.getText();
                post = postText.getText();
                salary = salaryText.getText();

                try {

                    Connection connection = dbcon.Connect("maintance");
                    PreparedStatement pst = connection.prepareStatement("insert into employees (name, email, post, salary) values(?, ?, ?, ?)");
                    pst.setString(1, name);
                    pst.setString(2, email);
                    pst.setString(3, post);
                    pst.setString(4, salary);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record added!", "Success", JOptionPane.PLAIN_MESSAGE);
                    logger.info("Record added to employees table succesfully.");
                    nameText.setText("");
                    emailText.setText("");
                    postText.setText("");
                    salaryText.setText("");
                    table_load();
                } catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed adding record!", "Error", JOptionPane.ERROR_MESSAGE);
                    logger.info("Adding record to employees table was unsuccessful.");
                }

            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table_load();
            }
        });
        cleartableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                model.setColumnCount(0);
            }
        });
    }

    public static void main(String[] args) {
        showWindow();
        //TestDatabase();
    }

    public static void showWindow()
    {
        JFrame frame = new JFrame("Employees");
        frame.setContentPane(new Employees().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // kezdésnél középen jelenik meg az ablak
        //logger.info("Test log - My third log!");
    }

    /*public static void TestDatabase()
    {
        try {
            DBConnect dbcon = new DBConnect();
            Connection connection = dbcon.Connect("maintance");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/

    private void table_load()
    {
        try {
            Connection connection = dbcon.Connect("maintance");
            PreparedStatement pst = connection.prepareStatement("select * from employees");
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed loading table!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
