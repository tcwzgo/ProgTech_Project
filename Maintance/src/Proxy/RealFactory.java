package Proxy;

import java.util.ArrayList;

public class RealFactory extends Item {

    // fields
    protected String companyName;
    protected String address;
    protected String dateOfInstitution;
    protected ArrayList<RealFactory> factories = new ArrayList<>();

    // Getters
    private String getCompanyName() {
        return this.companyName;
    }
    private String getAddress() {
        return this.address;
    }
    private String getDateOfInstitution() {
        return this.dateOfInstitution;
    }

    // Setters
    private void setCompanyName(String companyName) {
        if (companyName.length() >= 5) {
            this.companyName = companyName;
        } else {
            System.out.println("The name must be at least 5 characters long!");
        }
    }
    private void setAddress(String address) {
        this.address = address;
    }
    private void setDateOfInstitution(String dateOfInstitution) {
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
            for (int i = 0; i < factories.size(); i++) {
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
    public void Update(int id, String companyName, String address, String dateOfInstitution) throws Exception {
        RealFactory selectedFactory = factories.get(id);
        if (!(selectedFactory == null)) {
            selectedFactory.setCompanyName(companyName);
            selectedFactory.setAddress(address);
            selectedFactory.setDateOfInstitution(dateOfInstitution);
        } else {
            throw new Exception(String.format("The specified factory doesn't exist. ID: %d", id));
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
