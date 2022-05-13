package Observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeClass {
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        if (n.length() < 5)
        {
            JOptionPane.showMessageDialog(null, "The length of the name must be at least five character!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.name = n;
        }
    }

    private String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        if (e.length() < 10)
        {
            JOptionPane.showMessageDialog(null, "The length of the email must be at least ten character!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else if (!e.contains("@"))
        {
            JOptionPane.showMessageDialog(null, "Email must contain '@'!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            this.email = e;
        }
    }

    private String post;

    public String getPost()
    {
        return post;
    }

    public void setPost(String p)
    {
        if (p.length() < 3)
        {
            JOptionPane.showMessageDialog(null, "The length of the post must be at least three characters!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.post = p;
        }
    }

    private int salary;

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int s)
    {
        if (s < 120000 || s > 1000000)
        {
            JOptionPane.showMessageDialog(null, "The salary must be in [120000;1000000] range!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.salary = s;
            notifyAllObservers();
        }
    }

    public EmployeeClass(String name, String email, String post, int salary)
    {
        if (name.length() < 5)
        {
            JOptionPane.showMessageDialog(null, "The length of the name must be at least five character!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.name = name;
        }

        if (email.length() < 10)
        {
            JOptionPane.showMessageDialog(null, "The length of the email must be at least ten character!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else if (!email.contains("@"))
        {
            JOptionPane.showMessageDialog(null, "Email must contain '@'!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            this.email = email;
        }

        if (post.length() < 3)
        {
            JOptionPane.showMessageDialog(null, "The length of the post must be at least three characters!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.post = post;
        }

        if (salary < 120000 || salary > 1000000)
        {
            JOptionPane.showMessageDialog(null, "The salary must be in [120000;1000000] range!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.salary = salary;
        }
    }

    private List<Observer> observers = new ArrayList<Observer>();

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.sendMessage();
        }
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    private ArrayList<EmployeeClass> employees = new ArrayList<EmployeeClass>();

    public void AddEmployee(EmployeeClass e)
    {
        if (!e.equals(null))
        {
            employees.add(e);
        }
    }

    public void ListEmployees()
    {
        for(int i = 0; i < employees.size(); i++)
        {
            System.out.println(employees.get(i).getName() + " " + employees.get(i).getEmail() + " " + employees.get(i).getPost()+ " " + employees.get(i).getSalary()) ;
        }
    }

    public void DeleteByName(String name)
    {
        for(int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getName() == name)
            {
                employees.remove(i);
            }
        }
    }
}
