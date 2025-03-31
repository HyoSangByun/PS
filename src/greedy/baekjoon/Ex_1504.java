package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_1504 {
    static class Vertex implements Comparable<Vertex>{
        private int to;
        private int length;

        public Vertex(int to, int length) {
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.length - o.length;
        }
    }

    static int V, E, mustToGO1, mustToGO2;
    static boolean[] checkVertex;
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static List<List<Vertex>> lists = new ArrayList<>();
    static final int INF = 200000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        dist = new int[V + 1];
        checkVertex = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int length = sc.nextInt();

            lists.get(v1).add(new Vertex(v2, length));
            lists.get(v2).add(new Vertex(v1, length));
        }

        mustToGO1 = sc.nextInt();
        mustToGO2 = sc.nextInt();

        int res1 = 0;
        res1 += dijkstra(1, mustToGO1);
        res1 += dijkstra(mustToGO1, mustToGO2);
        res1 += dijkstra(mustToGO2, V);

        // 1 -> v2 -> v1 -> N으로 가는 경우
        int res2 = 0;
        res2 += dijkstra(1, mustToGO2);
        res2 += dijkstra(mustToGO2, mustToGO1);
        res2 += dijkstra(mustToGO1, V);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(checkVertex, false);
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        pq.offer(new Vertex(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Vertex curNode = pq.poll();
            int cur = curNode.to;

            if (!checkVertex[cur]) {
                checkVertex[cur] = true;

                for (Vertex node : lists.get(cur)) {
                    if (!checkVertex[node.to] && dist[node.to] > dist[cur] + node.length) {
                        dist[node.to] = dist[cur] + node.length;
                        pq.add(new Vertex(node.to, dist[node.to]));
                    }
                }
            }
        }

        return dist[end];
    }
}
