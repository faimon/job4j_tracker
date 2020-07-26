package collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenSortByName() {
        Comparator<Job> sortByName = new JobSortByName();
        int rsl = sortByName.compare(
                new Job("b", 1),
                new Job("a", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenReverseSortByName() {
        Comparator<Job> sortByName = new JobReverseSortByName();
        int rsl = sortByName.compare(
                new Job("b", 1),
                new Job("a", 1)
        );
        assertThat(rsl, is(-1));
    }

    @Test
    public void whenSortByPrioprity() {
        Comparator<Job> sortByName = new JobSortByPriority();
        int rsl = sortByName.compare(
                new Job("b", 2),
                new Job("a", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenReverseSortByPrioprity() {
        Comparator<Job> sortByName = new JobReverseSortByPriority();
        int rsl = sortByName.compare(
                new Job("b", 2),
                new Job("a", 1)
        );
        assertThat(rsl, is(-1));
    }

    @Test
    public void whenReverseNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobReverseSortByName().thenComparing(new JobReverseSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("a task", 0),
                new Job("a task", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenSortNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobReverseSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("a task", 0),
                new Job("a task", 1)
        );
        assertThat(rsl, is(-1));
    }
}