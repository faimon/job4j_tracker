package collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        char temp1;
        char temp2;
        int size = o1.length() <= o2.length() ? o1.length() : o2.length();
        for (int i = 0; i < size; i++) {
            temp1 = o1.charAt(i);
            temp2 = o2.charAt(i);
            if (temp1 != temp2) {
                return temp1 - temp2;
            }
        }
        return o1.length() - o2.length();
    }
}
