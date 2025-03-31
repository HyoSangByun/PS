package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        for (int i = 5; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            System.out.println(dp[M]);
        }

    }

}

/*
    n / 개수
    1 : 0
    2 : 0
    3 : 3? 1+1+1 1+2 2+1
    4 : 7
    5: 1+1+1+1+1, 2+1+1+1, 1+2+1+1, 1+1+2+1, 1+1+1+2, 3+1+1, 1+3+1, 1+1+3, 2+3, 3+2, 2+2+1, 2+1+2, 1+2+2
    6: 1...1  1개 / 2+1+1+1+1 * 5개 / 3+1+1+1 4개 / 2+2+2 1개 / 2+2+1+1, 2+1+2+1, 2+1+1+2, 1+2+1+2, 1+1+2+2 5개 / 3+2+1 6개/ 3+3 1게

    1  2  3  4  5   6   7  8   9  10   11
    1  2  4  7  13  26  44
     1  2  3  6   13
 */