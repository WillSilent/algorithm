package day2_string;

public class Lc43 {

    public static void main(String[] args) {
        String s1 = "1234";
        int r = Integer.parseInt(s1, 0, 1, 10);
        int r2 = Integer.parseInt(s1, 1, 2, 10);
        int r4 = Integer.parseInt(s1, 3, 4, 10);
        System.out.println(r4);
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int N = len1 + len2;

        int[] product = new int[N];

        for(int i = len1 - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';

            for(int j = len2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int idx = i + j + 1;

                int p = a * b + product[idx];
                product[idx] = p % 10;
                product[idx - 1] += p / 10;
            }
        }

        int start = product[0] != 0 ? 0 : 1;
        StringBuilder res = new StringBuilder();
        for(int i = start; i < N; i++) {
            res.append(product[i]);
        }

        return res.toString();
    }



}
