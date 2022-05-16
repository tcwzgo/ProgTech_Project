package Proxy;

import org.w3c.dom.ranges.RangeException;

import java.util.ArrayList;

public class RealFactory extends Item {

    // fields
    protected String companyName;
    protected String address;
    protected String dateOfInstitution;
    protected ArrayList<RealFactory> factories = new ArrayList<>();

    // Getters
    public int getSize() { return factories.size(); }
    public ArrayList<RealFactory> getFactories() { return this.factories; }
    public String getCompanyName() {
        return this.companyName;
    }
    public String getAddress() {
        return this.address;
    }
    public String getDateOfInstitution() {
        return this.dateOfInstitution;
    }

    // Setters
    public void setCompanyName(String companyName) {
        System.out.println(companyName.length());
        if (companyName.length() >= 5) {
            this.companyName = companyName;
        } else {
            System.out.println("The name must be at least 5 characters long!");
        }
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDateOfInstitution(String dateOfInstitution) {
        if (!(dateOfInstitution.matches("[a-zA-Z]"))) {
            this.dateOfInstitution = dateOfInstitution;
        } else {
            System.out.println("Date cannot contain alphabets!");
        }
    }

    // the body of the requests are defined here
    @Override
    public void ListAll() {
        for (RealFactory factory : factories) {
            System.out.println(factory.toString());
        }
    }
    @Override
    public void Delete(String companyName) {
        if (factories.size() == 0) {
            System.out.println("The list is empty! Nothing to delete!");
        }
        else {
            for (int i = 0; i < factories.size() - 1; i++) {
                if (factories.get(i).getCompanyName().equals(companyName)) {
                    factories.remove(i);
                }
                else {
                    System.out.println("No Factory with the specified name: " + companyName);
                }
            }
        }
    }
    @Override
    public void Add(String name, String addr, String dOInst) {
        RealFactory factory = new RealFactory(name, addr, dOInst);
        factories.add(factory);
    }
    @Override
    public void Update(String companyName, String address, String dateOfInstitution) throws Exception {

        RealFactory selectedFactory = null;

        for (RealFactory factory : factories) {
            if (factory.getCompanyName().equals(companyName)) {
                selectedFactory = factory;
            }
        }
        if (!(selectedFactory == null)) {
            selectedFactory.setCompanyName(companyName);
            selectedFactory.setAddress(address);
            selectedFactory.setDateOfInstitution(dateOfInstitution);
        } else {
            throw new Exception(String.format("The specified factory doesn't exist. companyName: %s", companyName));
        }
    }


    @Override
    public String toString() {
        return String.format("Company name: %s\nAddress: %s\nDate of institution: %s",
                this.companyName, this.address, this.dateOfInstitution);
    }

    public RealFactory(String companyName, String address, String dateOfInstitution) {
        setCompanyName(companyName);
        setAddress(address);
        setDateOfInstitution(dateOfInstitution);
    }
    public RealFactory() { }
}
