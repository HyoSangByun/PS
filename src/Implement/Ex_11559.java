package Implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex_11559 {

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new char[12][6];
        ch = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            String next = sc.next();
            for (int j = 0; j < 6; j++) {
                map[i][j] = next.charAt(j);
            }
        }

        int count = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !ch[i][j]) {
                        if(pop(map[i][j] , new Point(i, j))) flag = true;
                    }
                }
            }

            if(!flag) break;
            gravity();
            count++;
            ch = new boolean[12][6];
        }
        System.out.println(count);

    }

    private static boolean pop(char c, Point start) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        queue.offer(start);
        list.add(start);
        ch[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < 12 && ny >=0 && ny < 6 && map[nx][ny] == c && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    Point newPoint = new Point(nx, ny);
                    list.add(newPoint);
                    queue.offer(newPoint);
                }
            }
        }

        if (list.size() >= 4) {
            for (Point point : list) {
                map[point.x][point.y] = '.';
            }
        }

        return list.size() >= 4;
    }

    private static void gravity() {
        for (int i = 0; i < 6; i++) {
            boolean empty = false;
            int lastPoint = Integer.MIN_VALUE;
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] == '.') {
                    lastPoint = Math.max(j, lastPoint);
                    empty = true;
                } else if(empty) {
                    map[lastPoint][i] = map[j][i];
                    map[j][i] = '.';
                    lastPoint--;
                }
            }
        }
    }
}
