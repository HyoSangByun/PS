package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_13023 { //백준 13023
    static int N, M;
    static boolean flag = false;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();


        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();

            list.get(i1).add(i2);
            list.get(i2).add(i1);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            DFS(i, 0);
            if (flag) break;
        }

        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    static void DFS(int friend, int L) {
        if (L == 4) {
            flag = true;
            return;
        }

        if(!list.get(friend).isEmpty()) {
            for (Integer newFriend : list.get(friend)) {
                if (!visited[newFriend]) {
                    visited[newFriend] = true;
                    DFS(newFriend, L + 1);
                    if (flag) return;
                    visited[newFriend] = false;
                }
            }
        }
    }
}