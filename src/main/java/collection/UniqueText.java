package collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String st: origin) {
            check.add(st);
        }
        for (String stroka: text) {
            if (!check.contains(stroka)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
