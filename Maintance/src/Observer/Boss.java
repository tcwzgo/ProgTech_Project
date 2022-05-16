package Observer;

import javax.swing.*;

public class Boss implements Observer{

    private EmployeeClass emp;

    public Boss(EmployeeClass employee)
    {
        this.emp = employee;
        this.emp.addObserver(this);
    }

    @Override
    public void sendMessage() {
        JOptionPane.showMessageDialog(null, "Your boss has been notified about changing " + emp.getName() + "'s salary.", "Warning!", JOptionPane.WARNING_MESSAGE);
    }
}
