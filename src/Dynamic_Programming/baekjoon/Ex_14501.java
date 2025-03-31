package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 남은 N일
        int[] T = new int[N + 1];  // 상담 기간
        int[] P = new int[N + 1];  // 상담 금액
        int[] dp = new int[N + 2];  // DP 테이블 (최대 수익 저장용)

        // 입력 받기
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        // 역순으로 DP 계산
        for (int i = N; i > 0; i--) {
            int nextDay = i + T[i];  // 상담이 끝난 후의 다음 가능한 날
            if (nextDay <= N + 1) {  // 상담을 할 수 있는 경우
                dp[i] = Math.max(dp[i + 1], P[i] + dp[nextDay]);  // 상담을 하는 경우와 안 하는 경우 중 최대값
            } else {
                dp[i] = dp[i + 1];  // 상담을 할 수 없으면 그냥 다음 날의 값을 가져옴
            }
        }

        // 최대 이익 출력
        System.out.println(dp[1]);
    }
}

/*
    입력을 통해 상담 일수(Ti)와 상담 금액(Pi)를 배열에 저장합니다.
마지막 날부터 역순으로 계산합니다.
현재 날에 상담을 할 수 있다면, 그 상담을 했을 때 얻는 금액과 다음에 가능한 날에 얻을 수 있는 최대 금액을 더한 값으로 DP 배열을 갱신합니다.
상담을 하지 않는 경우에는, 다음 날의 최대 금액을 현재 날의 DP에 그대로 가져옵니다.
dp[0]에서부터 마지막 날까지의 값을 계산하고, 그 중에서 최대값을 구합니다.
 */