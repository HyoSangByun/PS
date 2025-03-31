package Swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1210 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        map = new int[100][100];
        visited = new boolean[100][100];
        Point start = null;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int nextInt = sc.nextInt();
                if (nextInt == 2) start = new Point(i, j);
                map[i][j] = nextInt;
            }
        }

        System.out.println(bfs(start));
    }

    private static int bfs(Point start) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(start);
        visited[start.x][start.y] = true;

        while (!Q.isEmpty()) {
            Point poll = Q.poll();
            boolean flag = false;
            if (poll.x == 0) return poll.y;

            for (int i = 0; i < 2; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 &&map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                    flag = true;
                }
            }

            if (!flag) {
                int nx = poll.x + dx[2];
                int ny = poll.y + dy[2];
                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }
        }

        return -1;
    }
}