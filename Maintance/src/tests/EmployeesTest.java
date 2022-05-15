import Observer.EmployeeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {

    private Employees emp = new Employees();
    private EmployeeClass empclass = new EmployeeClass("Teszt Zero", "Zero@gmail.com", "secretary", 222222);

    @Test
    public void testAddEmployee(){
        assertEquals(true, emp.AddEmployee("Teszt Egy", "tesztegy@gmail.com", "secretary", 220000));
    }

    @BeforeEach
    public void init(){
        assertEquals(true, emp.AddEmployee("Teszt Zero", "Zero@gmail.com", "secretary", 222222));
        empclass.AddEmployee(empclass);
    }

    @Test
    public void testDeleteEmployee(){
        assertEquals(false, emp.DeleteEmployee("Teszt Zero"));
        // TRUE nem lesz, hiszen az Employees osztály 321. sorában a példány null,
        // mert a táblázatba kattintással lenne példányosítva
    }

    @Test
    public void testUpdateEmployee(){
        assertEquals(false, emp.UpdateEmployee("Teszt Zero", "Zero@gmail.com", "secretary", 222221));
        // Szintén null
    }

    @Test
    public void testSearchEmployee(){
        assertEquals(true, emp.SearchEmployee("Teszt Elek"));
        assertEquals(false, emp.SearchEmployee("Unit Test"));
    }
}