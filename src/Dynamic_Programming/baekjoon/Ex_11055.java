package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(sc.nextInt());
            return;
        }

        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            arr[i] = nextInt;
            dp[i] = nextInt;
        }

        int answer = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}

/*
    현재 비교값이 앞선 부분합 값보다 더 클수도 있다는 점을 주의!
 */