package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_1003 { //백준 1003
    static class Fibo {
        private int zero, one;

        public Fibo(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            Fibo[] dy = new Fibo[N + 2];
            dy[0] = new Fibo(1, 0);
            dy[1] = new Fibo(0, 1);

            if (N <= 1) System.out.println(dy[N].zero + " " + dy[N].one);
            else {
                for (int j = 2; j <= N; j++) {
                    dy[j] = new Fibo(dy[j-2].zero +dy[j-1].zero, dy[j-2].one +dy[j-1].one);
                }
                System.out.println(dy[N].zero + " " + dy[N].one);
            }
        }
    }
}

/*
    피보나치 n이 실행될때
    0과 1이 각각 몇번 출력되는지 구하시오

    f(0) : 0 1번
    f(1) : 1 1번
    dy[2] = f(0) + f(1) = 1 //0: 1번 1: 1번
    dy[3] = f(1) + f(2) = 2 //0: 1번 1: 2번
    dy[4]=  f(2) + f(3) = // 0: 2번 1: 3번
 */