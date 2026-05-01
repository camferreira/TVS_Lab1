package ap;
 
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;

@Test
public class TestCalculator {
    @Test
    public void testConstructorValidName() {
        Calculator c = new Calculator("Calc");
        assertEquals(c.getName(), "Calc");
        assertEquals(c.getNumberOfOperations(), 0);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorNullName() {
        new Calculator(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorTooShortName() {
        new Calculator("C");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorTooLongName() {
        new Calculator("Calcul");
    }

    @Test
    public void testSum_TwoNonNullIntegeres(){
        Calculator c = new Calculator("Calc");
        assertEquals(c.sum(2, 3), Integer.valueOf(5));
        assertEquals(c.getNumberOfOperations(), 1);
    }

    @Test
    public void testSum_NullA(){
        Calculator c = new Calculator("Calc");
        assertEquals(c.sum(null, 2), Integer.valueOf(2));
        assertEquals(c.getNumberOfOperations(), 1);
    }

    @Test
    public void testSum_NullB(){
        Calculator c = new Calculator("Calc");
        assertEquals(c.sum(2, null), Integer.valueOf(2));
        assertEquals(c.getNumberOfOperations(), 1);
    }    

    @Test
    public void testSum_TwoNullNumbers(){
        Calculator c = new Calculator("Calc");
        assertEquals(c.sum(null, null), Integer.valueOf(0));
        assertEquals(c.getNumberOfOperations(), 1);
    } 
}
