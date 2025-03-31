package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_2573 { //백준 2573
    static int N, M ,year = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, ch;

    static void DFS1(int x, int y) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) { //주위에 바다 몇개인가
                count++;
            }
        }

        board[x][y] = Math.max(0, board[x][y] - count);
    }
    static void DFS2(int x, int y) {
        ch[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx < N - 1 && ny >= 1 && ny < M - 1 && board[nx][ny] > 0 && ch[nx][ny] == 0) { //육지로 갈수 있는가
                DFS2(nx, ny);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (true) {
            int count = 0;
            ch = new int[N][M];

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (board[i][j] > 0 && ch[i][j] == 0) {
                        DFS2(i, j); // 육지 덩어리 갯수
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }
            if (count >= 2) {
                System.out.println(year);
                return;
            }


            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (board[i][j] > 0) {
                        DFS1(i, j); // 얼음녹이기
                    }
                }
            }
            year++;
        }
    }
}

/*
DFS1 메서드는 현재 칸에서 주위 바다의 개수를 계산하고, 그 값을 이용해 현재 칸의 빙산 높이를 감소시킵니다.
 하지만 이 과정이 모든 빙산 칸에 대해 동시에 처리되지 않고, 순차적으로 처리됩니다.
 그러므로 어떤 빙산 칸이 먼저 감소하고 나면, 이후 인접한 빙산 칸들이 영향을 받아 잘못된 결과를 도출할 수 있습니다.
이 문제를 해결하려면, 한 해 동안 모든 빙산의 녹는 양을 계산한 후에 한 번에 적용해야 합니다.
 */
