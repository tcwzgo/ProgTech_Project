import Proxy.FactoryProxy;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static void main(String[] args) {
        showWindow();
    }

    private static Logger logger = Logger.getLogger(Employees.class);
    private static DBConnect database = new DBConnect("maintance");
    private FactoryProxy factoryProxy;

    public Factories() {

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
