package Dynamic_Programming.baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Ex_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dp[i] = 100005;
        }
        dp[0] = 0;

        HashSet<Double> set = new HashSet<>();
        for (int i = 1; i < N + 1; i++) {
//            double key = Math.sqrt(i) % 1;

            double coin = Math.floor(Math.sqrt(i)) * Math.floor(Math.sqrt(i));
            set.add(coin);
            for (Double dd : set) {
                dp[i] = Math.min( dp[(int) (i - dd)] + 1, dp[i] );
            }
        }

//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
        System.out.println(dp[N]);
    }
}

/*
    하나의 제곱수만을 고려하기 때문에 다양한 제곱수의 조합을 고려하지 않는다 것이 첫번째 풀이의 오류였다.
 */