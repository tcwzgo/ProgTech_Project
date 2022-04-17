import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private JTable table1;
    private JButton deleteBtn;
    private JButton updateBtn;

    private static Logger logger = Logger.getLogger(Employees.class);

    public Employees() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
    }

    public static void main(String[] args) {
        showWindow();
        TestDatabase();
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

    public static void TestDatabase()
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
    }
}
