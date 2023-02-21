package day2_string;

public class Lc14 {

    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];

        for(int i = 1; i < strs.length; i++) {
            res = getPrefix(res, strs[i]);
        }

        return res;
    }

    public String getPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < len; i ++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                res.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return res.toString();
    }



}
