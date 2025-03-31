package Sorting_Searching;

import java.util.*;

public class Ex_06_07 { //좌표 정렬 !검색함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]); //2차원 배열 정렬 방법

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }
}

/*
    Comparable을 implement하는 함

 */