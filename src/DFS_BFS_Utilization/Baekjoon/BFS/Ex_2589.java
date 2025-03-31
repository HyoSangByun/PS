package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_2589 { //백준 2589
    static int N, M, max = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();

        dis[x][y] = 1;
        Q.offer(new Point(x, y));

        while (!Q.isEmpty()) {
            Point poll = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < N && ny>= 0 && ny < M && dis[nx][ny] == 0 && board[nx][ny] == 11) {
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[poll.x][poll.y] + 1;
                    max = Math.max(max, dis[nx][ny]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String next = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = next.charAt(j) - 'A';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 11) {
                    dis = new int[N][M];

                    BFS(i, j);
                }
            }
        }

        System.out.println(max - 1);
    }
}

// L : 11 / W : 22