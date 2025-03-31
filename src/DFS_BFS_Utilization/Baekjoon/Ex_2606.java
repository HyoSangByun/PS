package DFS_BFS_Utilization.Baekjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex_2606 {

    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();

            lists.get(i1).add(i2);
            lists.get(i2).add(i1);
        }
        ch = new boolean[N + 1];

        bfs();
        int answer =0;
        for (int i = 1; i <= N; i++) {
            if (ch[i])answer++;
        }

        System.out.println(answer - 1);
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        ch[1] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : lists.get(poll)) {
                if (!ch[i]) {
                    ch[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
}
