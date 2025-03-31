package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_1916 {

    static class Bus implements Comparable<Bus> {
        private int to;
        private int value;

        public Bus(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Bus o) {
            return this.value - o.value; // 비용 오름차순 정렬
        }
    }

    static int N, M;
    static List<List<Bus>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 버스 정보 입력
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int value = sc.nextInt();

            graph.get(from).add(new Bus(to, value));
        }

        int start = sc.nextInt(); // 시작점
        int dest = sc.nextInt();  // 도착점

        // 최단 거리 계산
        System.out.println(dijkstra(start, dest));
    }

    private static int dijkstra(int start, int dest) {
        // 최단 거리 배열 초기화
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 우선순위 큐 초기화
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus current = pq.poll();
            int currentNode = current.to;
            int currentValue = current.value;

            // 이미 처리된 노드는 스킵
            if (currentValue > dist[currentNode]) {
                continue;
            }

            // 현재 노드와 연결된 다른 노드들 확인
            for (Bus next : graph.get(currentNode)) {
                int nextNode = next.to;
                int nextValue = currentValue + next.value;

                // 더 짧은 경로 발견 시 갱신
                if (nextValue < dist[nextNode]) {
                    dist[nextNode] = nextValue;
                    pq.offer(new Bus(nextNode, nextValue));
                }
            }
        }

        // 도착지 최단 거리 반환
        return dist[dest];
    }

}
