package DFS_BFS_Basic;

import java.util.Scanner;

/*
    방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하시오

    입력설명
    첫째 줄에는 정점의 수 N와 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다

    5 9
    1 2
    1 3
    1 4
    2 1
    2 3
    2 5
    3 4
    4 2
    4 5
 */
public class Ex_07_12 { //경로 탐색 (DFS)

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1; //출발점 체크
        DFS(1);
        System.out.println(answer);
    }

    public static void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;//백트래킹하면서 체크를 다시 풀어줌
                }
            }
        }
    }
}