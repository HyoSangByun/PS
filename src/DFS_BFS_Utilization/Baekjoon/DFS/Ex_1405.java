package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_1405 {
    static int N;
    static double answer = 0;
    static double[] dm = new double[4];
    static boolean[][] visited = new boolean[30][30]; // 방문 체크 배열 (임의로 30x30 크기 설정)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            int nextInt = sc.nextInt();
            dm[i] = (double) nextInt / 100;
        }

        // 시작 좌표 (15, 15)에서 DFS 시작 (중앙 좌표로 설정)
        visited[15][15] = true;  // 시작점 방문 처리
        dfs(0, 15, 15, 1);

        System.out.println(answer);
    }

    static void dfs(int L, int x, int y, double pro) {
        if (L == N) {  // 이동 횟수만큼 이동했으면 종료
            answer += pro;  // 단순 경로일 경우 확률을 누적
            return;
        }

        // 동서남북 4가지 방향으로 이동
        for (int i = 0; i < 4; i++) {
            if (dm[i] > 0) {  // 해당 방향으로 이동할 확률이 존재할 때만 이동
                int nx = x;
                int ny = y;

                if (i == 0) {  // 동쪽으로 이동
                    nx = x + 1;
                } else if (i == 1) {  // 서쪽으로 이동
                    nx = x - 1;
                } else if (i == 2) {  // 남쪽으로 이동
                    ny = y - 1;
                } else {  // 북쪽으로 이동
                    ny = y + 1;
                }

                // 새로운 좌표가 이미 방문된 적이 없다면
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;  // 해당 좌표를 방문했다고 표시
                    dfs(L + 1, nx, ny, pro * dm[i]);  // DFS 재귀 호출
                    visited[nx][ny] = false;  // 백트래킹: 해당 좌표를 방문 해제
                }
            }
        }
    }
}

/*
    총 경우의수는 움직일 수 있는 방향 갯수 ^ N
    이동결과가 겹친 횟수를 구하면 되는데.
    어떻게 구할 것인가
    움직일 확률이 1이상이면 일단 DFS하고,
    이동 경로를 다 저장해야하나? X
    이동할 때마다 그 무빙의 확률 곱해서 넘겨주면 될듯?
 */