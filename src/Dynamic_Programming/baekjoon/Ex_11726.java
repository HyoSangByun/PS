package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11726 { // 백준11726
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N + 2];

        arr[1] = 1;
        arr[2] = 2;

        if (N >= 3) {
            for (int i = 3; i <= N; i++) {
                arr[i] = (arr[i - 2] + arr[i - 1]) % 10007;
            }
        }
        System.out.println(arr[N]);
    }
}

/*
    피보나치임
    n
    1 : 1
    2 : 2
    3 : 3
    4 : 5
    5 : 8
    6 : 13
    7 : 21
    8 : 34
    9 : 55
 */