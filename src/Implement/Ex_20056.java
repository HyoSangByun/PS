package Implement;

import java.util.Scanner;

public class Ex_20056 {
    static class Fireball {
        private int m; //질량
        private int d; //방향
        private int s; //속력

        public Fireball(int m, int d, int s) {
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
    static Fireball[][] map;
    static int N, M, K;
    static int fireballCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //격자 크기
        M = sc.nextInt(); //파이어볼 초기 발사 갯수
        K = sc.nextInt(); //명령어 횟수
        map = new Fireball[N][N];
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int m = sc.nextInt(); //질량
            int s = sc.nextInt(); //속도
            int d = sc.nextInt(); //방향

            map[r][c] = new Fireball(m, d, s); //격자에 초기 파이어볼을 넣어둠
        }

        for (int i = 0; i < K; i++) {
            moveFireball();
        }
    }

    private static void moveFireball() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

            }
        }
    }
}
