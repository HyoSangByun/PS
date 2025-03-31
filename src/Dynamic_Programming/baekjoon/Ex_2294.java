package Dynamic_Programming.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dp = new int[K + 1];

        for (int i = 0; i < K + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }

        for (int i = 1; i < K + 1; i++) {
            for (Integer coin : set) {
                if (i-coin >= 0){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        if (dp[K] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[K]);
    }
}
/*
    Integer.MAX_VALUE는 자바에서 표현할 수 있는 가장 큰 정수 값으로, 그 값은 2,147,483,647입니다.
    이 값은 매우 크지만, 연산 과정에서 덧셈이 일어날 경우 오버플로우가 발생할 수 있습니다. 예를 들어, 다음과 같은 상황을 생각해보겠습니다:
    만약 dp[i - coin]이 Integer.MAX_VALUE일 때, dp[i - coin] + 1을 계산하면 그 값은 2,147,483,648이 되어 int 범위를 초과하게 됩니다.
 */