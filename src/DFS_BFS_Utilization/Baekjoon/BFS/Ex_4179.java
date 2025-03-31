package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.*;

public class Ex_4179 {
    static class Jihun {
        private int x;
        private int y;
        private int distance;

        public Jihun(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, answer = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> fireQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new char[N][M];
        visited = new boolean[N][M];

        int sX = 0;
        int sY = 0;
        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < nextLine.length(); j++) {
                if (nextLine.charAt(j) == 'J') {
                    sX = i;
                    sY = j;
                    map[i][j] = '.';  // 지훈이의 위치는 빈 칸으로 변경
                } else if (nextLine.charAt(j) == 'F') {
                    fireQueue.add(new Point(i, j)); // 불의 위치 추가
                    map[i][j] = 'F'; // 불의 위치
                } else {
                    map[i][j] = nextLine.charAt(j); // 맵의 다른 부분은 그대로 유지
                }
            }
        }

        // BFS 시작
        if (bfs(new Jihun(sX, sY, 1))) {
            System.out.println(answer);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    static boolean bfs(Jihun jihun) {
        Queue<Jihun> jihunQueue = new LinkedList<>();
        jihunQueue.offer(jihun);
        visited[jihun.x][jihun.y] = true;

        while (!jihunQueue.isEmpty()) {
            // 현재 불을 먼저 확산
            fireSpread();

            // 지훈이의 이동 처리
            int size = jihunQueue.size();
            for (int i = 0; i < size; i++) {
                Jihun poll = jihunQueue.poll();

                // 탈출 조건
                if (poll.x == 0 || poll.x == N - 1 || poll.y == 0 || poll.y == M - 1) {
                    answer = poll.distance;
                    return true;
                }

                // 지훈이의 다음 이동
                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        jihunQueue.offer(new Jihun(nx, ny, poll.distance + 1));
                    }
                }
            }
        }

        return false;
    }

    private static void fireSpread() {
        int fireSize = fireQueue.size();
        for (int f = 0; f < fireSize; f++) {
            Point fire = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                // 불이 퍼지는 영역 처리
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == '.') {
                    map[nx][ny] = 'F';
                    fireQueue.offer(new Point(nx, ny));
                }
            }
        }
    }
}

/*
    불을 지훈이보다 먼저 이동처리해줘야 함
 */