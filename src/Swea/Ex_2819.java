package Swea;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex_2819 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map = new int[4][4];
    static Set<Integer> set = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dfs(new Point(i,j), "", 0);
            }
        }

        System.out.println(set.size());
    }
    private static void dfs(Point point, String s, int L) {
        String curString = s + String.valueOf(map[point.x][point.y]);
        if (L == 6) {
            set.add(Integer.parseInt(curString));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(new Point(nx, ny), curString, L + 1);
            }
        }
    }
}
