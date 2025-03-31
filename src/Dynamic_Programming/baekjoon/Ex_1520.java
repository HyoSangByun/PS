package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1520 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M, N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //세로
        N = sc.nextInt(); //가로
        arr = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0)); // 출발 지점

        System.out.println();
        //dp 배열 출력
        for (int i = 0; i < M; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j] + " ");
            }
        }
    }


    private static int DFS(int x, int y) {

        // 도착지점까지 도달했을 경우
        if (x == M-1 && y == N-1) return 1;

        // 방문한 적이 없는 경우
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1) continue;

                // 내리막 길인 경우
                if (arr[x][y] > arr[nx][ny]) {
                    dp[x][y] += DFS(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}
