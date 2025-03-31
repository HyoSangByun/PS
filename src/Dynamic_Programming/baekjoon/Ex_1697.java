package Dynamic_Programming.baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1697 {

    static int N, K;
    static int[] dp = new int[100_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i <= 100_000; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[N] = 0;
        BFS();
        System.out.println(dp[K]);
    }

    private static void BFS() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            int[] nextPositions = {poll - 1, poll + 1, poll * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100_000) {
                    if (dp[next] > dp[poll] + 1) {
                        dp[next] = dp[poll] + 1;  // 최단 시간 갱신
                        queue.offer(next);
                    }
                }
            }
        }
    }

}
