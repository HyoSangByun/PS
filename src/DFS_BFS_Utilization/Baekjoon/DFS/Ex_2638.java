package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.*;

public class Ex_2638 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Point> cheese = new ArrayList<>();
    static int cheeseCnt = 0;

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nextInt = sc.nextInt();
                map[i][j] = nextInt;
                if (nextInt == 1) {
                    cheese.add(new Point(i, j));
                    cheeseCnt += 1;
                }
            }
        }

        int time = 0;

        while(cheeseCnt != 0) {
            time++;
            visited = new boolean[N][M];
            DFS(0, 0); // 외부 공기 찾기
            // bfs();
            melting(); // 치즈 녹이기
        }

        System.out.println(time);
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;
        map[x][y] = 2; // 외부 공기라는 의미로 2로 바꿔줌

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny] || map[nx][ny] == 1) continue;

            DFS(nx, ny); // 공기인 경우만 dfs 수행
        }
    }

    static void melting() {
        for (int i = 0; i < cheese.size(); i++) {
            Point point = cheese.get(i);
            int flag = 0;
            for (int j = 0; j < 4; j++) {
                int nx = point.x + dx[j];
                int ny = point.y + dy[j];

                if (nx < N && nx >=0 && ny < M && ny >= 0 && map[nx][ny] == 2) flag++;
            }

            if(flag >= 2) { // 외부 공기와 2변 이상 접촉한 경우
                map[point.x][point.y] = 0;
                cheeseCnt--;
                cheese.remove(i);
                i--;
            }
        }
    }
}
