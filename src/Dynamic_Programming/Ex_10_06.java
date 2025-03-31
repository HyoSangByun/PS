package Dynamic_Programming;

import java.util.Scanner;

public class Ex_10_06 { //최대 점수 구하기 (냅색 알고리즘)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dy = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();

            for (int j = M; j >= time ; j--) {
                dy[j] = Math.max(dy[j - time] + score, dy[j]);
            }
        }

        System.out.println(dy[M]);
    }
}

/*
    dy[j] 는 j분 안에 풀 수 있는 최대 점수
 */