package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_7569 {

    static class Point {
        private int x;
        private int y;
        private int h;

        public Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static int M, N, H; // M: 가로, N: 세로, H: 높이
    static int[][][] arr; // 3D 배열 선언
    static int[] dx = {-1, 0, 1, 0}; // 상하좌우 x 좌표 변화
    static int[] dy = {0, 1, 0, -1}; // 상하좌우 y 좌표 변화
    static int[] dh = {-1, 1}; // 위아래 z 좌표 변화
    static Queue<Point> tomatos = new LinkedList<>();
    static int days = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로 크기
        N = sc.nextInt(); // 세로 크기
        H = sc.nextInt(); // 높이 크기
        arr = new int[H][N][M]; // 3D 배열 크기 설정

        boolean allRipe = true;

        // 토마토 정보 입력
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    int nextInt = sc.nextInt();
                    if (nextInt == 1) {
                        tomatos.offer(new Point(n, m, h)); // 익은 토마토 큐에 추가
                    } else if (nextInt == 0) {
                        allRipe = false; // 익지 않은 토마토 발견
                    }
                    arr[h][n][m] = nextInt; // 토마토 상태 저장
                }
            }
        }

        if (allRipe) {
            System.out.println(0);
            return;
        }

        bfs();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        System.out.println(-1); // 익지 않은 토마토가 있으면 -1 출력
                        return;
                    }
                }
            }
        }

        System.out.println(days - 1);
    }

    private static void bfs() {
        while (!tomatos.isEmpty()) {
            int size = tomatos.size();
            for (int i = 0; i < size; i++) {
                Point tomato = tomatos.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tomato.x + dx[j];
                    int ny = tomato.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[tomato.h][nx][ny] == 0) {
                        arr[tomato.h][nx][ny] = 1;
                        tomatos.offer(new Point(nx, ny, tomato.h));
                    }
                }

                for (int j = 0; j < 2; j++) {
                    int nh = tomato.h + dh[j];
                    if (nh >= 0 && nh < H && arr[nh][tomato.x][tomato.y] == 0) {
                        arr[nh][tomato.x][tomato.y] = 1;
                        tomatos.offer(new Point(tomato.x, tomato.y, nh));
                    }
                }
            }
            days++; // 하루가 지나므로 days 증가
        }
    }
}
