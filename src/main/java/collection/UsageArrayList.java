package collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Petr");
        list.add("Ivan");
        list.add("Stepan");
        for (String st: list) {
            System.out.println(st);
        }
    }
}
