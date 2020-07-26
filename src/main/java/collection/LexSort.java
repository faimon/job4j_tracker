package collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] buff1 = o1.split("\\.");
        String[] buff2 = o2.split("\\.");
        for (int i = 0; i < Math.min(buff1.length - 1, buff2.length - 1); i++) {
            int check = Integer.compare(Integer.parseInt(buff1[i]), Integer.parseInt(buff2[i]));
            if (check != 0) {
                return check;
            }
        }
        return 0;
    }
}
