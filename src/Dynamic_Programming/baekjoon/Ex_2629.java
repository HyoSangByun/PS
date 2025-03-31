package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_2629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //추의 갯수
        int[] items = new int[N];
        for (int i = 0; i < N; i++) {
            items[i] = sc.nextInt();
        }

        int M = sc.nextInt(); //구슬의 갯수
        int[] balls = new int[M];
        for (int i = 0; i < M; i++) {
            balls[i] = sc.nextInt();
        }


    }
}
