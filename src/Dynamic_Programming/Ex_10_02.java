package Dynamic_Programming;

import java.util.Scanner;

public class Ex_10_02 { //돌다리 건너기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dy = new int[N + 2];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= N + 1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        System.out.println(dy[N + 1]);
    }
}