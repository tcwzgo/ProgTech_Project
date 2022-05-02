package Proxy;

public class FactoryProxy extends Item {

    private RealFactory realFactory;

    @Override
    public void ListAll() {
        if (realFactory == null) { realFactory = new RealFactory(); }
        realFactory.ListAll();
    }

    @Override
    public void Delete(String companyName) {
        if (realFactory == null) { realFactory = new RealFactory(); }
        realFactory.Delete(companyName);
    }

    @Override
    public void Add(String name, String addr, String dOInst) {
        realFactory.Add(name, addr, dOInst);
    }

    @Override
    public void Update(int id, String companyName, String address, String dateOfInstitution)
            throws Exception {
        if (realFactory == null) { realFactory = new RealFactory(); }
        realFactory.Update(id, companyName, address, dateOfInstitution);
    }
}
