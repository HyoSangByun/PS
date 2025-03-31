package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_24416 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
//        arr[1] = 1;
//        arr[2] = 1;
//        if (N >= 3) {
//            for (int i = 3; i <= N; i++) {
//                arr[i] = arr[i-2] + arr[i-1];
//            }
//        }
        recur(N);
        System.out.println(count + " " + (N-2));
    }

    static int recur(int n) {
        if (n == 1 || n == 2) {
            count++;
            return n;
        } else {
            return recur(n - 2) + recur(n - 1);
        }
    }
}

/*
    5 -> 4 + 3 -> 3 2 + 2 1 -> 2 1 2 + 2 1

    3 4 5
 */