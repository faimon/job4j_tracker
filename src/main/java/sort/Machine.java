package sort;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int oddMoney = money - price;
        int num = 0;
        for (int i = 0; i < COINS.length; i++) {
            while (oddMoney - COINS[i] >= 0) {
                oddMoney -= COINS[i];
                rsl[num++] = COINS[i];
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}