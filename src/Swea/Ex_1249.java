package Swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1249 {
    static class Point {
        private int x;
        private int y;
        private int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static int[][] map;
    static boolean[][] visited;
    static int N, answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < nextLine.length(); j++) {
                map[i][j] = nextLine.charAt(j) - '0';
            }
        }

        bfs(new Point(0, 0, 0));
        System.out.println(answer);
    }

    private static void bfs(Point start) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(start);
        visited[start.x][start.y] = true;

        while (!Q.isEmpty()) {
            Point poll = Q.poll();

            if (poll.x == N - 1 && poll.y == N - 1) {
                answer = Math.min(answer, poll.distance);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny, poll.distance + map[nx][ny]));
                }
            }
        }
    }
}
