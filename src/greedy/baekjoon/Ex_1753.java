package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_1753 {
    static class Edge implements Comparable<Edge> {
        private int to;
        private int width;

        public Edge(int to, int width) {
            this.to = to;
            this.width = width;
        }

        @Override
        public int compareTo(Edge o) {
            return this.width - o.width;
        }
    }

    static int V, E, start;
    static List<List<Edge>> lists = new ArrayList<>();
    static int[] dp;
    static boolean[] ch;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();
        dp = new int[V + 1];
        ch = new boolean[V + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int width = sc.nextInt();

            lists.get(from).add(new Edge(to, width));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (i == start) {
                System.out.println(0);
            } else {
                Object answer = (dp[i] == Integer.MAX_VALUE) ? "INF" : dp[i];
                System.out.println(answer);
            }
        }
    }

    private static void dijkstra() {

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start, 0));
        dp[start] = 0;
        while (!pQ.isEmpty()) {
            Edge poll = pQ.poll();
            ch[poll.to] = true;

            for (Edge edge : lists.get(poll.to)) {
                if (!ch[edge.to] && dp[poll.to] + edge.width < dp[edge.to]) {
                    dp[edge.to] = dp[poll.to] + edge.width;
                    pQ.offer(new Edge(edge.to, poll.width + edge.width));
                }
            }
        }

    }

}
