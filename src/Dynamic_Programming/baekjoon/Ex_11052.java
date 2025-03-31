package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dp[j] = Math.max(dp[j - i] + arr[i], dp[j]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1 ; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
