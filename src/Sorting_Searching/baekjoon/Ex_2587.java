package Sorting_Searching.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int mid = 0;
        for (int i = 0; i < 5; i++) {
            int nextInt = sc.nextInt();
            arr[i] = nextInt;
            mid += nextInt;
        }

        Arrays.sort(arr);

        System.out.println(mid/5);
        System.out.println(arr[2]);
    }
}
