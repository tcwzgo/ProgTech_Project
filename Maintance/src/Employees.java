import Observer.Boss;
import Observer.EmployeeClass;
import net.proteanit.sql.DbUtils;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    private JTextField searchText;
    private JButton searchBtn;
    private JButton clearTxtfield;

    private static Logger logger = Logger.getLogger(Employees.class);
    private static DBConnect dbcon = new DBConnect();
    private static EmployeeClass emp;

    public Employees() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (nameText.getText().equals("")  || emailText.getText().equals("") || postText.getText().equals("") || salaryText.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please fill in the textfields!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    String name, email, post, salary;
                    name = nameText.getText();
                    email = emailText.getText();
                    post = postText.getText();
                    salary = salaryText.getText();
                    EmployeeClass emp = new EmployeeClass(name, email, post, Integer.parseInt(salary));

                    try {

                        Connection connection = dbcon.Connect("maintance");
                        PreparedStatement pst = connection.prepareStatement("insert into employees (name, email, post, salary) values(?, ?, ?, ?)");
                        pst.setString(1, emp.getName());
                        pst.setString(2, emp.getEmail());
                        pst.setString(3, emp.getPost());
                        pst.setString(4, String.valueOf(emp.getSalary()));
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record added!", "Success", JOptionPane.PLAIN_MESSAGE);
                        logger.info("Record added to employees table succesfully.");
                        emp.AddEmployee(emp);
                        emp.ListEmployees();
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
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (nameText.getText().equals("")  || emailText.getText().equals("") || postText.getText().equals("") || salaryText.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please fill in the textfields or choose an employee from the table!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    try{
                        String name = nameText.getText();
                        emp.DeleteByName(name);
                        Connection connection = dbcon.Connect("maintance");
                        PreparedStatement pst = connection.prepareStatement("delete from employees where name = ?");
                        pst.setString(1, name);
                        pst.executeUpdate();
                        table_load();
                        nameText.setText("");
                        emailText.setText("");
                        postText.setText("");
                        salaryText.setText("");
                        JOptionPane.showMessageDialog(null, "Deleted succesfully!", "Success", JOptionPane.PLAIN_MESSAGE);
                        logger.info("Record deleted in employees table successfully.");
                    } catch(Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Deleting unsuccessful!", "Error", JOptionPane.ERROR_MESSAGE);
                        logger.info("Deleting records in employess was unsuccessful.");
                    }
                }
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (nameText.getText().equals("")  || emailText.getText().equals("") || postText.getText().equals("") || salaryText.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please fill in the textfields or choose an employee from the table!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    try{
                        String name = nameText.getText();
                        String email = emailText.getText();
                        String post = postText.getText();
                        String salary = salaryText.getText();

                        new Boss(emp);
                        emp.setName(name);
                        emp.setEmail(email);
                        emp.setPost(post);
                        emp.setSalary(Integer.parseInt(salary));

                        Connection connection = dbcon.Connect("maintance");
                        PreparedStatement pst = connection.prepareStatement("update employees set name = ?, email = ?, post = ?, salary = ? where name = ?");
                        pst.setString(1, name);
                        pst.setString(2, email);
                        pst.setString(3, post);
                        pst.setString(4, salary);
                        pst.setString(5, name);
                        pst.executeUpdate();
                        table_load();
                        nameText.setText("");
                        emailText.setText("");
                        postText.setText("");
                        salaryText.setText("");
                        JOptionPane.showMessageDialog(null, "Updated succesfully!", "Success", JOptionPane.PLAIN_MESSAGE);
                        logger.info("Record updated in employees table successfully.");
                    } catch(Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Invalid arguments!", "Error", JOptionPane.ERROR_MESSAGE);
                        logger.info("Updating records in employess was unsuccessful.");
                    }
                }
            }
        });
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table_load();
                getExistingEmployeesFromDb();
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
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(searchText.getText().equals("") || searchText.getText().equals("Search by name"))
                {
                    JOptionPane.showMessageDialog(null, "Please fill in the textfield!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    try{
                        String name = searchText.getText();

                        Connection connection = dbcon.Connect("maintance");
                        PreparedStatement pst = connection.prepareStatement("select * from employees where name = ?");
                        pst.setString(1, name);
                        ResultSet rs = pst.executeQuery();

                        if(rs.next())
                        {
                            String name_ = rs.getString(2);
                            String email_ = rs.getString(3);
                            String post_ = rs.getString(4);
                            String salary_ = rs.getString(5);

                            nameText.setText(name_);
                            emailText.setText(email_);
                            postText.setText(post_);
                            salaryText.setText(salary_);
                        }
                        else
                        {
                            nameText.setText("");
                            emailText.setText("");
                            postText.setText("");
                            salaryText.setText("");
                            JOptionPane.showMessageDialog(null, "Invalid name!", "Error", JOptionPane.ERROR_MESSAGE);
                            logger.info("A select query was successful.");
                        }
                    } catch(Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Invalid name!", "Error", JOptionPane.ERROR_MESSAGE);
                        logger.info("A select query was unsuccessful.");
                    }
                }
            }
        });
        clearTxtfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                emailText.setText("");
                postText.setText("");
                salaryText.setText("");
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();

                nameText.setText(model.getValueAt(selectedRowIndex, 1).toString());
                emailText.setText(model.getValueAt(selectedRowIndex, 2).toString());
                postText.setText(model.getValueAt(selectedRowIndex, 3).toString());
                salaryText.setText(model.getValueAt(selectedRowIndex, 4).toString());

                emp = new EmployeeClass(model.getValueAt(selectedRowIndex, 1).toString(), model.getValueAt(selectedRowIndex, 2).toString(),
                        model.getValueAt(selectedRowIndex, 3).toString(), Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString()));
            }
        });
        salaryText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
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
            logger.info("Records selected to table in employees successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed loading table!", "Error", JOptionPane.ERROR_MESSAGE);
            logger.info("Selecting records to table in employees was unsuccessful.");
        }

    }

    private static void getExistingEmployeesFromDb()
    {
        try {
            ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
            Connection connection = dbcon.Connect("maintance");
            PreparedStatement pst = connection.prepareStatement("select * from employees");
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(rs.getString("name"));
                inner.add(rs.getString("email"));
                inner.add(rs.getString("post"));
                inner.add(rs.getString("salary"));
                outer.add(inner);
            }
            for (int i = 0; i < outer.size(); i++) {
                //System.out.println(outer.get(i).get(0));
                EmployeeClass employeeClass = new EmployeeClass(outer.get(i).get(0), outer.get(i).get(1), outer.get(i).get(2), Integer.parseInt(outer.get(i).get(3)));
                //System.out.println(employeeClass.getName() + " " + employeeClass.getEmail() + " " + employeeClass.getPost() + " " + employeeClass.getSalary());
                employeeClass.AddEmployee(employeeClass);
                employeeClass.ListEmployees();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed loading table!", "Error", JOptionPane.ERROR_MESSAGE);
            logger.info("Selecting records to arraylist in EmployeeClass was unsuccessful.");
        }
    }
}
