package BackTracking;

import java.util.Scanner;

public class Ex_15649 {
    static int N, M;
    static boolean[] visited;
    static int[] sequence;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        sequence = new int[M];
        DFS(0);

    }

    static void DFS(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    sequence[count] = i;
                    DFS(count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
