package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] dp = new int[N + 1][N + 1];
            int[] sum = new int[N + 1];

            for (int j = 1; j <= N; j++) {
                int nextInt = sc.nextInt();
                sum[j] = sum[j - 1] + nextInt;
            }

            // 1부터 K의 부분합을 구해야한다.
            // 1,2+3 과 1, 2+3 중 최소값을 DP에 저장한다.
            // 수가 많아진다면?
            // 최종적으로 묶어지는 두개의 합을 구하는 과정이므로 한 묶음을 A와 B라면
            // mid로 범위를 나누어 누적합을 더해주면 된다.
            // 1부터 N 범위의 값을 다 더해준 값과 비교해야한다.

            for(int end = 2; end <= N; end++) {		//목적지 2부터 시작
                for (int start = end - 1; start >= 1; start--) {  //출발지 end-1부터 시작해서 1까지
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int mid = start; mid < end; mid++) {        //중간지점 j부터 시작
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end]);    //최소값 정하기
                    }
                    dp[start][end] += sum[end] - sum[start - 1];        //비용합 더하기
                }
            }

            System.out.println(dp[1][N]);
        }
    }
}

/*
    dp[start][end] = Math.min(dp[start ][ end ] , dp[start][mid] + dp[mid + 1][end] + 누적합( sum[end] - sum[start-1] ));
    에서 mid의 값에 따라 최소값이 갈리게 된다

    더 간소화하면 sum[i] - sum[j-1]은 s가 범위 내 무슨 값이든 동일하기 때문에
    DP[j][i] = DP[i][s] + DP[s+1][j] 가 가장 작은 값에서 sum[i] - sum[j-1]을 해주면 됩니다.

    1. DP[i][j]의 값을 Integer.MAX_VALUE로 초기화해줍니다.

2. DP[1][2]을 시작으로 DP[1][K]까지 구해줍니다.

3. DP[1][K]을 결과로 출력합니다.
 */
