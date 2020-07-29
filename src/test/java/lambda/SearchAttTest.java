package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchAttTest {
    @Test
    public void whenFilterSize() {
        List<Attachment> list = Arrays.asList(
                new Attachment("bug smth", 12),
                new Attachment("A smth", 120),
                new Attachment("smth bug", 1200)
        );
        assertThat(SearchAtt.filterSize(list, 40),
                is(Arrays.asList(list.get(1), list.get(2))));
    }

    @Test
    public void whenFilterName() {
        List<Attachment> list = Arrays.asList(
                new Attachment("bug smth", 31),
                new Attachment("A smth", 140),
                new Attachment("smth bug", 1200)
        );
        assertThat(SearchAtt.filterName(list, "bug"),
                is(Arrays.asList(list.get(0), list.get(2)))
        );
    }
}