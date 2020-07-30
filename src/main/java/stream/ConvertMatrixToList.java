package stream;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertMatrixToList {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        List<Integer> list = convert(matrix);
        System.out.println(list);
    }

    public static List<Integer> convert(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
    }
}
