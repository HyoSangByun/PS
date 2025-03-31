package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_17472_2 {
    static int N, M, answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static List<Bridge> bridgeList = new ArrayList<>();
    static int[] parent;

    static class Bridge implements Comparable<Bridge> {
        private int city1;
        private int city2;
        private int length;

        public Bridge(int city1, int city2, int length) {
            this.city1 = city1;
            this.city2 = city2;
            this.length = length;
        }

        @Override
        public int compareTo(Bridge o) {
            return this.length - o.length;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 섬을 구분함
        visited = new boolean[N][M];
        int mark = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    marking(i, j, ++mark);
                }
            }
        }

        // 가로로 다리를 놓을 수 있는 경우를 셈
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j - 1 >= 0 && map[i][j - 1] > 0 && map[i][j] == 0) {
                    widthBridge(i, j, j, 0);
                }
            }
        }

        // 세로로 다리를 놓을 수 있는 경우를 셈
        for (int i = 0; i < M; i++) { // 열
            for (int j = 0; j < N; j++) { // 행
                if (j - 1 >= 0 && map[j - 1][i] > 0 && map[j][i] == 0) {
                    heightBridge(i, j, j, 0);
                }
            }
        }

        // 유니온 파인드 초기화
        parent = new int[mark + 1];
        for (int i = 1; i <= mark; i++) {
            parent[i] = i;
        }

        // 모든 섬을 연결하는 다리 길이의 최솟값을 구하자
        Collections.sort(bridgeList);
        answer = 0;
        int connectedBridges = 0;
        for (Bridge bridge : bridgeList) {
            int city1 = bridge.city1;
            int city2 = bridge.city2;

            if (union(city1, city2)) {
                answer += bridge.length;
                connectedBridges++;
            }
        }

        // 모든 섬이 연결되었는지 확인
        if (connectedBridges == mark - 2) { // 섬 수 - 1 = 필요한 다리 수
            System.out.println(answer);
        } else {
            System.out.println(-1); // 모든 섬을 연결할 수 없는 경우
        }
    }

    private static void marking(int x, int y, int mark) { // 섬을 구분함
        visited[x][y] = true;
        map[x][y] = mark;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
                marking(nx, ny, mark);
            }
        }
    }

    private static void widthBridge(int x, int startY, int curY, int length) {
        if ((map[x][curY] > 0 && length < 2)) {
            return;
        }

        if (map[x][curY] > 0 && length >= 2) {
            if (map[x][startY - 1] != map[x][curY]) {
                bridgeList.add(new Bridge(map[x][startY - 1], map[x][curY], length));
            }
            return;
        }

        if (curY == M - 1) return;

        if (curY + 1 < M) {
            widthBridge(x, startY, curY + 1, length + 1);
        }
    }

    private static void heightBridge(int y, int startX, int curX, int length) {
        if ((map[curX][y] > 0 && length < 2)) {
            return;
        }

        if (map[curX][y] > 0 && length >= 2) {
            if (map[startX - 1][y] != map[curX][y]) {
                bridgeList.add(new Bridge(map[startX - 1][y], map[curX][y], length));
            }
            return;
        }

        if (curX == N - 1) return;

        if (curX + 1 < N) {
            heightBridge(y, startX, curX + 1, length + 1);
        }
    }

    // 유니온 파인드 메서드들
    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}

/*
static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa!=fb) unf[fa] = fb;
    }
    반례
    #Input
    6 6
    1 1 1 1 1 1
    0 0 0 0 0 0
    1 1 1 0 1 0
    0 1 0 1 0 1
    0 0 0 0 0 0
    1 1 1 1 1 1

    #Output
    -1
 */