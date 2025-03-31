package DFS_BFS_Basic;

import java.util.ArrayList;
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
public class Ex_07_13 { //경로 탐색 (인접리스트, ArrayList)

    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<Integer>()); //ArrayList 객체 생성
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1; //출발점 체크
        DFS(1);
        System.out.println(answer);
    }

    public static void DFS(int v) {
        if (v == n) answer++;
        else {
            for (Integer nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
}

/*
    정점 갯수가 크면 배열을 이용하는 건 매우 비효율적임
    그래서 ArrayList를 이용하는게 좋다
    1번 리스트에는 1번 정점에서 갈수있는 정점을 기록해두고 마찬가지로 2번도

 */