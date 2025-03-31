package Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_06_08 { //이분검색 이진탐색
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(BinarySearch(0, n, key, arr) + 1);
    }

    public static int BinarySearch(int lt, int rt, int key, int[] arr) {
        int mid = 0;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) {
                return BinarySearch(lt, mid - 1, key, arr);
            } else return BinarySearch(mid + 1, rt, key, arr);
        }
        return -1;
    }

}

