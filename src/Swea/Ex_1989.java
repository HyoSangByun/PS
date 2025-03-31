package Swea;

import java.util.Scanner;

public class Ex_1989 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= T; i++) {
            String input = sc.nextLine().trim();
            StringBuilder sb = new StringBuilder(input);
            String reverse = sb.reverse().toString();

            if (reverse.equals(input)) {
                System.out.println("#" + i + " " + 1);
            }
            else {
                System.out.println("#" + i + " " + 0);
            }
        }
    }

}
