package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1463 { //백준 1463
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // dp 배열 생성 (최솟값을 저장)
        int[] dp = new int[N + 1];

        // 1은 이미 1이므로 0번의 연산이 필요
        dp[1] = 0;

        // 2부터 N까지의 모든 숫자에 대해 최소 연산 횟수 계산
        for (int i = 2; i <= N; i++) {
            // 1을 뺀 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나눌 수 있는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나눌 수 있는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        // 결과 출력
        System.out.println(dp[N]);
    }
}
