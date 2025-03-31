package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dp = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int nextInt = sc.nextInt();
            sum += nextInt;
            dp[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(dp[b] - dp[a - 1]);
        }
    }

}
