package collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov1@mail.ru", "Ivanov1 Ivan");
        map.put("ivanov2@mail.ru", "Ivanov2 Ivan");
        map.put("ivanov3@mail.ru", "Ivanov3 Ivan");
        for (String key: map.keySet()) {
            System.out.println(key);
        }
    }
}
