package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//프림
public class Ex_1197 {
    static class Edge implements Comparable<Edge> {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int V, E;
    static List<List<Edge>> list = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();

            list.get(v1).add(new Edge(v1, v2, w));
            list.get(v2).add(new Edge(v2, v1, w));
        }

        for (int i = 0; i <= V; i++) {
            Collections.sort(list.get(i));
        }

        find();
        System.out.println(answer);
    }

    private static void find() {
        visited[1] = true;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 1번 정점에서 출발하는 간선들을 우선순위 큐에 넣음
        for (Edge edge : list.get(1)) {
            pq.offer(edge);
        }

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();

            // 방문한 정점은 처리하지 않음
            if (visited[poll.to])
                continue;

            visited[poll.to] = true;
            answer += poll.weight;

            // 현재 정점에서 연결된 간선들을 우선순위 큐에 넣음
            for (Edge edge : list.get(poll.to)) {
                if (!visited[edge.to]) {
                    pq.offer(edge);
                }
            }
        }
    }
}
