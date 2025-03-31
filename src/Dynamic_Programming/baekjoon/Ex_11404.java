package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11404 {

    static int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //도시의 개수
        int M = sc.nextInt(); //버스의 개수

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = INF;

                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();

            arr[from][to] = Math.min(arr[from][to], cost);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == INF) {
                    sb.append(0).append(' '); // 도달 불가 시 0 출력
                } else {
                    sb.append(arr[i][j]).append(' ');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
