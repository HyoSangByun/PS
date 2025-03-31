package DFS_BFS_Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    1번 정점에서 각 정점으로 가는 최소 이동 간선 수를 출력하라

    6 9
    1 3
    1 4
    2 1
    2 5
    3 4
    4 5
    4 6
    6 2
    6 5
 */
public class Ex_07_14 { //그래프 최단거리(BFS)

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<Integer>()); //ArrayList 객체 생성
        }
        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1; //출발점 체크
        BFS(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i +  " : " + dis[i]);
        }
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }

            }
        }
    }
}

/*
    이 방식은 배열을 이용함
    배열에 거리를 기록해둠
    큐를 이용해 갈 수 있는 방법을 기록
 */