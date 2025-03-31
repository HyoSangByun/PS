package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_9019 {
    static class DSLR {
        private int num;
        private String answer;

        public DSLR(int num, String answer) {
            this.num = num;
            this.answer = answer;
        }
    }

    static final int MOD = 10000;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            bfs(a,b);
        }
    }

    private static void bfs(int a, int b) {
        Queue<DSLR> Q = new LinkedList<>();
        visited = new boolean[10000];  // 각 테스트 케이스마다 초기화
        Q.offer(new DSLR(a, ""));
        visited[a] = true;  // 방문 체크는 큐에 넣을 때 바로 처리

        while (!Q.isEmpty()) {
            DSLR poll = Q.poll();

            if (poll.num == b) {
                System.out.println(poll.answer);
                return;
            }

            // D 연산
            int D = poll.num * 2 % MOD;
            if (!visited[D]) {
                visited[D] = true;
                Q.offer(new DSLR(D, poll.answer + 'D'));  // 문자열 생성 최소화
            }

            // S 연산
            int S = poll.num - 1;
            if (S == -1) S = 9999;
            if (!visited[S]) {
                visited[S] = true;
                Q.offer(new DSLR(S, poll.answer + 'S'));  // 문자열 생성 최소화
            }

            // L 연산 (자릿수 맞추기)
            int L = (poll.num % 1000) * 10 + poll.num / 1000;
            if (!visited[L]) {
                visited[L] = true;
                Q.offer(new DSLR(L, poll.answer + 'L'));  // 문자열 생성 최소화
            }

            // R 연산 (자릿수 맞추기)
            int R = (poll.num % 10) * 1000 + poll.num / 10;
            if (!visited[R]) {
                visited[R] = true;
                Q.offer(new DSLR(R, poll.answer + 'R'));  // 문자열 생성 최소화
            }
        }
    }
}
