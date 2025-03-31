package Implement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_2636 {

    static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int lastCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
//                if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
//                    map[i][j] = 2;
//                }
            }
        }

        int count = 0;
        initAir();
        while (isFinish()) {
            melting();
            newAir();
            count++;
        }

        System.out.println(count);
        System.out.println(lastCount);
    }

    private static void initAir() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        map[0][0] = 2;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }

    private static boolean isFinish() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //외부 공기 판단
    private static void newAir() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 2) {
                            queue.offer(new Point(i, j));
                            break;
                        }
                    }

                }
            }
        }

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            map[poll.x][poll.y] = 2;

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static void melting() {
        lastCount = 0;
        boolean[][] newMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 2) {
                            lastCount++;
                            newMap[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j]) {
                    map[i][j] = 2;
                }
            }
        }
    }

}
