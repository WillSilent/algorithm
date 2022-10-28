package leetcode;

public class MiniP {

    public static void main(String[] args) {
        String expression = "999+999";
        minimizeResult(expression);
    }

    public static String minimizeResult(String expression) {
        int res = Integer.MAX_VALUE;
        int len = expression.length();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < len; i++) {
            for(int j = len+1; j > i + 1; j--) {
                StringBuilder s = new StringBuilder(expression);
                s.insert(i, '(');
                s.insert(j, ')');

                System.out.println(s.toString());
            }
        }




        return result.toString();
    }



}
