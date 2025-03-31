package Dynamic_Programming.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex_11403 {

    static int N;
    static boolean[][] ch;
    static boolean[] visited;
    static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        ch = new boolean[N][N];
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nextInt = sc.nextInt();
                if (nextInt == 1) {
                    lists.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            find(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ch[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    private static void find(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited = new boolean[N];

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer togo : lists.get(poll)) {
                if (!visited[togo]) {
                    visited[togo] = true;
                    ch[i][togo] = true;
                    queue.offer(togo);
                }
            }
        }

    }
}
/*
0 -> 1
1 -> 2
2 -> 0

1 1 1
1 1 1
1 1

 */