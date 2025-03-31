package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_10844_02 { //Bottom-up 방식 (반복문)
    final static long MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][] dp = new long[N + 1][10]; //경우의수를 기록해둠

        // 첫번째 자리수(일의 자리)는 경우의 수가 1이므로 1로 초기화
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        //두번째 자릿수부터 N까지 탐색
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                // j=0이라면 즉 자리값이 0이라면 이전 자리수의 첫 번째 자릿수만 가능
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % MOD;
                }
                // j=9이라면 즉 자리값이 9라면 이전 자리수는 8만 가능
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;

        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % MOD);
    }
}
/*
    1 : 9
    2 : 17
    3 : 26
    ...
 */