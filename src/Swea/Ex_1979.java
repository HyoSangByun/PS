package Swea;

import java.util.Scanner;

public class Ex_1979 {
    static int N, K;
    static int[][] map;
    static boolean[][] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        int answer = 0;

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //세로확인
        ch = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !ch[i][j]) {
                    if (row(1, i, j) == K) {
                        answer++;
                    }
                }
            }
        }

        //가로확인
        ch = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !ch[i][j]) {
                    if (col(1, i, j) == K) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int row(int L, int x, int y) { //세로 확인
        ch[x][y] = true;
        int ny = y + 1;
        if (ny < N && map[x][ny] == 1 && !ch[x][ny]) {
            ch[x][ny] = true;
            return row(L + 1, x, ny);
        }

        return L;
    }

    private static int col(int L, int x, int y) { //세로 확인
        ch[x][y] = true;
        int nx = x + 1;
        int ny = y;
        if (nx >= 0 && nx < N && map[nx][ny] == 1 && !ch[nx][ny]) {
            ch[nx][ny] = true;
            return col(L + 1, nx, ny);
        }

        return L;
    }

}
