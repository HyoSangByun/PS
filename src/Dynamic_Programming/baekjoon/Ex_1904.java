package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1904 {
    static final int MOD = 15746;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % MOD;
        }

        System.out.println(dp[N] % MOD);
    }
}
/*
    1 : 1
    2 : 00, 11
    3 : 100, 111, 001
    4 : 0011, 0000, 1001, 1100, 1111
    5 : 10000, 00001, 00111, 10011, 11001, 11100, 11111, 00100
 */
