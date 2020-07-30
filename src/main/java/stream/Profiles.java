package stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profiles {
    private Address address;

    public static List<Address> collect(List<Profiles> profiles) {
        Comparator<Address> compByCity = (left, right) -> left.getCity().compareTo(right.getCity());
        List<Address> rsl = profiles.stream()
                .map(profiles1 -> profiles1.address)
                .sorted(compByCity)
                .distinct()
                .collect(Collectors.toList());
        return rsl;
    }
}

