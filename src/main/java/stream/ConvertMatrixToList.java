package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertMatrixToList {
    public static void main(String[] args) {
        Integer[][] massiv = new Integer[2][2];
        massiv[0][0] = 1;
        massiv[0][1] = 2;
        massiv[1][0] = 3;
        massiv[1][1] = 4;
        List<Integer> list = convert(massiv);
        System.out.println(list);
    }

    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());
    }
}
