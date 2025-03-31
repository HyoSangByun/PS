package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_2458_02 {
    static int N, M;
    static List<List<Integer>> smallerList;  // 자신보다 키가 작은 학생들
    static List<List<Integer>> largerList;   // 자신보다 키가 큰 학생들
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 학생 수와 비교 횟수 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();

        smallerList = new ArrayList<>();
        largerList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            smallerList.add(new ArrayList<>());
            largerList.add(new ArrayList<>());
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a < b : a는 b보다 작다.
            smallerList.get(b).add(a);  // b보다 작은 학생은 a
            largerList.get(a).add(b);   // a보다 큰 학생은 b
        }

        int count = 0;

        // 모든 학생에 대해 자신보다 작은 학생 수 + 큰 학생 수 = N-1이면 자신의 순서를 알 수 있음
        for (int i = 1; i <= N; i++) {
            int smaller = dfs(smallerList, i, new boolean[N + 1]);
            int larger = dfs(largerList, i, new boolean[N + 1]);

            // 자신보다 작은 학생 수 + 자신보다 큰 학생 수 = N-1이면 자신의 순위를 알 수 있음
            if (smaller + larger == N - 1) {
                count++;
            }
        }

        System.out.println(count);
    }

    // DFS로 탐색하여 자신보다 작거나 큰 학생의 수를 셈
    static int dfs(List<List<Integer>> graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        int count = 0;

        for (int next : graph.get(vertex)) {
            if (!visited[next]) {
                count += 1 + dfs(graph, next, visited);  // 자신을 포함해서 계속 카운팅
            }
        }

        return count;
    }
}

/*
    DFS를 두 번 실행하는 방식으로 풀 수 있습니다.
    각 학생에 대해 자신보다 큰 학생과 작은 학생을 모두 알아낸 후, 순위를 확정할 수 있는 학생의 수를 계산해야 합니다.
 */