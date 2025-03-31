package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1912 {
    static int[] arr;
    static boolean[] ch;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        int max = Integer.MIN_VALUE;


        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 1], arr[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(i + " : " + dp[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}

/*
    1 : 10
    2 : 6
    3 : 9
    4 : 10
    5 : 15
    6 : 21
    7 : -14
    8 : 7
 */

/*
    1 : 2
    2 : 3
    3 : -1
    4 : 3
    5 : 7
    6 : 3
    7 : 9
    8 : 14
    9 : 9
    10 : 10
 */