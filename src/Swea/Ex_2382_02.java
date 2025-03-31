package Swea;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex_2382_02 {

    static class Bacteria implements Comparable<Bacteria> {

        private int x;
        private int y;
        private int direction;
        private int size;

        public Bacteria(int x, int y, int direction, int size) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.size = size;
        }

        @Override
        public int compareTo(Bacteria o) {
            return o.size - this.size;
        }
    }

    static int N, M, K;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static Queue<Bacteria> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for (int i = 1; i <= test_case; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            queue = new ArrayDeque<>();
            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int size = sc.nextInt();
                int dir = sc.nextInt() - 1;
                Bacteria bacteria = new Bacteria(x, y, dir, size);
                queue.offer(bacteria);
            }

            bfs();
            int sum = 0;
            while (!queue.isEmpty()) {
                Bacteria poll = queue.poll();
                sum += poll.size;
            }
            System.out.println("#" + i + " " + sum);
        }
    }

    private static void bfs() {
        for (int i = 0; i < M; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Bacteria poll = queue.poll();

                int nx = poll.x + dx[poll.direction];
                int ny = poll.y + dy[poll.direction];

                if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
                    int new_size = poll.size / 2;
                    if (new_size == 0) continue;
                    int new_dir = calDirction(poll.direction);
                    queue.offer(new Bacteria(nx, ny, new_dir, new_size));
                } else {
                    queue.offer(new Bacteria(nx, ny, poll.direction, poll.size));
                }
            }
            add();
        }
    }

    private static int calDirction(int dir) {
        if (dir == 0) {
            return 1;
        } else if (dir ==1) {
            return 0;
        } else if (dir == 2) {
            return 3;
        } else {
            return 2;
        }
    }

    private static void add() {
        Bacteria[][] map = new Bacteria[N][N];
        Queue<Bacteria> newQueue = new ArrayDeque<>();
        List<Bacteria> list = new ArrayList<>(queue);
        int size = list.size();

        Collections.sort(list);

        for (int i = 0; i < size; i++) {
            Bacteria bacteria = list.get(i);

            if (map[bacteria.x][bacteria.y] == null) {
                map[bacteria.x][bacteria.y] = bacteria;
            } else {
                Bacteria existing = map[bacteria.x][bacteria.y];
                int new_diretion = (existing.size > bacteria.size) ? existing.direction : bacteria.direction;
                map[bacteria.x][bacteria.y] = new Bacteria(bacteria.x, bacteria.y, new_diretion,
                    existing.size + bacteria.size);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != null) {
                    newQueue.offer(map[i][j]);
                }
            }
        }
        queue = newQueue;
    }
}
