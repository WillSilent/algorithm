package day2_string;

import java.util.Arrays;

public class Lc205 {
    //Isomorphic Strings
    // 重点两个字符串的字符需要相互对应，并不是每次字符出现的次数一致

    public boolean isIsomorphic(String s, String t) {
        int[] sArr = new int[256];
        Arrays.fill(sArr, -1);

        int[] tArr = new int[256];
        Arrays.fill(tArr, -1);

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(sArr[c1] == -1 && tArr[c2] == -1) {
                sArr[c1] = c2;
                tArr[c2] = c1;
            } else if(!(sArr[c1] == c2 && tArr[c2] == c1)) {
                return false;
            }
        }

        return true;
    }


}
