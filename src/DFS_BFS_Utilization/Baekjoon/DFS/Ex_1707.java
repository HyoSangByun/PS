package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_1707 { //백준 1707
    static int V, E;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors;  // 색상을 저장하는 배열 (0: 미방문, 1: 색상1, -1: 색상2)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            V = sc.nextInt();
            E = sc.nextInt();

            // 그래프 초기화
            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            // 간선 입력 받기
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u); // 무방향 그래프
            }

            // 색상 배열 초기화 (0은 방문하지 않음을 의미)
            colors = new int[V + 1];

            boolean isBipartite = true;
            // 모든 정점에 대해 확인 (그래프가 연결되지 않을 수도 있으므로)
            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {
                    if (!dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            // 결과 출력
            System.out.println(isBipartite ? "YES" : "NO");
        }
        sc.close();
    }

    // DFS를 통해 이분 그래프인지 확인
    private static boolean dfs(int node, int color) {
        colors[node] = color; // 현재 노드에 색을 칠함

        for (int neighbor : graph.get(node)) {
            // 인접한 정점이 아직 색칠되지 않은 경우
            if (colors[neighbor] == 0) {
                // 인접한 노드에 현재와 다른 색을 칠하고 DFS 재귀 호출
                if (!dfs(neighbor, -color)) {
                    return false;
                }
            }
            // 인접한 노드가 현재 노드와 같은 색이라면 이분 그래프가 아님
            else if (colors[neighbor] == colors[node]) {
                return false;
            }
        }
        return true;
    }
}

/*
    이분그래프

    인접한 정점은 다른 색상으로 저장하자. (1 or 2)
    방문하려는데 동일한 색상이 이미 칠해져 있으면 이분그래프가 아니다.
 */