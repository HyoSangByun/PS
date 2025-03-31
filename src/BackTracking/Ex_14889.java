package BackTracking;

import java.util.Scanner;

public class Ex_14889 {
    static int N, team1, team2, answer = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] red;
    static int[] blue;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];
        red = new int[N / 2];
        blue = new int[N / 2];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int idx, int L) {
        if (L == N / 2) {
            boolean[] booleans = new boolean[N];

            team1 = 0;
            team2 = 0;
            for (int i : red) {
                for (int j : red) {
                    team1 += arr[i][j];
                }
                booleans[i] = true;
            }

            int k=0;
            for (int i = 0; i < N; i++) {
                if (!booleans[i]) {
                    blue[k] = i;
                    k++;
                }
            }

            for (int i : blue) {
                for (int j : blue) {
                    team2 += arr[i][j];
                }
            }

            answer = Math.min(Math.abs(team1 - team2), answer);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                red[L] = i;
                visited[i] = true;
                DFS(i + 1, L + 1);
                visited[i] = false;
            }
        }

    }
}
