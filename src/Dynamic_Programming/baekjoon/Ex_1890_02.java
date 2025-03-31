package Dynamic_Programming.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1890_02 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] arr;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        moving(new Point(0,0));
        
        System.out.println(count);
    }

    static void moving(Point point) {
        Queue<Point> Q = new LinkedList<>();

        Q.offer(point);

        while (!Q.isEmpty()) {
            Point poll = Q.poll();

            if (arr[poll.x][poll.y] == 0) count++;
            else {
                int next = arr[poll.x][poll.y];
                if (next + poll.x < arr.length) Q.offer(new Point(next + poll.x, poll.y));
                if (next + poll.y < arr.length) Q.offer(new Point(poll.x, next + poll.y));
            }
        }
    }
}
