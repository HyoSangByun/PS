package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_17406 {
    static class Cal {
        private int r;
        private int c;
        private int s;

        public Cal(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static int N, M, K;
    static int[][] map;
    static List<Cal> list = new ArrayList<>();
    static int[] orders;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];
        orders = new int[K + 1];
        visited = new boolean[K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int s = sc.nextInt();
            list.add(new Cal(r, c, s));
        }

        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int count) {
        if (count == K) {
            //연산 후 최댓값 구하기
            calculation();
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orders[count] = i;
                permutation(count + 1);
                visited[i] = false;
            }

        }
    }

    private static void calculation() {
        int[][] arr = new int[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = map[i].clone();
        }

        for (int j = 0; j < K; j++) {
            Cal cal = list.get(orders[j]);
            int startRow  = cal.r - cal.s;
            int startCol  = cal.c - cal.s;
            int endRow  = cal.r + cal.s;
            int endCol  = cal.c + cal.s;

            while (startRow < endRow && startCol < endCol) {
                int temp = arr[startRow][startCol]; // 회전의 시작값 저장

                // 좌측: 아래 → 위
                for (int i = startRow; i < endRow; i++) {
                    arr[i][startCol] = arr[i + 1][startCol];
                }

                // 하단: 오른쪽 → 왼쪽
                for (int i = startCol; i < endCol; i++) {
                    arr[endRow][i] = arr[endRow][i + 1];
                }

                // 우측: 위 → 아래
                for (int i = endRow; i > startRow; i--) {
                    arr[i][endCol] = arr[i - 1][endCol];
                }

                // 상단: 왼쪽 → 오른쪽
                for (int i = endCol; i > startCol; i--) {
                    arr[startRow][i] = arr[startRow][i - 1];
                }

                arr[startRow][startCol + 1] = temp; // 저장한 시작값 복구

                // 내부로 축소
                startRow++;
                startCol++;
                endRow--;
                endCol--;
            }
        }

        //각행 최댓값 구함
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += arr[i][j];
            }
            answer = Math.min(answer, sum);
        }
    }
}
