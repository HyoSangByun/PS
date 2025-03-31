package Sorting_Searching.baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.next().toCharArray();
        Integer[] arr = new Integer[charArray.length];
        int i = 0;
        for (char c : charArray) {
            arr[i] = Integer.parseInt(Character.toString(c));
            i++;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }

        System.out.println(sb);
    }
}
