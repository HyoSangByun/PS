package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_10026 { //백준 10026
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, ch1, ch2;

    static void DFS(int x, int y, int color) {
        ch1[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch1[nx][ny] == 0 && board[nx][ny] == color) {
                DFS(nx, ny, color);
            }
        }
    }


    static void DFS2(int x, int y, int color) {
        ch2[x][y] = 1;

        if (color == 6 || color == 17) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((nx >= 0 && nx < N && ny >= 0 && ny < N && ch2[nx][ny] == 0 && board[nx][ny] == 17) || (nx >= 0 && nx < N && ny >= 0 && ny < N && ch2[nx][ny] == 0 && board[nx][ny] == 6)) {
                    DFS2(nx, ny, color);
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch2[nx][ny] == 0 && board[nx][ny] == color) {
                    DFS2(nx, ny, color);
                }
            }
        }
    }


    /*
    static void DFS2(int x, int y, int color) {
        ch2[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 색약의 경우 R(17)과 G(6)를 동일하게 취급
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch2[nx][ny] == 0) {
                if ((color == 17 || color == 6) && (board[nx][ny] == 17 || board[nx][ny] == 6)) {
                    DFS2(nx, ny, color);
                } else if (color == board[nx][ny]) {
                    DFS2(nx, ny, color);
                }
            }
        }
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N][N];
        ch1 = new int[N][N];
        ch2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            String next = sc.next();

            for (int j = 0; j < N; j++) {
                board[i][j] = next.charAt(j) - 'A';
            }
        }

        //정상눈
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ch1[i][j] == 0) {
                    DFS(i,j,board[i][j]);
                    normalCount++;
                }
            }
        }

        //색약
        int Count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ( ch2[i][j] == 0) {
                    DFS2(i,j,board[i][j]);
                    Count++;
                }
            }
        }

        System.out.println(normalCount + " " + Count);
    }
}

/*
    R : 17
    G : 6
    B : 1
 */