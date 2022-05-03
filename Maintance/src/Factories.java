import Proxy.FactoryProxy;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Factories {
    private JPanel Main;
    private JTextField tfCompanyName;
    private JTextField tfInstitution;
    private JTextField tfAddress;
    private JButton btnAdd;
    private JButton btnSearch;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JTable dataTable;
    private JSpinner spId;
    private JLabel lblId;

    public static void main(String[] args) {
        showWindow();
    }

    private static Logger logger = Logger.getLogger(Employees.class);
    private static DBConnect database = new DBConnect("maintance");
    private FactoryProxy factoryProxy;

    /**
     * @return txtFields[] array containing data from input
     */
    private ArrayList<String> getTextFieldContent() {

        ArrayList<String> txtFields = new ArrayList<>();
        if (tfCompanyName.getText().equals("") || tfInstitution.getText().equals("") || tfAddress.getText().equals("")) {
            System.out.println("Fill out every input!");
            logger.info("Fill out every input!");
        } else {
            txtFields.add(tfCompanyName.getText());
            txtFields.add(tfInstitution.getText());
            txtFields.add(tfAddress.getText());
        }
        return txtFields;
    }

    /***
     * Constructor
     * Listening to all 'click' events on buttons
     * Using database.Connect() to set the connection
     * Using the according service through the proxy in the event body
     */
    public Factories() {

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    database.Connect();

                    ArrayList<String> data = getTextFieldContent();
                    String name = data.get(0);
                    String addr = data.get(1);
                    String dOInst = data.get(2);
                    factoryProxy.Add(name, addr, dOInst);

                    String sql = String.format("inser into factories (company_name, institution, address) " +
                            "values (%s, %s, %s)", name, addr, dOInst);
                    database.Insert(sql);

                } catch (Exception exception) {
                    logger.warn("Insert failed due to error: " + exception.getMessage());
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> data = getTextFieldContent();
                String name = data.get(0);

                try {
                    database.Connect();
                    factoryProxy.Delete(name);
                    database.Delete("factories", "company_name", name);

                } catch (Exception ex) {
                    logger.warn("Delete failed due to error: " + ex.getMessage());
                }
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    database.Connect();
                    factoryProxy.ListAll();
                    database.SelectAll("factories");
                } catch (Exception ex) {
                    logger.warn("Select failed due to error: " + ex.getMessage());                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<String> data = getTextFieldContent();
                    database.Connect();
                    factoryProxy.Update((Integer) spId.getValue(),
                            data.get(0), data.get(1), data.get(2));
                    logger.info("Record updated successfully!");
                } catch (Exception ex) {
                    logger.warn("Update failed due to error: " + ex.getMessage());
                }
            }
        });
    }

    public static void showWindow()
    {
        JFrame frame = new JFrame("Factories");
        frame.setContentPane(new Factories().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // kezdésnél középen jelenik meg az ablak
    }
}
