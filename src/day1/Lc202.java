package day1;

import java.util.HashSet;
import java.util.Set;

public class Lc202 {

    public int getNext(int n) {
        int totalSum = 0;
        while(n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        // 为了防止出现死循环，需要把出现过的数字记录下来
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
