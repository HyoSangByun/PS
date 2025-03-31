package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_11725 {
    static int N;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 1) lists.get(a).add(b);
            else if (b == 1) {
                lists.get(b).add(a);
            }
            else {
                lists.get(a).add(b);
                lists.get(b).add(a);
            }
        }

        dp = new int[N + 1];
        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(dp[i]);
        }
    }
    private static void dfs(int vertex) {
        for (Integer i : lists.get(vertex)) {
            if (dp[i] == 0) {
                dp[i] = vertex;
                dfs(i);
            }
        }
    }

}
