package String;

import java.util.Scanner;

public class Ex_5525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int length = sc.nextInt();
        String S = sc.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * N + 1; i++) {
            if (i % 2 == 0) {
                sb.append('I');
            } else {
                sb.append('O');
            }
        }

        String Sn = sb.toString();
        int Sn_length = Sn.length();
        int answer = 0;
        for (int i = 0; i <= length - Sn_length; i++) {
            if (S.substring(i, Sn_length + i).equals(Sn)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
