package DFS_BFS_Basic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1260 {

    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int startV = sc.nextInt();

        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();

            lists.get(i1).add(i2);
            lists.get(i2).add(i1);
        }

        for (int i = 0; i <= V; i++) {
            Collections.sort(lists.get(i));
        }

        ch = new boolean[V + 1];
        dfs(startV);
        System.out.println();
        ch = new boolean[V + 1];
        bfs(startV);
    }

    private static void dfs(int fromV) {
        ch[fromV] = true;
        System.out.print(fromV + " ");
        for (Integer i : lists.get(fromV)) {
            if (!ch[i]) {
                ch[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int startV) {
        Queue<Integer> queue = new ArrayDeque<>();
        ch[startV] = true;
        queue.offer(startV);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");

            for (Integer i : lists.get(poll)) {
                if (!ch[i]) {
                    ch[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
