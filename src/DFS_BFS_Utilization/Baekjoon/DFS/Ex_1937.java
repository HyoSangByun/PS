package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_1937 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] visited;
    static int N , answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, DFS(i, j));  // 최댓값을 갱신
            }
        }

        System.out.println(answer);
    }

    static int DFS(int x, int y) { //자기 칸에서 갈 수 있는 최대 거리 반환
        if (visited[x][y] != 0) return visited[x][y];  // 이미 방문한 곳이면 그 값 리턴

        visited[x][y] = 1;  // 현재 위치는 최소 1칸을 갈 수 있음
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < N && nx >= 0 && ny < N && ny >= 0 && map[x][y] < map[nx][ny]){
                visited[x][y] = Math.max(visited[x][y], DFS(nx, ny) + 1);  // 재귀 호출 후 값 갱신
            }
        }

        return visited[x][y];  // 결과 반환
    }
}
