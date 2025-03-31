package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_3109 {
    static int N, M, answer = Integer.MAX_VALUE;
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

        for (int i = 1; i < M - 1; i++) {
            dfs(i);
        }

        System.out.println(answer);
    }

    private static void dfs(int col) {
        int count = 0;

        for (int i = 0; i < N; i++) { //해당 col에 모든 행에 대해
            boolean flag = false;
            if (map[i][col] == '.') {
                if ((i - 1 >= 0 && col - 1 >= 0 && map[i - 1][col - 1] == '.') ||
                        (col - 1 >= 0 && map[i][col - 1] == '.') ||
                        (i + 1 < N && col - 1 >= 0 && map[i + 1][col - 1] == '.')) { //왼쪽에 적어도 하나 둘 곳이 있으면

                            if ((i - 1 >= 0 && col + 1 < M && map[i - 1][col + 1] == '.') ||
                                    (col + 1 < M && map[i][col + 1] == '.') ||
                                    (i + 1 < N && col + 1 < M && map[i + 1][col + 1] == '.')
                            ){
                                flag = true;
                            }
                }
                if (flag) count++;
            }

        }

        answer = Math.min(answer, count);
    }
}

/*
    기준 타일에서 왼쪽 열이나 오른쪽 열 각각에 적어도 한곳은 파이프를 둘곳이 존재해야 한다.
    각 열 중에서 최솟값을 구하면 된다.
 */