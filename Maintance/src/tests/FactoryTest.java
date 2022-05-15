package tests;
import Proxy.RealFactory;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FactoryTest {

    private ArrayList<RealFactory> factories = new ArrayList<>();

    @Before
    public void init() {
        factories.add(new RealFactory("SomeName1", "SomeAddress1", "1111,11,11"));
        factories.add(new RealFactory("SomeName2", "SomeAddress2", "2222,22,22"));
        factories.add(new RealFactory("SomeName3", "SomeAddress3", "3333,33,33"));
    }

    @Test
    public void testGetSize() {
        assertEquals("Checking size of list.", 3, factories.size());
    }

    @Test
    public void testAdd() {
        factories.add(new RealFactory("SomeName4", "SomeAddress4", "4444,44,44"));
        assertEquals("Checking size of list.", 4, factories.size());
    }

    @Test
    public void testRemove() {
        factories.remove(1);
        assertEquals("Removed and element from the list.", 3, factories.size());
    }

    @Test
    public void testUpdate() throws Exception {
        factories.get(1).Update(1, "SomeNewName", "SomeNewAddress", "9999,99,99");
        assertEquals("Updated an element in the list.", 4, factories.size());
    }
}
