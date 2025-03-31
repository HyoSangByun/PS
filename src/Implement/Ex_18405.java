package Implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex_18405 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, K, S, X, Y;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Queue<Point>> queueList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i <= K; i++) {
            queueList.add(new LinkedList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nextInt = sc.nextInt();
                map[i][j] = nextInt;

                if (nextInt > 0) {
                    queueList.get(nextInt).offer(new Point(i, j));
                }
            }
        }

        S = sc.nextInt();
        X = sc.nextInt() - 1;
        Y = sc.nextInt() - 1;

        for (int q = 0; q < S; q++) {
            for (int i = 1; i <= K; i++) {
                //맵 탐색, i는 바이러스 종류
                bfs(i);
            }
        }

        System.out.println(map[X][Y]);
    }

    private static void bfs(int virus) {
        Queue<Point> queue = queueList.get(virus);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Point poll = queue.poll();

            for (int l = 0; l < 4; l++) {
                int nx = poll.x + dx[l];
                int ny = poll.y + dy[l];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                    map[nx][ny] = virus;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}
