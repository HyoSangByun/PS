package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 동전의 종류
        int k = sc.nextInt();  // 목표 금액

        int[] coins = new int[n];  // 동전들의 가치
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[k + 1];  // dp[i]는 i원을 만들 수 있는 경우의 수
        dp[0] = 1;  // 0원을 만드는 경우의 수는 1 (아무것도 선택하지 않는 경우)

        // 각 동전에 대해 dp 배열을 갱신
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }

        // k원을 만들 수 있는 경우의 수 출력
        System.out.println(dp[k]);
    }
}
