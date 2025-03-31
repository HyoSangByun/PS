package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11051 {
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (j == 0 || i == j) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[N][K] % MOD);
    }

}
/*
     n C k = n - 1 C k -1 + n - 1 C k
     k 가 0 이거나 n이면 1 반환
 */