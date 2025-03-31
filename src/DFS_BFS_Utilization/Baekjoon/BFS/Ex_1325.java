package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1325 { // 백준 1325
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int[] list = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();

            arrayList.get(i2).add(i1);
        }

        for (int i = 1; i <= N; i++) {
            if (!arrayList.get(i).isEmpty()) {
                ch = new boolean[N + 1];
                list[i] = BFS(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (list[i] == max) System.out.print(i + " ");
        }
    }

    static int BFS(int computer) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(computer);
        ch[computer] = true;
        int size = 1;

        while (!Q.isEmpty()) {
            Integer polled = Q.poll();

            for (int i : arrayList.get(polled)) {
                if (!ch[i]) {
                    Q.offer(i);
                    ch[i] = true;
                    size++;
                }
            }

        }

        max = Math.max(max, size);
        return size;
    }
}
