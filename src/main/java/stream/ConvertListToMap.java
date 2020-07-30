package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 5),
                new Student("Alexandrov", 2),
                new Student("Vasilev", 4)
                );
        Map<String, Student> map = convert(students);
        System.out.println(map);
    }

    public static Map<String, Student> convert(List<Student> students) {
        return students.stream().collect(
                Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student));
    }
}
