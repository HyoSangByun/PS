package Dynamic_Programming.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 다익스트라 문제
 */
public class Ex_1238 {

    static final int INF = 87654321;

    static class Node implements Comparable<Node> {
        private int to;
        private int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(from).add(new Node(to, cost));
        }

        int[] distToX = dijkstra(X, graph, N); // 각 마을에서 X로 가는 최단 거리
        int maxTime = 0;

        for (int i = 1; i <= N; i++) {
            if (i == X) continue; // X에서 X로 가는 경로는 제외
            int[] distFromI = dijkstra(i, graph, N); // i에서 다른 모든 마을로 가는 최단 거리
            maxTime = Math.max(maxTime, distFromI[X] + distToX[i]); // 왕복 시간 계산
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(int start, List<List<Node>> graph, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.to;
            int nowCost = curr.cost;

            if (nowCost > dist[now]) continue;

            for (Node next : graph.get(now)) {
                int cost = nowCost + next.cost;
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }

        }

        return dist;
    }
}
