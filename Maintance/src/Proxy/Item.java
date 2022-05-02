package Proxy;

abstract public class Item {
    public abstract void ListAll();
    public abstract void Delete(String companyName);
    public abstract void Add(String name, String addr, String dOInst);
    public abstract void Update(int id, String companyName, String address, String dateOfInstitution)
            throws Exception;
}
