package Dynamic_Programming.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1890 {
    static int[][] arr;
    static long[][] dp;  // 경로의 수를 저장하는 dp 배열, 값이 클 수 있으니 long 타입 사용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;  // 시작점에서의 경로는 1

        // DP를 사용하여 경로 수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 현재 위치에서 점프할 수 있는 칸 수
                int jump = arr[i][j];
                if (jump == 0) continue;  // 0이면 더 이상 진행할 수 없음

                // 아래쪽으로 이동 가능할 경우
                if (i + jump < N) {
                    dp[i + jump][j] += dp[i][j];
                }

                // 오른쪽으로 이동 가능할 경우
                if (j + jump < N) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }
        
        // 오른쪽 아래 칸에 도달할 수 있는 경로의 수 출력
        System.out.println(dp[N - 1][N - 1]);
    }
}
