package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_14940 {
    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int map[][];
    static int answerMap[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        answerMap = new int[N][M];
        Point start = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nextInt = sc.nextInt();
                if (nextInt == 2) {
                    start = new Point(i, j);
                }
                map[i][j] = nextInt;
            }
        }
        bfs(start);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (answerMap[i][j] == 0 && map[i][j] == 1) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(answerMap[i][j] + " ");
                }
            }
            System.out.println();
        }
        
    }

    private static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx < N && nx >= 0 && ny < M && ny >= 0 && map[nx][ny] == 1 ) {
                    if (answerMap[nx][ny] == 0 ||  answerMap[poll.x][poll.y] + 1 < answerMap[nx][ny]) {
                        answerMap[nx][ny] = answerMap[poll.x][poll.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

}
