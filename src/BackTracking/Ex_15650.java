package BackTracking;

import java.util.Scanner;

public class Ex_15650 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        DFS(0, 1);

    }

    static void DFS(int count, int start) {
        if (count == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[count] = i;
            DFS(count + 1, i + 1);
        }
    }

}

