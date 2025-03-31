package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_2573_02 { //백준 2573
    static int N, M , year = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, ch;

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

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] > 0 && ch[i][j] == 0) {
                        DFS(i, j); //덩어리를 탐색하는 용도
                        count++;
                    }
                }
            }

            if (count == 0) { // 빙산이 전부 녹음
                System.out.println(0);
                return;
            }
            if (count >= 2) { // 빙산이 분리됨
                System.out.println(year);
                return;
            }

            meltIcebergs();
            year++;
        }
    }

    static void DFS(int x, int y) {
        ch[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] > 0 && ch[nx][ny] == 0) {
                DFS(nx, ny);
            }
        }
    }

    static void meltIcebergs() {
        int[][] newBoard = new int[N][M]; // 빙산 높이를 업데이트하기 위한 배열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                            count++;
                        }
                    }
                    newBoard[i][j] = Math.max(0, board[i][j] - count); // 빙산이 0 이하로 내려가지 않도록 처리
                }
            }
        }
        // 한번에 업데이트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
}
