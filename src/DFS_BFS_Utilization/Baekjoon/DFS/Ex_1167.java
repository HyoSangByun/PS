package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_1167 {
    static List<List<Vertex>> arr = new ArrayList<>();
    static boolean[] visited;
    static int maxLength = Integer.MIN_VALUE;
    static int maxVertex =0;
    static class Vertex {
        private int vertex;
        private int length;

        public Vertex(int vertex, int length) {
            this.vertex = vertex;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<Vertex>());
        }

        for (int i = 1; i <= N; i++) {
            int index = sc.nextInt();
            while (true) {
                int vertex = sc.nextInt();
                if (vertex == -1) break;
                int length = sc.nextInt();

                arr.get(index).add(new Vertex(vertex, length));
            }
        }

        visited = new boolean[N + 1];
        DFS(1, 0);

        visited = new boolean[N + 1];
        DFS(maxVertex, 0);


        System.out.println(maxLength);
    }

    static void DFS(int vertex, int length) {
        visited[vertex] = true;

        if (length > maxLength) {
            maxLength = length;
            maxVertex = vertex;
        }

        for (Vertex nextVertex : arr.get(vertex)) {
            if (!visited[nextVertex.vertex]) DFS(nextVertex.vertex, length + nextVertex.length);
        }
    }

}
