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
}
