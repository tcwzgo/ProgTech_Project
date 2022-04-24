package Proxy;

abstract public class Item {
    public abstract void ListAll();
    public abstract void Delete(String companyName);
    public abstract void Add(RealFactory factory);
    public abstract void Update(int id, String companyName, String address, String dateOfInstitution)
            throws Exception;
}
