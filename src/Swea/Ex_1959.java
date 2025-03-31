package Swea;

import java.util.Scanner;

public class Ex_1959 {
    static int N, M;
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr1 = new int[N];
        arr2 = new int[M];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        int big = Math.max(M, N);
        int small = Math.min(M, N);
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < big - small + 1; i++) { //큰 배열의 시작점
            int sum = 0;
            for (int j = 0; j < small; j++) {
                if (N < M) {
                    sum += arr1[j] * arr2[i + j];
                }else {
                    sum += arr2[j] * arr1[i + j];
                }
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
