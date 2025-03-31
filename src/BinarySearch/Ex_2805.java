package BinarySearch;

import java.util.Scanner;

public class Ex_2805 {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        trees = new int[N];
        int max = Integer.MIN_VALUE;
        int min = 0;
        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            trees[i] = nextInt;
            max = Math.max(nextInt, max);
        }

        while (min < max) {
            int pivot = (min + max) / 2;

            long sum = 0;
            for (int treeHeight : trees) {

                if (treeHeight - pivot > 0) {
                    sum += (treeHeight - pivot);
                }
            }

            if (sum < M) {
                max = pivot;
            } else {
                min = pivot + 1;
            }

        }

        System.out.println(min - 1);
    }

}
