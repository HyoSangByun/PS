package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_17626 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        dp[1] = 1;

        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int tmp = i - j*j;
                min = Math.min(min, dp[tmp]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[N]);
    }

}

/*
    dp[n]은 n을 만들 수 있는 최소 개수의 제곱수의 합
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = 1;
    dp[5] = 2;
    dp[6] = 3;
    dp[7] = 4;
    dp[8] = 2;
    dp[9] = 1;
 */