package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMapToDouble(pupil -> pupil.getSubjects()
                        .stream()
                        .mapToDouble(Subject::getScore))
                .average().orElse(-1);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return List.of();

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        int bestScore = stream
                .mapToInt(pupil -> pupil.getSubjects()
                        .stream()
                        .mapToInt(subj -> subj.getScore())
                        .sum())
                .max()
                .orElse(-1);
        Tuple rsl = new Tuple("Ivanov", bestScore);
        return rsl;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
