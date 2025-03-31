package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_1967 {
    static class Vertex {
        private int toGo;
        private int distance;

        public Vertex(int toGo, int distance) {
            this.toGo = toGo;
            this.distance = distance;
        }
    }

    static List<List<Vertex>> list = new ArrayList<>();
    static int longestVertex;
    static int maxDistance = Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int toGO = sc.nextInt();
            int distance = sc.nextInt();

            list.get(from).add(new Vertex(toGO, distance));
            list.get(toGO).add(new Vertex(from, distance));
        }

        visited = new boolean[N + 1];
        DFS(1, 0);

        visited = new boolean[N + 1];
        DFS(longestVertex, 0);

        System.out.println(maxDistance);
    }

    static void DFS(int vertex, int distanceSum) {
        if (distanceSum > maxDistance) {
            maxDistance = distanceSum;
            longestVertex = vertex;
        }

        for (Vertex togo : list.get(vertex)) {
            if (!visited[togo.toGo]) {
                visited[vertex] = true;
                DFS(togo.toGo , distanceSum + togo.distance);
            }
        }
    }
}

/*
    트리의 최장 지름은 루트 노드에서 한번!
    그리고, 가장 긴 길이의 노드에서 한번 DFS하면 된다!

    또한, 각 정점은 한 번만 방문하면 됩니다.
    따라서, 한 번 방문한 정점은 다시 돌아갈 필요가 없기 때문에 visited[vertex] = false;로 되돌려줄 필요가 없습니다.
 */