package Array;

import java.util.Scanner;

public class Ex_02_09 { //격자판 최대합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        //세로
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < n; j++) {
                k += arr[i][j];
                if(k > max) max=k;
            }
        }
        //가로
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < n; j++) {
                k += arr[j][i];
                if(k > max) max=k;
            }
        }
        //대각선1
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            c1 += arr[i][i];
        }
        if(c1 > max) max=c1;

        //대각선2
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            c2 += arr[i][n-i-1];
        }
        if (c2 > max ) max = c2;

        System.out.println(max);
    }
}

/*
행과 열 합을 따로 구하는 게 아니라
이중포문 안에서 arr[i][j] 와 arr[j][i]를 각각 구할 수 있다
대각선도 마찬가지로 이중포문 안에서 각각 대각선을 구할 수 있다.
 */