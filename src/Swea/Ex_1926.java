package Swea;

import java.util.Scanner;

public class Ex_1926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            String s = Integer.toString(i);
            int clapCount = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    clapCount++;
                }
            }

            if (clapCount > 0) {
                for (int j = 0; j < clapCount; j++) {
                    sb.append('-');
                }
            } else {
                sb.append(s);
            }

            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

}

/*

//        String answer = sb.toString();
        //

//        for (int i = 0; i < sb.length() - 1; i++) {
//            if (!Character.isDigit(sb.charAt(i)) && !Character.isDigit(sb.charAt(i + 1)) ) {
//                continue;
//            }
//            else {
//                sb.insert(i + 1, " ");
//            }
//        }
 */