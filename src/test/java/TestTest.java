import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTest {

    @Test
    public void aEqualsZero() {
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class, () -> calculator.solve(0.000001, Mockito.anyDouble(), Mockito.anyDouble()));
    }

    @Test
    public void dLessThanZero() {
        Calculator calculator = new Calculator();
        double[] solve = calculator.solve(1, 0, 1);
        assertEquals(0, solve.length);
    }

    @Test
    public void dEqualZero() {
        Calculator calculator = new Calculator();
        double[] solve = calculator.solve(0.00001, 0.000021, 0.00001);
        assertEquals(1, solve.length);
        assertEquals(-1.0499999999999998, solve[0]);
    }

    @Test
    public void dMoreThanZero() {
        Calculator calculator = new Calculator();
        double[] solve = calculator.solve(1, 0, -1);
        assertEquals(2, solve.length);
        assertEquals(-1, solve[0]);
        assertEquals(1, solve[1]);
    }

    @Test
    public void doubleIsInfinity() {
        Calculator calculator = new Calculator();
        double infinity = POSITIVE_INFINITY;
        assertThrows(RuntimeException.class, () -> calculator.solve(infinity, 2, 2));
        assertThrows(RuntimeException.class, () -> calculator.solve(2, infinity, 2));
        assertThrows(RuntimeException.class, () -> calculator.solve(2, 2, infinity));
        assertThrows(RuntimeException.class, () -> calculator.solve(2, Math.pow(10, 155), 2));
    }

    @Test
    public void doubleIsNaN() {
        Calculator calculator = new Calculator();
        double naN = Double.NaN;
        assertThrows(RuntimeException.class, () -> calculator.solve(naN, 2, 2));
        assertThrows(RuntimeException.class, () -> calculator.solve(2, naN, 2));
        assertThrows(RuntimeException.class, () -> calculator.solve(2, 2, naN));
    }

}
