package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_2011 {
    static final int MOD = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string1 = sc.nextLine();

        if (string1.equals("0")) {
            System.out.println(0);
            return;
        }

        int N = string1.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;  // 빈 문자열을 해석하는 경우의 수
        dp[1] = string1.charAt(0) != '0' ? 1 : 0;  // 첫 번째 숫자가 0이면 해석 불가

        for (int i = 2; i <= N; i++) {
            // 한 자리 숫자 확인 (i번째 문자)
            int oneDigit = Integer.parseInt(string1.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            // 두 자리 숫자 확인 (i-1번째와 i번째 문자)
            int twoDigit = Integer.parseInt(string1.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[N]);
    }
}

/*
    dp[i] = 첫번째 글자부터 i번째 글자까지 조합할수 있는 최대 갯수
    A : 1
    Z : 26

    로직은 비슷하나 암호가 잘못되어 암호를 해석할 수 없는 경우를 걸러줄 로직을 생각 잘못하였음.

    나는 두 자리의 숫자가 범위 안에 들어가는지만 확인하였음
    아래와 같이 처리를 해주어야 함
    1. 문자열 시작이 '0'인 경우 처리: 코드에서 첫 번째 문자가 '0'인 경우는 바로 0을 출력하고 종료합니다.
    2. 정확한 두 자리 숫자 검증: 두 자리 숫자가 10 이상 26 이하인지 확인하고, 이를 만족하는 경우에만 dp 값을 갱신합니다.
    3. dp 배열의 정확한 초기화: dp 배열을 올바르게 초기화하여 계산 시 오류를 방지합니다.
 */