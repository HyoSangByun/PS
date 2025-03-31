package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_15683 {
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
    static List<List<Point>> cctvList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < 6; i++) {
            cctvList.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nextInt = sc.nextInt();
                if (nextInt > 0 && nextInt < 6) {
                    cctvList.get(nextInt).add(new Point(i, j));
                }
                map[i][j] = nextInt;
            }
        }

    }

    private static void color(int first, int second, int third, int fourth) {

        
    }

    private static void chooseDirection() {
        for (int first = 0; first < 4; first++) {
            for (int second = 0; second < 2; second++) {
                for (int third = 0; third < 4; third++) {
                    for (int fourth = 0; fourth < 4; fourth++) {
                        //조합 구한 후 방향대로 색칠
                    }
                }
            }
        }
    }
}
