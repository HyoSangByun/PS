package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_12851 {
    static class Chess {
        private int x;
        private int distance;

        public Chess(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }

    static int N, K, count = 0;
    static int min = Integer.MAX_VALUE;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        visited = new int[100001];
        for (int i = 0; i < 100001; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        bfs(new Chess(N, 0));

        System.out.println(min);
        System.out.println(count);
    }

    private static void bfs(Chess start) {
        Queue<Chess> Q = new LinkedList<>();
        Q.offer(start);
        visited[start.x] = 1;

        while (!Q.isEmpty()) {
            Chess poll = Q.poll();

            if (poll.x == K) {
                count++;
                min = Math.min(min, poll.distance);
                continue;
            }

            if (poll.x < K && 2 * poll.x <= 100000 && poll.distance + 1 <= visited[2 * poll.x]) {
                visited[2 * poll.x] = poll.distance + 1;
                Q.offer(new Chess(2 * poll.x, poll.distance + 1));
            }
            if (poll.x - 1 >= 0 && poll.distance + 1 <= visited[poll.x - 1]){
                visited[poll.x - 1] = poll.distance + 1;
                Q.offer(new Chess(poll.x - 1, poll.distance + 1));
            }
            if (poll.x + 1 <= 100000 && poll.distance + 1 <= visited[poll.x + 1]) {
                visited[poll.x + 1] = poll.distance + 1;
                Q.offer(new Chess(poll.x + 1, poll.distance + 1));
            }
        }
    }
}

/*
    5 - 4 - 8 - 16 - 17
    5 - 10 - 9 - 18 - 17

    내가 스스로 품
 */