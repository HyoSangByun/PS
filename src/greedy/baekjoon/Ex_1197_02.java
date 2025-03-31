package greedy.baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

//크루스칼
public class Ex_1197_02 {
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
    static int[] parent;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();

            queue.offer(new Edge(v1, v2, w));
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            //부모 노드가 다를 때만 (사이클 X)
            if (find(poll.to) != find(poll.from)) {
                union(poll.from, poll.to);
                sum += poll.weight;
            }
        }

        System.out.println(sum);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);


        if(rootX < rootY)
            parent[rootY] = rootX;
        else if(rootX > rootY)
            parent[rootX] = rootY;
    }
}
