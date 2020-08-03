package stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMapToDouble(pupil -> pupil.getSubjects()
                        .stream()
                        .mapToDouble(Subject::getScore))
                .average().orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.
                map(pupil -> {
                    double avg = pupil.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .average().orElse(0);
                    return new Tuple(pupil.getName(), avg);
                })
                .collect(Collectors.toList());

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> {
                    double sum = p.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .sum();
                    return new Tuple(p.getName(), sum);
                })
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
