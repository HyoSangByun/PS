package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.*;

public class Ex_4803 {
    static int N;
    static int M;
    static int[] visited;
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = 1;

        while (true) {
            N = sc.nextInt();
            M = sc.nextInt();
            if (N == 0 && M == 0 ) break;

            visited = new int[N + 1];
            lists = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                lists.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                lists.get(a).add(b);
                lists.get(b).add(a);
            }
            int count = 0;

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) { // 아직 방문하지 않은 경우에만 BFS 실행
                    if (BFS(i)) {
                        count++;
                    }
                }
            }


            if (count > 1) {
                System.out.println("Case " + testcase + ": A forest of " + count + " trees.");
            } else if (count == 1) {
                System.out.println("Case " + testcase + ": There is one tree.");
            } else {
                System.out.println("Case " + testcase + ": No trees.");
            }
            testcase++;
        }
        sc.close();
    }

    static boolean BFS(int vertex) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{vertex, -1}); // {현재 정점, 부모 정점}
        visited[vertex] = vertex;

        while (!Q.isEmpty()) {
            int[] poll = Q.poll();
            int current = poll[0];
            int parent = poll[1];

            for (int togo : lists.get(current)) {
                if (visited[togo] == 0) {
                    visited[togo] = vertex;
                    Q.offer(new int[]{togo, current}); // 자식으로 이동할 때 부모 정보를 업데이트
                } else if (togo != parent) {
                    // 부모가 아닌 정점으로 돌아가면 사이클이 존재
                    visited[vertex] = -1; //트리가 아님을 표시
                    return false; // 사이클이 발견된 경우
                }
            }
        }
        return true; // 사이클이 발견되지 않음
    }

}
