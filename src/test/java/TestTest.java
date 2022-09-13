import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTest {

    // ax^2 + bx + c = 0
    // D = b^2 - 4ac
    @Test
    public void checkAEqualsZero() {
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class, () -> {
            calculator.solve(0.000001, Mockito.anyDouble(), Mockito.anyDouble());
        });
    }

    @Test
    public void checkDLessThanZero() {
        Calculator calculator = new Calculator();
        double[] solve = calculator.solve(1, 0, 1);
        assertEquals(0, solve.length);
    }

    @Test
    public void checkDEqualZero() {
        Calculator calculator = new Calculator();
        double[] solve = calculator.solve(1, 2, 1);
        assertEquals(1, solve.length);
        assertEquals(-1, solve[0]);
    }

    @Test
    public void checkDMoreThanZero() {
        Calculator calculator = new Calculator();
        double[] solve = calculator.solve(1, 0, -1);
        assertEquals(2, solve.length);
        assertEquals(-1, solve[0]);
        assertEquals(1, solve[1]);
    }

    @Test
    public void checkIfDoubleOutOfRange() {
        Calculator calculator = new Calculator();
        double infinity = Math.pow(10, 309);
        double[] solve = calculator.solve(infinity, 2, 2);
        assertEquals(0, solve.length);
        solve = calculator.solve(2, infinity, 2);
        assertEquals(0, solve.length);
        solve = calculator.solve(2, 2, infinity);
        assertEquals(0, solve.length);
        solve = calculator.solve(2, Math.pow(10, 155), 2);
        assertEquals(0, solve.length);
    }

}
