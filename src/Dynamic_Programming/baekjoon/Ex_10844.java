package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_10844 { //Top-Down 방식 (재귀)
    static Long[][] dp;
    final static long MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        //
        dp = new Long[N + 1][10];

        // 첫번째 자리수(일의 자리)는 경우의 수가 1이므로 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result += recur(N,i);
        }

        System.out.println(result % MOD);
    }

    static long recur(int digit, int val) { //digit은 자릿수, val은 자릿값

        // 첫째 자리수에 도착하면 더이상 탐색할 필요가 없음
        if (digit == 1) {
            return dp[digit][val];
        }

        // 해당 자리수를 탐색하지 않았을 경우
        if (dp[digit][val] == null) {
            //val이 0인 경우 경우의수는 하나
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1);
            }
            //val이 9인 경우 경의수는 하나
            else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8);
            }
            else {
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }

        return dp[digit][val] % MOD;
    }
}

/*
    1 : 9
    2 : 17
    3 : 26
    ...
 */