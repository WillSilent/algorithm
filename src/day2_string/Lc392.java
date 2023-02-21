package day2_string;

public class Lc392 {

    //题解有很多种答案，双指针最简单又易懂
    public boolean isSubsequence(String s, String t) {
        int left = 0, right = 0;

        while(left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                left ++;
            }

            right ++;
        }

        return left == s.length();
    }


}
