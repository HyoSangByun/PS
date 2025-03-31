package Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_06_06_02 { //장난꾸러기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        int rt = 0;
        int lt = 0;
        int key = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                lt = i+ 1;
                System.out.println("lt : " + arr[i]);

                break;
            }
        }

        for (int i = n - 1 ; i >= 0; i--) {
            if ( arr[i] < arr[i - 1]) {
                rt = i + 1;
                System.out.println("rt : " + arr[i]);
                break;
            }
        }



        System.out.println( rt + " " + lt );
    }
}
