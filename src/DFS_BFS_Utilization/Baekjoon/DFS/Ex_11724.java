package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_11724 {
    static int V, E;
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        int count = 0;
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (Integer i : lists.get(v)) {
            if (!visited[i]) dfs(i);
        }
    }
}
