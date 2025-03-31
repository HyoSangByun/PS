package Implement;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_2448 {

    static int N;
    static char[][] stars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        stars = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }
        star(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void star(int r, int c, int size) {
        if (size == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
        }
        else {
            int newSize = size/2;
            star(r, c, newSize);
            star(r + newSize, c - newSize, newSize);
            star(r + newSize, c + newSize, newSize);
        }

    }

}
