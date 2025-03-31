package Swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_1961 {
    static int N;
    static int[][] map;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N * N; i++) {
            list.add(sc.nextInt());
        }

        int[][] rotate90 = rotate90();
        int[][] rotate180 = rotate180();
        int[][] rotate270 = rotate270();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(rotate90[i][j]);
            }
            System.out.print(" ");
            for (int j = 0; j < N; j++) {
                System.out.print(rotate180[i][j]);
            }
            System.out.print(" ");
            for (int j = 0; j < N; j++) {
                System.out.print(rotate270[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] rotate90() {
        int[][] arr = new int[N][N];
        int i = 0;

        for (int k = N - 1; k >= 0; k--) {
            for (int l = 0; l < N; l++) {
                arr[l][k] = list.get(i);
                i++;
            }
        }

        return arr;
    }

    private static int[][] rotate180() {
        int[][] arr = new int[N][N];
        int i = 0;

        for (int k = N - 1; k >= 0; k--) {
            for (int l = N - 1; l >= 0; l--) {
                arr[k][l] = list.get(i);
                i++;
            }
        }

        return arr;
    }

    private static int[][] rotate270() {
        int[][] arr = new int[N][N];
        int i = 0;

        for (int k = 0; k < N; k++) {
            for (int l = N - 1; l >= 0; l--) {
                arr[l][k] = list.get(i);
                i++;
            }
        }

        return arr;
    }
}
