package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_2178 { //백준 2178
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, ch, dis;

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static void BFS(Point point) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(point);
        ch[point.x][point.y] = 1;

        while (!Q.isEmpty()) {
            Point pollPoint = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pollPoint.x + dx[i];
                int ny = pollPoint.y + dy[i];

                if (nx >=1 && nx <= N && ny >=1 && ny <= M && board[nx][ny] == 1 && ch[nx][ny] == 0) {
                    dis[nx][ny] = dis[pollPoint.x][pollPoint.y] + 1;
                    ch[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
//                    ch[nx][ny] = 0;

                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N + 1][M + 1];
        ch = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String next = sc.next();
            for (int j = 1; j <= M; j++) {
                board[i][j] = next.charAt(j - 1) - '0';
            }
        }

        BFS(new Point(1, 1));
        System.out.println(dis[N][M] + 1);
    }
}

/*
    ch 를 쓰지 않고, dis가 0인지만 확인해서 최적화 가능함
 */