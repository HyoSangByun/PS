package Dynamic_Programming.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_2342 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (true) {
            int nextInt = sc.nextInt();
            if (nextInt == 0) break;
            else list.add(nextInt);
        }

        int size = list.size();
        int[][][] dp = new int[size][4][4];

        dp[1][list.get(0)][0] = 2;

    }
}

/*
    DP[i번째발판을 누를차례][왼발위치][오른발위치] //i번째까지 도달하는데 사용한 최소힘
 */