package stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    private Address address;

    public static List<Address> collect(List<Profiles> profiles) {
        List<Address> rsl = profiles.stream()
                .map(profiles1 -> profiles1.address)
                .collect(Collectors.toList());
        return rsl;
    }
}

