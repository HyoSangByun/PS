package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dpLR = new int[N];
        for (int i = 0; i < N; i++) {
            dpLR[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpLR[i] = Math.max(dpLR[j] + 1, dpLR[i]);
                }
            }
        }

        int[] dpRL = new int[N];
        for (int i = N-1; i >= 0; i--) {
            dpRL[i] = 1;
            for (int j = N-1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpRL[i] = Math.max(dpRL[j] + 1, dpRL[i]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dpLR[i] + dpRL[i]);
        }
        System.out.println(answer - 1);
    }
}

/*
      10
      1 5 2 1 4 3 4 5 2 1

dp    1 2 2 1 3 3 4 5 2 1
min   1 1
max     5
 */