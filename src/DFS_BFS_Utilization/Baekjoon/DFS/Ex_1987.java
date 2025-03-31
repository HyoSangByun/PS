package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_1987 { //백준 1987 !시간초과
    static int N, M, answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[][] board;
    static int[][] dis, ch;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new String[N][N];
        dis = new int[N][M];
        ch = new int[N][M];

        for (int i = 0; i < N; i++) {
            String next = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = String.valueOf(next.charAt(j));
            }
        }

        list.add(board[0][0]);
        ch[0][0] = 1;
        DFS(0, 0);

        System.out.println(answer);
    }

    static void DFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0 && !list.contains(board[nx][ny])) { //갈 수 있으면
                ch[nx][ny] = 1;
                list.add(board[nx][ny]);
                dis[nx][ny] = dis[x][y] + 1;
                answer = Math.max(dis[nx][ny] + 1, answer);

                DFS(nx, ny);
                list.remove(board[nx][ny]);
                ch[nx][ny] = 0;
            }
        }
    }
}
