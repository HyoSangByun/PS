package BackTracking;

import java.util.Scanner;

public class Ex_10971 {
    static int N;
    static int[][] map;
    static boolean[] visited;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited[0] = true; // 0에서 출발
        DFS(0, 0);

        System.out.println(answer);
    }

    static void DFS(int now, int costSum) {
        if (allVisited()) { //모두 방문했다면
            if (map[now][0] != 0) { //다시 0으로 돌아갈 수 있다면 (순회 가능한지)
                answer = Math.min(answer, costSum + map[now][0]);
                return;
            }
        }

        for (int togo = 1; togo < N; togo++) { //togo는 1부터
            if (!visited[togo] && map[now][togo] != 0) {
                visited[togo] = true;
                DFS(togo, costSum + map[now][togo]);
                visited[togo] = false;
            }
        }
    }

    static boolean allVisited() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
