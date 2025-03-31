package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_1012 { //백준 1012
    static int M, N, answer; //M이 배추밭의 가로길이, N이 배추밭의 세로길이
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static Scanner sc = new Scanner(System.in);
    static int solution(int K) {
        board = new int[N][M];
        answer = 0;

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            board[y][x] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    DFS(i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    static void DFS(int x, int y) {
        board[x][y]= 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 1) { //갈 수 있으면
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();

            System.out.println(solution(K));
        }
    }
}
