package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_2206 {
    static class Point {
        private int x;
        private int y;
        private boolean broke; // true: 벽을 부순 경우, false: 벽을 부수지 않은 경우
        private int length;

        public Point(int x, int y, boolean broke, int length) {
            this.x = x;
            this.y = y;
            this.broke = broke;
            this.length = length;
        }
    }

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visited; // 3차원 방문 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 벽을 부순 경우와 부수지 않은 경우 두 가지 상태 관리

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < nextLine.length(); j++) {
                map[i][j] = nextLine.charAt(j) - '0'; // 0은 이동 가능, 1은 벽
            }
        }

        BFS(0, 0);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y, false, 1));
        visited[x][y][0] = true; // 시작점은 벽을 부수지 않은 상태로 시작

        while (!Q.isEmpty()) {
            Point poll = Q.poll();

            // 목표 지점에 도달한 경우
            if (poll.x == N - 1 && poll.y == M - 1) {
                answer = Math.min(answer, poll.length);
                continue;
            }

            // 상하좌우로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                // 맵의 범위를 벗어나지 않는지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) { // 이동 가능한 경우
                        if (!poll.broke && !visited[nx][ny][0]) { // 벽을 부수지 않은 상태에서 방문
                            visited[nx][ny][0] = true;
                            Q.offer(new Point(nx, ny, false, poll.length + 1));
                        } else if (poll.broke && !visited[nx][ny][1]) { // 벽을 부순 적 있는 상태에서 방문
                            visited[nx][ny][1] = true;
                            Q.offer(new Point(nx, ny, true, poll.length + 1));
                        }
                    } else if (map[nx][ny] == 1 && !poll.broke && !visited[nx][ny][1]) { // 벽을 만나고 아직 부순 적 없는 경우
                        visited[nx][ny][1] = true; // 벽을 부순 상태로 기록
                        Q.offer(new Point(nx, ny, true, poll.length + 1)); // 벽을 부수고 진행
                    }
                }
            }
        }
    }
}

/*
    일단 갈곳이 없다면(주위가 다 막혔다면) 벽을 부셔야 함.

    3차원 배열 사용: 일반적인 BFS에서는 방문 여부를 2차원 배열로 저장합니다.
    하지만 벽을 부수고 가는 경우와 부수지 않고 가는 경우를 구분해야 하므로,
    3차원 배열을 사용하여 (x, y, 벽을 부쉈는지 여부) 상태를 저장합니다.

    BFS 확장: 큐에 상태를 넣을 때 (x, y, 벽을 부쉈는지 여부)를 넣어,
    벽을 부순 경우와 부수지 않은 경우를 각각 따로 탐색합니다.

    벽을 만났을 때: 벽을 만났을 때, 벽을 한 번도 부수지 않았다면 그 벽을 부수고 이동할 수 있는 상태를 큐에 넣어야 합니다.

    상하좌우로 이동: BFS 특성상 한 번에 상하좌우로만 이동할 수 있으므로, 그 네 방향에 대해 각각 이동을 시도합니다.
 */