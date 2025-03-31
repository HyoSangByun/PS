package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_2458 {
    static int N, M;                    // N : 학생의 수  /  M : 연산의 수
    static int[][] dist;                // floyd-warshall을 위한 2차원 배열
    static final int INF = 999999999;    // 초기화를 위한 불가능한 최댓값
    static int ans;                        // 출력할 정답

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // 1. 2차원 배열에 INF (최댓값)으로 초기화
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        // 2. 입력 : a - b 학생의 키 순서를 아는 경우 1로 거리 배열 입력
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            dist[a][b] = 1;
        }

        // 3. 특정 학생이 모든 학생과의 거리를 체크해야하므로 플로이드 워셜 수행
        // 플로이드-워셜 : 경유지 - 출발지 - 도착지 3중 for문
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // dist[i][j]보다 작은 값 나올 경우 갱신
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 4. 모든 학생과의 비교가 가능한 경우
        //    → 거리가 INF 가 아닌 학생의 수가 N-1인 경우 : 키가 몇번째인지 알 수 있으므로 ans++
        ans = 0;
        for (int i = 1; i <= N; i++) {
            int known = 0;

            // 자신보다 작거나 큰 학생 수를 확인
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (dist[i][j] != INF || dist[j][i] != INF) {
                    known++;
                }
            }

            // 자신보다 작은 학생 + 큰 학생의 수가 N-1명이라면, 순위를 알 수 있음
            if (known == N - 1) {
                ans++;
            }

            System.out.println(ans);
        }
    }
}

/*
    플로이드 워셜 알고리즘

    플로이드-와샬 알고리즘은 모든 정점에서 모든 정점으로 가는 최단 경로를 구하는 알고리즘입니다.
    이 알고리즘은 주로 그래프의 모든 쌍 최단 경로 문제를 해결하는데 사용됩니다.
    즉, 주어진 그래프에서 두 정점 사이의 최단 경로를 모두 구할 수 있습니다.

    N^3으로 모든 경우의 수를 체크하면서 최단 경로를 갱신하게 된다.
    이렇게 되면 최종적으로 dist[출발지][목적지]의 값은 최솟값임을 보장하게 된다.

    최단경로에 주로 쓰이는 플로이드-워셜을 활용하면,
    순서의 비교가 가능/불가능한지 응용할 수 있다.
 */