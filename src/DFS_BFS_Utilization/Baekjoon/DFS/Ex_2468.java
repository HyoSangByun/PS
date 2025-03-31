package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_2468 { //백준 2468
    static int N, count, min = Integer.MAX_VALUE, answer, max = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N][N];
        answer = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nextInt = sc.nextInt();
                board[i][j] = nextInt;

                min = Math.min(min, nextInt);
                max = Math.max(max, nextInt);
            }
        }

        for (int i = min; i < max; i++) {
            count = 0;
            ch = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][k] > i && ch[j][k] == 0) {
                        count++;
                        DFS(j, k, i);
                    }
                }
            }

            answer = Math.max(count, answer);
        }


        System.out.println(answer);
    }

    static void DFS(int x, int y, int L) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] > L && ch[nx][ny] == 0) { //갈 수 있으면
                ch[nx][ny] = 1;
                DFS(nx, ny, L);
            }
        }
    }
}
