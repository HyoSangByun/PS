package BackTracking;

import java.util.Scanner;

public class Ex_14888 {
    static int N, calCount;
    static int[] num;
    static int[] cal = new int[4]; // +, -, *, /
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            int nextInt = sc.nextInt();
            cal[i] = nextInt;
            calCount += nextInt;
        }

        DFS(num[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int value ,int rt) {
        if (rt == N) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                if (i == 0) {
                    cal[i]--;
                    DFS(value + num[rt], rt + 1);
                } else if (i == 1) {
                    cal[i]--;
                    DFS(value - num[rt], rt + 1);
                } else if ( i == 2) {
                    cal[i]--;
                    DFS(value * num[rt], rt + 1);
                } else if ( i == 3) {
                    cal[i]--;
                    DFS(value / num[rt], rt + 1);
                }
                cal[i]++;
            }
        }

    }
}
