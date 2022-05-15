import Observer.EmployeeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeClassTest {

    EmployeeClass test1 = new EmployeeClass("Teszt Egy", "tesztegy@gmail.com", "cleaner", 175000);
    EmployeeClass test2 = new EmployeeClass("Teszt Kettő", "tesztketto@gmail.com", "cleaner", 175000);

    @Test
    public void testGetName() {
        assertEquals("Teszt Egy", test1.getName());
    }

    @Test
    public void testSetName(){
        test1.setName("Teszt Módosított");
        assertEquals("Teszt Módosított", test1.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("tesztegy@gmail.com", test1.getEmail());
    }

    @Test
    public void testSetEmail() {
        test1.setEmail("tesztegymodositott@gmail.com");
        assertEquals("tesztegymodositott@gmail.com", test1.getEmail());
    }

    @Test
    public void testGetPost() {
        assertEquals("cleaner", test1.getPost());
    }

    @Test
    public void testSetPost() {
        test1.setPost("secretary");
        assertEquals("secretary", test1.getPost());
    }

    @Test
    public void testGetSalary() {
        assertEquals(175000, test1.getSalary());
    }

    @Test
    public void testSetSalary() {
        test1.setSalary(200000);
        assertEquals(200000, test1.getSalary());
    }

    @Test
    public void testAddEmployee(){
        test1.AddEmployee(new EmployeeClass("Teszt Kettő", "tesztketto@gmail.com", "cleaner", 175000));
        assertEquals(1, test1.Size());
    }

    @BeforeEach
    public void init(){
        test1.AddEmployee(test1);
        test1.AddEmployee(test2);
    }

    @Test
    public void testSize(){
        assertEquals(1, test1.Size());
    }

    @Test
    public void testDeleteByName() {
        test1.DeleteByName("Teszt Egy");
        assertEquals(1, test1.Size());
    }
}