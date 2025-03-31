package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_16928 {

    static HashMap<Integer, Integer> ladder = new HashMap<>();
    static HashMap<Integer, Integer> snake = new HashMap<>();
    static boolean[] visited = new boolean[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int from = sc.nextInt();
            int togo = sc.nextInt();
            ladder.put(from, togo);
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int togo = sc.nextInt();
            snake.put(from, togo);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll >= 94){
                    count++;
                    return count;
                }
                for (int j = 1; j <= 6; j++) {
                    int nx = poll + j;
                    if (snake.containsKey(nx)) {
                        nx = snake.get(nx);
                    }
                    if (ladder.containsKey(nx)) {
                        nx = ladder.get(nx);
                    }
                    if (!visited[nx]) {
                        visited[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            count++;
        }
        return count;
    }
}