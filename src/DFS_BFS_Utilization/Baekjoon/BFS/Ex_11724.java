package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_11724 { //백준 11724
    static int V, E;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] ch;
    static int[][] board, dis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        board = new int[V + 1][V + 1];
        ch = new int[V + 1];

        for (int i = 1; i <= E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            board[v1][v2] = 1;
            board[v2][v1] = 1;
        }

        ch[1] = 1;
        BFS(1);
        int count = 1;

        for (int i = 2; i <= V; i++) {
            if(ch[i] == 0) {
                BFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void BFS(int vertex) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(vertex);

        while (!Q.isEmpty()) {
            Integer pollVertex = Q.poll();

            for (int i = 1; i <= V; i++) {
                if ( board[pollVertex][i] == 1 && ch[i] == 0 ) { //다른 정점으로 갈 수 있다면
                    ch[i] = 1;
                    Q.offer(i);
                }
            }

        }

    }
}

/*
    연결 요소 (Connected Component)란?
    노드끼리 연결되어 있는 노드의 묶음

    static ArrayList<ArrayList<Integer>> graph;
    이 방식으로 하는게 배열보다 복잡도가 좋다
 */