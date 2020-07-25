package collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        String pass = citizen.getPassport();
        if (!citizens.containsKey(pass)) {
            citizens.put(pass, citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen citizen = null;
        if (citizens.containsKey(passport)) {
            citizen = citizens.get(passport);
        }
        return citizen;
    }
}
