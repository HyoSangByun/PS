package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_1987_02 {
    static int N, M, answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[] visited = new boolean[30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];

        sc.nextLine(); //줄바꿈 처리!

        for (int i = 0; i < N; i++) {
            String next = sc.nextLine();
            for (int j = 0; j < next.length(); j++) {
                board[i][j] = next.charAt(j) - 'A';
            }
        }

        visited[board[0][0]] = true;
        DFS(0, 0, 0);

        System.out.println(answer + 1);
    }

    static void DFS(int x, int y, int distance) {
        answer = Math.max(answer, distance);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M ) { //이동 할 수 있으면
                int nextValue = board[nx][ny];
                if (!visited[nextValue])  {
                    visited[nextValue] = true;
                    DFS(nx, ny, distance + 1);
                    visited[nextValue] = false;
                }
            }
        }
    }
}
