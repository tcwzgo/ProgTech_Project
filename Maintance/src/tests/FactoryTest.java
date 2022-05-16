package tests;
import Proxy.RealFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class FactoryTest {

    private final RealFactory factory = new RealFactory();

    @BeforeEach
    public void init() {
        factory.Add("SomeName1", "SomeAddress1", "1111,11,11");
        factory.Add("SomeName2", "SomeAddress2", "2222,22,22");
        factory.Add("SomeName3", "SomeAddress3", "3333,33,33");
    }

    @Test
    public void testGetCompanyName() {
        assertNotNull(factory.getFactories().get(1).getCompanyName());
    }

    @Test
    public void testGetAddress() {
        assertNotNull(factory.getFactories().get(1).getAddress());
    }

    @Test
    public void testGetDateOfInstitution() {
        assertNotNull(factory.getFactories().get(1).getDateOfInstitution());
    }

    @Test
    public void testGetFactories() {
        assertNotNull(factory.getFactories());
    }

    @Test
    public void testSetCompanyName() {
        factory.getFactories().get(1).setCompanyName("SomeNewCompanyName");
        assertEquals(3, factory.getSize());
    }

    @Test
    public void testSetDateOfInstitution() {
        factory.getFactories().get(1).setDateOfInstitution("9999,99,99");
        assertEquals(3, factory.getSize());
    }

    @Test
    public void testSetAddress() {
        factory.getFactories().get(1).setAddress("SomeNewAddress");
        assertEquals(3, factory.getSize());
    }

    @Test
    public void testListAll() {
        factory.ListAll();
        assertEquals(3, factory.getSize());
    }

    @Test
    public void testGetSize() {
        assertEquals("Checking size of list.", 3,  factory.getSize());
    }

    @Test
    public void testAdd() {
        factory.Add("SomeName4", "SomeAddress4", "4444,44,44");
        assertEquals("Checking size of list.", 4,  factory.getSize());
    }

    @Test
    public void testRemove() {
        factory.Delete("SomeName1");
        assertEquals("Removed and element from the list.", 2, factory.getSize());
    }

    @Test
    public void testUpdate() throws Exception {
        factory.Update("SomeName1", "SomeNewAddress", "9999,99,99");
        assertEquals("Updated an element in the list.", 3, factory.getSize());
    }
}
