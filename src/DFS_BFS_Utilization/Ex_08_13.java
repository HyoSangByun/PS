package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_13 { //섬나라 아일랜드 (DFS)

    static int n;
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[][] board;
    static int answer;

    public static void DFS(int x, int y){
        board[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { //갈 수 있음
                board[nx][ny] = 0; //체크
                DFS(nx, ny);
//                    board[nx][ny] = 1;
            }

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }

}
