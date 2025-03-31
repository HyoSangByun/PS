package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_17070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][][] dp = new int[N][N][3];  // 0=가로, 1=세로, 2=대각

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][1][0] = 1;  // 최초 상태
        for(int i = 0; i < N; i++) {
            for(int j = 2; j < N; j++) {
                if(j - 1 >= 0 && arr[i][j] == 0) {  // 가로
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                if(i - 1 >= 0 && arr[i][j] == 0) {  // 세로
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                if(i-1 >= 0 && j-1 >= 0 && arr[i][j] == 0 && arr[i-1][j] == 0 && arr[i][j-1] == 0) {  // 대각
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        int ans = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(ans);
    }
}
