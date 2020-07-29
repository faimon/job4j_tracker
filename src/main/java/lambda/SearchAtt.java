package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list, int value) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > value;
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list, String value) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(value);
            }
        };
        return filter(list, predicate);
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att: list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
