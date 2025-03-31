package Dynamic_Programming.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_2565 {
    static class Line implements Comparable<Line>{
        private int A;
        private int B;

        public Line(int a, int b) {
            A = a;
            B = b;
        }

        @Override
        public int compareTo(Line o) {
            return this.A - o.A;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Line[] arr = new Line[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            arr[i] = new Line(A, B);
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i].B > arr[j].B) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(N - max);
    }
}

/*
    교차하기 위해선 본인보다 출발점은 낮고 도착점은 높은 전깃줄
    아니면 본인보다 출발점은 높고 도착점은 낮은 전깃줄
    8
    1 8 : 5     0
    3 9 : 4     4
    2 2 : 2     2
    4 1 : 3     2
    6 4 : 2     1
    10 10 : 0   0
    9 7 : 2     1
    7 6 : 2     1

    전깃줄이 교차하지 않는다는 것의 의미는 무엇일까?
    -> 전깃줄의 왼쪽 전봇대에서의 번호가 증가하는 순서대로, 오른쪽 전봇대에서의 번호도 증가한다는 것이다.

    1 8
    2 2
    3 9
    4 1
    6 4
    7 6
    9 7
    10 10

 */