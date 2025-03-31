package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_11725 { //백준 11725
    static int N;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int[] answer;
    static boolean[] visited;
    static void BFS(int root) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            Integer poll = Q.poll();

            if (!arrayList.get(poll).isEmpty()) {
                for (int i : arrayList.get(poll)) {
                    if (!visited[i]) { // 방문하지 않은 노드만 큐에 넣음
                        visited[i] = true; // 방문 처리
                        answer[i] = poll; // 부모 노드를 기록
                        Q.offer(i); // 다음 노드를 큐에 추가
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        answer = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N - 1; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();

            if (i2 == 1) arrayList.get(i2).add(i1);
            else if (i1 == 1) {
                arrayList.get(i1).add(i2);
            } else {
                arrayList.get(i1).add(i2);
                arrayList.get(i2).add(i1);
            }
        }

        BFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}
