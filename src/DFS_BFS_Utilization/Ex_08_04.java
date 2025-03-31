package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_04 { //중복순열 구하기
    static int n, m, total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(1, 1, arr);
    }

    public static void DFS(int L, int i, int[] arr) {
        if (L == n && i == n) return;
        else if (i == n) {
            i = 1;
            DFS(L+1, i, arr);
            System.out.println(L + " " + i);

        }
        else {
            DFS(L, i + 1, arr);
            System.out.println(L + " " + i);
        }
    }

}
/*
    각 원소를 부분집합에 넣는다 안넣는다로 나눔
 */