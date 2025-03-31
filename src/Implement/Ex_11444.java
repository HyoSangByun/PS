package Implement;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_11444 {
    static final int MOD = 1000000007;
    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        memo = new long[(int) (N + 1)];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        if (N > 0) memo[1] = 1; // N이 1 이상일 때만 memo[1] 초기화

        System.out.println(Fibo(N));
    }

    static long Fibo(long N) {
        if (N == 0 || N == 1) { // N이 0 또는 1일 경우 바로 반환
            return memo[(int) N];
        }
        if (memo[(int) N] < 0) {
            return memo[(int) N] = (Fibo(N - 1) + Fibo(N - 2)) % MOD;
        } else {
            return memo[(int) N];
        }
    }

}
