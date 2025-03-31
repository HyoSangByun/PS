package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11057 {
    static final int MOD = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[N + 2][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 0; i < N + 2; i++) {
            dp[i][9] = 1;
        }

        for (int i = 2; i <= N + 1; i++) {
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % MOD;
            }
        }


//        if (N == 1) System.out.println(10);
        System.out.println(dp[N + 1][0] % MOD);
    }
}

/*
    https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FUJ3Be%2FbtqX0poPjMC%2F8fKmQUnYB2mmUGIqVMUSMK%2Fimg.png
 */