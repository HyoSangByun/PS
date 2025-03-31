package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_1707_02 { //백준 1707
    static int V, E;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static int[] colors;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            V = sc.nextInt();
            E = sc.nextInt();

            lists = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                lists.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                lists.get(a).add(b);
                lists.get(b).add(a);
            }

            colors = new int[V + 2];

            if (dfs(1,0)) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }

    private static boolean dfs(int vertex, int color) {
        colors[vertex] = color;

        if (vertex == V) {
            visited = new boolean[V + 1];

            if (check(vertex, color)) {
                return true;
            }
        }

        dfs(vertex + 1, 0);
        dfs(vertex + 1, 1);

        return false;
    }

    private static boolean check(int vertex, int color) {

        for (Integer togo : lists.get(vertex)) {
            if (!visited[togo]) {
                visited[togo] = true;
                if (color == colors[togo]) return false;
                else return check(togo, colors[togo]);
            }
        }

        return false;
    }
}

/*
    이분그래프

    인접한 정점은 다른 색상으로 저장하자. (1 or 2)
    방문하려는데 동일한 색상이 이미 칠해져 있으면 이분그래프가 아니다.
 */