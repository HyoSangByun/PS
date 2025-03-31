package Implement;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_3190 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Change {

        private int time;
        private String direction;

        public Change(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    static int N;
    static int[][] map;
    static Queue<Change> Q = new LinkedList<>();
    static int answer = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a][b] = 2; //사과
        }

        int S = sc.nextInt();
        for (int i = 0; i < S; i++) {
            int time = sc.nextInt();
            String direction = sc.next().trim();
            Q.offer(new Change(time, direction));
        }

        map[0][0] = 1;
        moving(new Point(0,0),0);
        System.out.println(answer + 1);

    }

    private static void moving(Point start,  int direction) {
        Deque<Point> Dq = new ArrayDeque<>();
        Dq.offer(start);
        int time = 0;

        while (true) {
            if (!Q.isEmpty() && Q.peek().time == time) {
                Change poll = Q.poll();
                if (poll.direction.equals("L")) {
                    direction = (direction - 1 + 4) % 4; // 왼쪽 회전
                } else {
                    direction = (direction + 1) % 4; // 오른쪽 회전
                }
            }

            Point head = Dq.peekFirst();

            int nx = head.x + dx[direction];
            int ny = head.y + dy[direction];

            if (canGO(nx, ny)) {
                if (map[nx][ny] == 2) { //사과를 만나는 경우
                    map[nx][ny] = 1;
                    Dq.addFirst(new Point(nx, ny));
                } else { //빈칸인 경우
                    map[nx][ny] = 1;
                    Dq.addFirst(new Point(nx, ny));
                    Point tail = Dq.pollLast();
                    map[tail.x][tail.y] = 0;

                }
            } else {
                answer = time;
                return;
            }

            time++;
        }

    }

    private static boolean canGO(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N && map[x][y] != 1) {
            return true;
        }
        return false;
    }
}

/*
    사과를 만난 경우 맨 앞에 새로운 머리를 넣어줌
    빈칸을 만난 경우 맨 뒤에 있는 꼬리를 제거함


 */