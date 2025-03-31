package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_7576 {

    static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> tomatos = new LinkedList<>();
    static int days = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M][N];

        boolean allRipe = true;

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                int nextInt = sc.nextInt();
                if (nextInt == 1) {
                    tomatos.offer(new Point(j, k));
                } else if (nextInt == 0) {
                    allRipe = false;
                }
                arr[j][k] = nextInt;
            }
        }

        if (allRipe) { // 모든 토마토가 이미 익어있는 경우
            System.out.println(0);
            return;
        }

        bfs();

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (arr[j][k] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }

    private static void bfs() {
        while (!tomatos.isEmpty()) {
            int size = tomatos.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Point tomato = tomatos.poll();

                //평면확인
                for (int j = 0; j < 4; j++) {
                    int nx = tomato.x + dx[j];
                    int ny = tomato.y + dy[j];

                    if (nx < M && nx >= 0 && ny < N && ny >= 0 && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        tomatos.offer(new Point(nx, ny));
                        flag = true;
                    }
                }
            }
            if (flag) { //갈 곳이 없는데 날짜 증가하는 거 방지
                days++;
            }
        }
    }
}
