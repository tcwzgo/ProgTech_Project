import javax.swing.*;

public class Factories {
    private JPanel Main;


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
    }
}
