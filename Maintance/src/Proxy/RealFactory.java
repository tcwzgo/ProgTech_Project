package Proxy;

import java.util.ArrayList;

public class RealFactory extends Item {

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
        if (!(companyName.length() > 5)) {
            this.companyName = companyName;
        } else {
            System.out.println("The name must be at least 5 characters long!");
        }
    }
    private void setAddress(String address) {
        this.address = address;
    }
    private void setDateOfInstitution(String dateOfInstitution) {
        if (!(dateOfInstitution.matches("[a-zA-Z]+"))) {
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
        for (int i = 0; i < factories.size(); i++) {
            if (factories.get(i).getCompanyName().equals(companyName)) {
                factories.remove(i);
            }
        }
    }
    @Override
    public void Add(RealFactory factory) {
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
}
