package collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("Toyota");
        autos.add("BMW");
        autos.add("Volvo");
        for (String auto: autos
             ) {
            System.out.println(auto);
        }

    }
}
