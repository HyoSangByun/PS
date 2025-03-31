package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        int[][] arr = new int[N][N];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int nextInt = sc.nextInt();
                if (j == 0) dp[i][j] = nextInt;
                else dp[i][j] = dp[i][j - 1] + nextInt;
            }
        }

        for (int i = 0; i < T; i++) {
            int[] pos = new int[4];
            for (int j = 0; j < 4; j++) {
                pos[j] = sc.nextInt();
            }

            int answer = 0;
            for (int j = pos[0]; j <= pos[2] ; j++) {
                answer += dp[j][pos[3]] - dp[j][pos[1] - 1];
            }
            System.out.println(answer);
        }


    }
}
