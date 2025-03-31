package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ex_21736 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static char[][] map;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new char[N][M];
        ch = new boolean[N][M];
        Point start = null;
        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < M; j++) {
                char c = nextLine.charAt(j);
                if (c == 'I') {
                    start = new Point(i, j);
                }
                map[i][j] = c;
            }
        }

        BFS(start);
        if (answer == 0) {
            System.out.println("TT");
        }else {
            System.out.println(answer);
        }
    }

    private static void BFS(Point start) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(start);
        ch[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            if (map[poll.x][poll.y] == 'P') answer++;

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !ch[nx][ny] && map[nx][ny] != 'X') {
                    ch[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }

        }
    }

}
