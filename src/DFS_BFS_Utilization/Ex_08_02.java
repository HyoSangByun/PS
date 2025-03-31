package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_02 { //바둑이 승차(DFS
    static int n, W, max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0, 0, arr);
        System.out.println(max);
    }

    public static void DFS(int L, int sum, int[] arr) {
        if (sum > W || L > n) {
            return;
        } else {
            if (sum > max) max = sum;
            DFS(L+1, sum + arr[L], arr); //원소 사용함
            DFS(L+1, sum , arr); // 원소 사용 X
        }
    }
}

/*
    각 원소를 부분집합에 넣는다 안넣는다로 나눔
 */