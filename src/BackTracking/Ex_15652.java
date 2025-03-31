package BackTracking;

import java.util.Scanner;

public class Ex_15652 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        DFS(1, 0);

        System.out.println(sb.toString());
    }

    static void DFS(int start , int count) {
        if (count == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[count] = i;
            DFS(i, count + 1);
        }
    }

}

