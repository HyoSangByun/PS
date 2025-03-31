package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_15654 {
    static int N, M;
    static int[] answer;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        answer = new int[M];
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        combi(0);
        System.out.println(sb.toString());
    }

    private static void combi( int count) {
        if (count == M) {
            for (int i : answer) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[count] = arr[i];
                combi(count + 1);
                visited[i] = false;
            }
        }
    }
}
