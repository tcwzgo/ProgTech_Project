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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Base");
        frame.setContentPane(new Base().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }


}
