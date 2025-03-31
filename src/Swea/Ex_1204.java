package Swea;

import java.util.Scanner;

public class Ex_1204 {
    static int max;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            max = Integer.MIN_VALUE;
            arr = new int[1005];
            sc.nextInt();
            int answer = 0;
            for (int i = 0; i < 1000; i++) {
                int nextInt = sc.nextInt();
                arr[nextInt]++;
                if (arr[nextInt] > max) {
                    answer = nextInt;
                    max = arr[nextInt];
                } else if (arr[nextInt] == max && answer < nextInt) {
                    answer = nextInt;
                }
            }

            System.out.println("#"+test_case +" " + answer);
        }
    }
}
