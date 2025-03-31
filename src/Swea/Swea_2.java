package Swea;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Swea_2 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            int num = 1; // 배열에 채울 숫자
            int row = 0, col = 0; // 시작 위치
            int dir = 0; // 방향: 0=우, 1=하, 2=좌, 3=상
            int[] dr = {0, 1, 0, -1}; // 행의 변화량
            int[] dc = {1, 0, -1, 0}; // 열의 변화량

            while (num <= N * N) {
                arr[row][col] = num++; // 현재 위치에 숫자 채우기
                int nextRow = row + dr[dir];
                int nextCol = col + dc[dir];

                // 배열의 경계를 넘거나 이미 숫자가 채워진 경우
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || arr[nextRow][nextCol] != 0) {
                    dir = (dir + 1) % 4; // 방향을 시계방향으로 변경
                    nextRow = row + dr[dir];
                    nextCol = col + dc[dir];
                }

                row = nextRow;
                col = nextCol;
            }

            // 결과 출력
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}