package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("b task", 1),
                new Job("c task", 4),
                new Job("d task", 2),
                new Job("a task", 0)
        );
        Collections.sort(jobs, new JobReverseSortByName());
        for (Job job: jobs) {
            System.out.println(job);
        }
    }
}
