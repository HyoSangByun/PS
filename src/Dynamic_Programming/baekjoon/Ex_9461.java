package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int max = Integer.MIN_VALUE;
        long[] dp = new long[101];

        int[] test = new int[T];
        for (int i = 0; i < T; i++) {
            int nextInt = sc.nextInt();
            test[i] = nextInt;
            max = Math.max(max, nextInt);
        }

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }

        for (int i : test) {
            System.out.println(dp[i]);
        }
    }
}

/*
    1 1 1 2 2 3 4 5(1)
    7 9 (2)
    12  (3) -- 11
    16 (4) -- 12

    21 (5) n - 3 + n - 2
    28 (7)?
    37 (9) n-3 + n -2
    n - 3 + n - 2
 */