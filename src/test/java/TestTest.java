import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTest {



    @Test
    void calk() {
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 3;
        int rez = calculator.sum(a, b);
        assertEquals(5, rez);
    }

    @Test
    void badCalk() {
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 3;
        int rez = calculator.sum(a, b);
        assertEquals(6, rez);
    }

}
