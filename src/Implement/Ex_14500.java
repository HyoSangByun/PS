package Implement;

import java.util.Scanner;

public class Ex_14500 {
    static int[][] map;
    static boolean[][] ch;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        ch = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ch[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                ch[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && nx < N && ny >= 0 && ny < M && !ch[nx][ny]) {
                if (depth == 2) {
                    ch[nx][ny] = true;
                    dfs(x, y, depth + 1, sum + map[nx][ny]);
                    ch[nx][ny] = false;
                }
                ch[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                ch[nx][ny] = false;
            }
        }

    }
}

