package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] dp = new int[30][30];

        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(dp[B][A]);
        }
    }
}
