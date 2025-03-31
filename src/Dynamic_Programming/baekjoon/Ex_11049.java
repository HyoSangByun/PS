package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][2];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[i][0] = first;
            arr[i][1] = second;
        }

        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = arr[i][0] * arr[i][1] * arr[i + 1][1];
        }

        for (int gap = 2; gap < N; gap++) {
            for (int i = 0; i + gap < N; i++) {
                int j = gap + i;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1]);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}
