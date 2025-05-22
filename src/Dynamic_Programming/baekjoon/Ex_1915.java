package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1915 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        int ans = 0;
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                int input = s.charAt(j) - '0';
                map[i + 1][j + 1] = input;
                dp[i + 1][j + 1] = input;
                if (input == 1) ans = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && map[i - 1][j] == 1
                    && map[i][j - 1] == 1
                    && map[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans * ans);
    }
}

/*
입력
0 1 0 0
0 1 1 1
1 1 1 0
0 0 1 0

넓이
0 1 0 0
0 1 1 1
1 1 2 0
0 0 1 0
 */

