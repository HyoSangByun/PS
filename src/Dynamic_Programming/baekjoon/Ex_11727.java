package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11727 {
    static final int MOD = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[1001];

        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i-2]*2 + arr[i-1]) % MOD;
        }

        System.out.println(arr[N]);
    }
}
