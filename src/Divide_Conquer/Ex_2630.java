package Divide_Conquer;

import java.util.Scanner;

public class Ex_2630 {

    static int N;
    static int[][] map;
    static int blue = 0, white = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if(map[row][col] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;	// 절반 사이즈
        partition(row, col, newSize);						// 2사분면
        partition(row, col + newSize, newSize);				// 1사분면
        partition(row + newSize, col, newSize);				// 3사분면
        partition(row + newSize, col + newSize, newSize);	// 4사분면
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = map[row][col];	// 첫 번째 원소를 기준으로 검사

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                // 색상이 같이 않다면 false를 리턴
                if(map[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }
}
