package Swea;

import java.util.Scanner;

public class Ex_1209 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10 ; test_case++) {
            int[][] map = new int[100][100];
            int T = sc.nextInt();
            Integer max = Integer.MIN_VALUE;

            // 입력을 한 번만 수행
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int dia1 = 0;
            int dia2 = 0;

            // 연산
            for (int i = 0; i < 100; i++) {
                int sum1 = 0; // 가로 합
                int sum2 = 0; // 세로 합
                for (int j = 0; j < 100; j++) {
                    sum1 += map[i][j];
                    sum2 += map[j][i];
                }
                dia1 += map[i][i];
                dia2 += map[i][99 - i];
                max = Math.max(max, sum1);
                max = Math.max(max, sum2);
            }

            max = Math.max(max, dia1);
            max = Math.max(max, dia2);

            System.out.println("#" + test_case + " " + max);
        }
    }

}
