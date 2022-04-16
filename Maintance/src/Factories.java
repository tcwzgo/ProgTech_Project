import javax.swing.*;

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

    public static void showWindow()
    {
        JFrame frame = new JFrame("Factories");
        frame.setContentPane(new Factories().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600, 400);
    }
}
