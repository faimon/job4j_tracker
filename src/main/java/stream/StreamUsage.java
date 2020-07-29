package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = -5; i <= 5; i++) {
            list.add(i);
        }
        list = list.stream().filter(a -> a > 0).collect(Collectors.toList());
        System.out.println(list);
    }
}
