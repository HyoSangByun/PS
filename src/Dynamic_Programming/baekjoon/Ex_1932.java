package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int nextInt = sc.nextInt();
                arr[i][j] = nextInt;
                if (i== N -1) dp[i][j] = nextInt;
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + arr[i][j];
            }
        }

        System.out.println(dp[0][0]);
    }

}
