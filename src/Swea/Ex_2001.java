package Swea;

import java.util.Scanner;

public class Ex_2001 {
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < N - M + 1; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                //면적 더하기
                int sum = 0;
                for (int k = i; k < i + M; k++) {
                    for (int l = j; l < j + M; l++) {
                        sum += map[k][l];
                    }
                }
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);

    }

}
