import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Ex_11779 {
    static class Bus implements Comparable<Bus> {
        private int to;
        private int cost;

        public Bus(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static List<List<Bus>> ways = new ArrayList<>();
    static int[] record;
    static List<Integer> answers = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //도시의 개수
        M = sc.nextInt(); //버스의 개수

        for (int i = 0; i <= N; i++) {
            ways.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            ways.get(from).add(new Bus(to, cost));
        }

        int start = sc.nextInt();
        int dest = sc.nextInt();

        System.out.println(dijkstra(start, dest));
        findWay(start, dest);
        System.out.println(answers.size());
        Collections.reverse(answers);
        for (Integer answer : answers) {
            System.out.print(answer + " ");
        }
    }

    static int dijkstra(int start,int dest) {
        int dist[] = new int[N + 1];
        record = new int[N + 1];
        Arrays.fill(dist, 987654321);
        dist[start] = 0;
        PriorityQueue<Bus> pq = new PriorityQueue<>();

        pq.offer(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus poll = pq.poll();
            int currentNode = poll.to;
            int currentValue = poll.cost;

            if (currentValue > dist[currentNode]) continue;

            for (Bus next : ways.get(currentNode)) {
                int nextNode = next.to;
                int nextValue = currentValue + next.cost;

                if (nextValue < dist[nextNode]) {
                    dist[nextNode] = nextValue;
                    pq.offer(new Bus(nextNode, nextValue));
                    record[nextNode] = currentNode;
                }
            }
            
        }
        return dist[dest];
    }

    static void findWay(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(dest);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            answers.add(poll);
            if (poll != start ) queue.offer(record[poll]);
        }
    }
}
