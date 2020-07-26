package collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNum() {
        String[] input = {
                "10.1.5 Task.",
                "1. Task.",
                "2.11. Task.",
                "2.10. Task."
        };
        String[] out = {
                "1. Task.",
                "2.10. Task.",
                "2.11. Task.",
                "10.1.5 Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}