package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_3109_02 {
    static int N, M;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = nextLine.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            System.out.println();
            if (dfs(i, 0)) {
                for (int j = 0; j < N; j++) {
                    System.out.println();
                    for (int k = 0; k < M; k++) {
                        System.out.print(map[j][k] + " ");
                    }
                }
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int x, int y) {
        map[x][y] = '-';

        if (y == M - 1) {
            return true;
        }


        if (x > 0 && map[x-1][y+1] == '.') {
            if (dfs(x -1, y + 1)) return true;
        }
        if (map[x][y+1] == '.'){
            if (dfs(x, y + 1)) return true;
        }
        if (x+1 < N && map[x+1][y+1] == '.') {
            if (dfs(x + 1, y + 1)) return true;
        }

        return false;
    }
}

/*
    기준 타일에서 왼쪽 열이나 오른쪽 열 각각에 적어도 한곳은 파이프를 둘곳이 존재해야 한다.
    각 열 중에서 최솟값을 구하면 된다.
 */