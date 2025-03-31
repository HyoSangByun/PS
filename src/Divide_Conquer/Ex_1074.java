package Divide_Conquer;

import java.util.Scanner;

public class Ex_1074 {

    static int N, M, r, c;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = (int) Math.pow(2, N);
        r = sc.nextInt();
        c = sc.nextInt();

        divide(0, 0, M);
    }

    private static void divide(int row, int col, int length) {
        if (length == 1) {
            if (row == r && col == c) {
                System.out.println(count);
                System.exit(0);
            }
            count++;
            return;
        }

        int half = length / 2;
        int areaSize = half * half;

        if (r < row + half && c < col + half) { // 1사분면
            divide(row, col, half);
        } else if (r < row + half && c >= col + half) { // 2사분면
            count += areaSize;
            divide(row, col + half, half);
        } else if (r >= row + half && c < col + half) { // 3사분면
            count += 2 * areaSize;
            divide(row + half, col, half);
        } else { // 4사분면
            count += 3 * areaSize;
            divide(row + half, col + half, half);
        }
    }
}
