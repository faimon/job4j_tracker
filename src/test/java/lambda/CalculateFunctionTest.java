package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CalculateFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CalculateFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = CalculateFunction.diapason(1, 4, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D, 16D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenOtherFunction() {
        List<Double> result = CalculateFunction.diapason(1, 4, x -> 2 * x);
        List<Double> expected = Arrays.asList(2D, 4D, 6D, 8D);
        assertThat(result, is(expected));
    }
}