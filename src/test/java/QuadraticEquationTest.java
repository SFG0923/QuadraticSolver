

import org.example.QuadraticEquation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    @DisplayName("Должно быть два корня при D > 0")
    void testTwoRoots() {
        QuadraticEquation eq = new QuadraticEquation(1, -5, 6);
        double[] roots = eq.solve();

        assertEquals(2, roots.length, "Должно быть ровно 2 корня");
        assertTrue(roots[0] == 3 || roots[1] == 3);
        assertTrue(roots[0] == 2 || roots[1] == 2);
    }

    @Test
    @DisplayName("Должен быть один корень при D = 0")
    void testOneRoot() {
        QuadraticEquation eq = new QuadraticEquation(1, -4, 4);
        double[] roots = eq.solve();

        assertEquals(1, roots.length, "Должен быть ровно 1 корень");
        assertEquals(2.0, roots[0], 0.0001);
    }

    @Test
    @DisplayName("Массив должен быть пустым при D < 0")
    void testNoRoots() {
        QuadraticEquation eq = new QuadraticEquation(1, 1, 1);
        double[] roots = eq.solve();

        assertEquals(0, roots.length, "Массив корней должен быть пустым");
    }

    @Test
    @DisplayName("Должно выбрасываться исключение, если a = 0")
    void testInvalidCoefficientA() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new QuadraticEquation(0, 2, 3);
        });

        String expectedMessage = "Коэффициент 'a' не может быть равен 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Проверка корней с отрицательными коэффициентами")
    void testNegativeCoefficients() {

        QuadraticEquation eq = new QuadraticEquation(-1, 2, 3);
        double[] roots = eq.solve();

        assertEquals(2, roots.length);
        double sum = roots[0] + roots[1];
        assertEquals(2.0, sum, 0.0001);
    }
}