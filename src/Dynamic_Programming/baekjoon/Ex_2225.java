package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_2225 {
    static final int MOD = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[N + 1][K + 1];

        //초기화
        for (int i = 1; i < N + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < K + 1; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 2; j < K + 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}
