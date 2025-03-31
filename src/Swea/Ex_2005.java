package Swea;

import java.util.Scanner;

public class Ex_2005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > 0) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}

/*
1
1   1
1   2   1
1   3   3   1
1   4   6   4   1
 */