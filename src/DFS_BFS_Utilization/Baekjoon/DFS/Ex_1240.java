package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_1240 {
    static class Vertex {
        private int togo;
        private int distance;

        public Vertex(int togo, int distance) {
            this.togo = togo;
            this.distance = distance;
        }
    }
    static List<List<Vertex>> lists = new ArrayList<>();
    static boolean[] visited;
    static int N, M, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int distance = sc.nextInt();

            lists.get(a).add(new Vertex(b, distance));
            lists.get(b).add(new Vertex(a, distance));
        }

        for (int i = 0; i < M; i++) {
            visited = new boolean[N + 1];
            int a = sc.nextInt();
            int b = sc.nextInt();
            dfs(a,b,0);
            System.out.println(answer);
        }
    }

    private static void dfs(int a, int b, int distance) {
        visited[a] = true;
        if (a == b) {
            answer = distance;
            return;
        }
        else {
            for (Vertex vertex : lists.get(a)) {
                if (!visited[vertex.togo]) {
                    dfs(vertex.togo, b, distance + vertex.distance);
                }
            }
        }
    }


}

/*
    2   1   4   3
      2   3   2
 */