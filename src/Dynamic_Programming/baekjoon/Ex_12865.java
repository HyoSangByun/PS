package Dynamic_Programming.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_12865 {
    static class Item implements Comparable<Item> {
        private int w;
        private int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Item o) {
            if (this.w == o.w) return o.v - this.v;
            else return this.w - o.w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int bagSize = sc.nextInt();

        Item[] arr = new Item[N+1];
        int[][] dp = new int[N + 1][bagSize + 1];

        for (int i = 1; i <= N; i++) {
            int weight = sc.nextInt(); //0
            int value = sc.nextInt(); //1

            arr[i] = new Item(weight, value);
        }

        for(int i = 1 ; i <= N ; i++) { //i는 아이템을 의미
            for(int j = 1; j <= bagSize; j++) { //j는 현재 가방 크기를 의미
                if(j - arr[i].w >= 0) // 가방에 현재 아이템을 넣을수 있다면
                    dp[i][j] = Math.max(dp[i - 1][j], arr[i].v + dp[i - 1][j - arr[i].w]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][bagSize]);
    }
}
/*
    각 열의 무게에서 자신의 무게를 뺀 값이 0 이상이라면 나의 가치가 들어간다!!!
    여기서 하나의 예외를 고려해줘야 합니다. 만약에 0 미만이라면???

    dp[i-1][j]가 의미하는 것
    자신의 위 즉, 이전 아이템들에서 가질 수 있는 최대의 가치입니다.

    arr[i].v가 의미하는 것
    자신의 가치를 의미합니다.

    dp[i-1][j-arr[i].w]이 의미하는 것
    현재 무게(j)에서 자신의 무게를 뺀 곳의 최대 가치를 의미합니다.

    즉,
    Math.max( dp[i-1][j] , arr[i].v + dp[i-1][j-arr[i].w])는
    이전 아이템이 가질 수 있는 최댓값 vs 자신의 값 + 최대 무게가 넘어가지 않는 다른 물건들에서 가질 수 있는 최대 가치
 */