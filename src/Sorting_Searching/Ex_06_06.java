package Sorting_Searching;

import java.util.Scanner;

public class Ex_06_06 { //장난꾸러기 !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0;
        int rt = 0;
        int key = 0;
        for (int i = n - 1 ; i > 0; i--) {
            if ( arr[i] < arr[i - 1]) {
                lt = i + 1;
                key = arr[i];
                break;
            }
        }
        System.out.println(key);
        System.out.println(lt);

        for (int i = lt - 2; i >= 0; i--) {
//            System.out.println(i);
            if (key >= arr[i]) {
                rt= i + 2;
                break;
            }
        }

        System.out.println( rt + " " + lt );
    }
}

/*
    배열 2개를 이용해서
    하나는 정렬하고 하나는 원래 배열을 비교

 */