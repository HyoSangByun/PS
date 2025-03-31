package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_9466 {
    static int[] arr;
    static boolean[] visit, done;    // 방문, 팀 편성 완료 배열
    static int count;    // 팀이 완성된 인원 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner로 변경

        int T = sc.nextInt(); // 테스트 케이스 개수 입력

        for (int p = 0; p < T; p++) {
            int n = sc.nextInt(); // 학생 수 입력
            arr = new int[n + 1];
            visit = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;

            // 학생 선택 입력
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            // 모든 학생에 대해 dfs 수행
            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }
            // 팀을 이루지 못한 학생의 수 출력
            System.out.println(n - count);
        }

        sc.close(); // Scanner 닫기
    }

    public static void dfs(int n) {
        // 이미 방문했을 때!
        if (visit[n]) {
            done[n] = true; // 팀 편성 완료 처리
            count++; // 팀 편성 완료된 인원 증가
        } else {
            // 방문하지 않았을 때 -> 방문 처리
            visit[n] = true;
        }

        // 다음 학생이 팀 결성을 아직 못했을 경우
        if (!done[arr[n]]) {
            dfs(arr[n]);
        }

        visit[n] = false;
        done[n] = true;
    }
}
