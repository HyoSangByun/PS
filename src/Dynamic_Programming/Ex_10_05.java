package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_10_05 { // 동전교환 (냅색 알고리즘)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);

        int K = sc.nextInt();
        int[] dy = new int[K + 1];
        for (int i = 0; i < K + 1; i++) {
            dy[i] = Integer.MAX_VALUE;
        }
        dy[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j ++) {
                dy[j] =  Math.min(dy[j - coins[i]] + 1, dy[j]);
            }
        }

        System.out.println(dy[K]);
    }
}

/*
    dy[i]는 i라는 금액을 만드는데 드는 최소 동전 갯수
 */