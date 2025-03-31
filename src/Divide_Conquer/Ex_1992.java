package Divide_Conquer;

import java.util.Scanner;

public class Ex_1992 {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String next = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = next.charAt(j) - '0';
            }
        }

        divide(0, 0, N);

        System.out.println(sb.toString());
    }

    private static void divide(int row, int col, int length) {
        if (isPossible(row, col, length)) {
            sb.append(map[row][col]);
            return;
        }

        sb.append('(');
        int newSize = length / 2;
        divide(row, col, newSize);
        divide(row, col + newSize , newSize);
        divide(row + newSize, col, newSize);
        divide(row + newSize, col + newSize, newSize);
        sb.append(')');
    }

    private static boolean isPossible(int row, int col, int length) {
        int color = map[row][col];

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
