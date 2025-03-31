package Implement;

import java.util.Scanner;

public class Ex_17144 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, time;
    static int[][] map;
    static Point[] aircon = new Point[2];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        time = sc.nextInt();
        map = new int[N][M];

        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    aircon[index++] = new Point(i, j);
                }
            }
        }

        for (int i = 0; i < time; i++) {
            divideDust();
            upperWind();
            downWind();
        }
        System.out.println(countDust());
    }

    private static void divideDust() {
        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {  // 미세먼지가 있는 경우 확산
                    int spreadAmount = map[i][j] / 5;
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != -1) {
                            tempMap[nx][ny] += spreadAmount; //먼지 퍼짐
                            spreadCount++;
                        }
                    }
                    tempMap[i][j] += map[i][j] - spreadAmount * spreadCount; //기존 먼지
                } else if (map[i][j] == -1) {
                    tempMap[i][j] = -1; // 공기청정기 위치 유지
                }
            }
        }

        // 확산이 완료된 후 기존 map 갱신
        for (int i = 0; i < N; i++) {
            System.arraycopy(tempMap[i], 0, map[i], 0, M);
        }
    }

    private static void upperWind() {
        Point point = aircon[0];
        int prev = 0;

        for (int i = point.y + 1; i < M; i++) {
            int temp = map[point.x][i];
            map[point.x][i] = prev;
            prev = temp;
        }

        for (int i = point.x - 1; i >= 0; i--) {
            int temp = map[i][M - 1];
            map[i][M - 1] = prev;
            prev = temp;
        }

        for (int i = M - 2; i >= 0; i--) {
            int temp = map[0][i];
            map[0][i] = prev;
            prev = temp;
        }

        for (int i = 1; i < point.x; i++) {
            int temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
    }

    private static void downWind() {
        Point point = aircon[1];
        int prev = 0;

        for (int i = point.y + 1; i < M; i++) {
            int temp = map[point.x][i];
            map[point.x][i] = prev;
            prev = temp;
        }

        for (int i = point.x + 1; i < N; i++) {
            int temp = map[i][M - 1];
            map[i][M - 1] = prev;
            prev = temp;
        }

        for (int i = M - 2; i >= 0; i--) {
            int temp = map[N - 1][i];
            map[N - 1][i] = prev;
            prev = temp;
        }

        for (int i = N - 2; i > point.x; i--) {
            int temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
    }

    private static int countDust() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}
