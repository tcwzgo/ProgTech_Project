import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Base {
    private JPanel Main;
    private JButton openEmployeesDBButton;
    private JButton openFactoriesDBButton;

    public Base() {
        openEmployeesDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employees emp = new Employees();
                emp.showWindow();
            }
        });
        openFactoriesDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Factories fact = new Factories();
                fact.showWindow();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Base");
        frame.setContentPane(new Base().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // kezdésnél középen jelenik meg az ablak
    }


}
