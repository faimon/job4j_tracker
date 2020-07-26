package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> listAcc = users.get(user);
        if (!listAcc.contains(account)) {
            listAcc.add(account);
            users.put(user, listAcc);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User acc: users.keySet()) {
            if (acc.getPassport().equals(passport)) {
                user = acc;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account acc: list) {
                if (acc.getRequisite().equals(requisite)) {
                    account = acc;
                    break;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, dеstRequisite);
        if ((srcAcc != null || destAcc != null) && srcAcc.getBalance() >= amount) {
            destAcc.setBalance(destAcc.getBalance() + amount);
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
