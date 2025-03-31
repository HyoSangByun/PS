package greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_09_07_02 { //내가 BFS로 푼것
    static int N, M, L, K;
    static boolean ch[];
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    static String BFS(int student) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(student);
        ch[student] = true;
        while (!Q.isEmpty()) {
            Integer poll = Q.poll();

            if (!arrayList.get(poll).isEmpty()) {
                for (int newFriend : arrayList.get(poll)) {
                    if (!ch[newFriend]) {
                        if (newFriend == K) return "YES";
                        ch[newFriend] = true;
                        Q.offer(newFriend);
                    }
                }
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }
        ch = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();

            arrayList.get(i1).add(i2);
            arrayList.get(i2).add(i1);
        }

        L = sc.nextInt();
        K = sc.nextInt();

        System.out.println(BFS(L));
    }
}

