package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1600 {
    static class Chess {
        private int x;
        private int y;
        private int state;
        private int distance;

        public Chess(int x, int y, int state, int distance) {
            this.x = x;
            this.y = y;
            this.state = state;
            this.distance = distance;
        }
    }
    static int K, N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visited;
    static int[] horseDx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] horseDy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] monkeyDx = {-1, 0, 1, 0};
    static int[] monkeyDy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M][K + 1]; // K는 말로 이동한 횟수를 체크함

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs(new Chess(0,0,0,0));

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void bfs(Chess chess) {
        Queue<Chess> Q = new LinkedList<>();
        Q.offer(chess);
        visited[chess.x][chess.y][0] = true;

        while (!Q.isEmpty()) {
            Chess poll = Q.poll();

            if (poll.x == N - 1 && poll.y == M - 1) {
                answer = Math.min(answer, poll.distance);
            }

            if (poll.state < K) { //말 상태 이동
                for (int i = 0; i < 8; i++) {
                    int nx = poll.x + horseDx[i];
                    int ny = poll.y + horseDy[i];

                    if (nx >=0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny][poll.state + 1] && map[nx][ny] == 0) {
                        visited[nx][ny][poll.state + 1] = true;
                        Q.offer(new Chess(nx, ny, poll.state + 1, poll.distance + 1));
                    }
                }
            }

            for (int i = 0; i < 4; i++) { //원숭이 상태 이동
                int nx = poll.x + monkeyDx[i];
                int ny = poll.y + monkeyDy[i];

                if (nx >=0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny][poll.state] && map[nx][ny] == 0) {
                    visited[nx][ny][poll.state] = true;
                    Q.offer(new Chess(nx, ny, poll.state, poll.distance + 1));
                }
            }

        }
    }
}

/*
    바로 정답임 ㅋㅋ
 */
