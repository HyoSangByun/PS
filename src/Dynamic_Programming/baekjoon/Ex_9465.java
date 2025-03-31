package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_9465 {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            arr = new int[2][N + 1];

            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            int[][] dp = new int[2][N + 1];
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }

}
