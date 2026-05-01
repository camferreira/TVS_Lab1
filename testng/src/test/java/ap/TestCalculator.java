package ap;
 
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;

@Test 
public class TestCalculator {
    
    @DataProvider
    private Object[][] computeDataForValidCtor() {
        return new Object[][] {
            {"12"},
            {"123"},
            {"12345"}};
    }
    @Test(dataProvider = "computeDataForValidCtor")
    public void testConstructorValidName(String name) {
        Calculator c = new Calculator(name);
        
        assertEquals(c.getName(), name);
        assertEquals(c.getNumberOfOperations(), 0);
    }

    @DataProvider
    private Object[][] computeInvalideDataForCtor() {
        return new Object[][] {
            {"1"},
            {""},
            {null},
            {"123456"}};
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "computeInvalideDataForCtor")
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
    public void testSum_TwoNonNullIntegers(){
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

    @Test
    public void testDivide_TwoValidIntegers() {
        Calculator c = new Calculator("Calc");
        assertEquals(c.divide(4, 2), Integer.valueOf(2));
        assertEquals(c.getNumberOfOperations(), 1);
    }

    @Test
    public void testDivide_NullDividend() {
        Calculator c = new Calculator("Calc");
        assertEquals(c.divide(null, 2), Integer.valueOf(0));
        assertEquals(c.getNumberOfOperations(), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivide_ByZero() {
        Calculator c = new Calculator("Calc");
        try {
            c.divide(2, 0);
        } finally {
            assertEquals(c.getNumberOfOperations(), 0);
        }
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivide_NullDivisor() {
        Calculator c = new Calculator("Calc");
        try {
            c.divide(2, null);
        } finally {
            assertEquals(c.getNumberOfOperations(), 0);
        }
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivide_TwoNullIntegers() {
        Calculator c = new Calculator("Calc");
        try {
            c.divide(null, null);
        } finally {
            assertEquals(c.getNumberOfOperations(), 0);
        }
    }
}
