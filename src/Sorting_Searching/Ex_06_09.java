package Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_06_09 { //뮤직비디오 (결정알고리즘) !모르겠음
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


    }
}

/*
    결정알고리즘은 이분검색을 이용한 알고리즘
    lt부터 rt사이에 우리가 찾고자 하는 답이 분명히 있다고 확신을 해야만 결정 알고리즘을 적용할 수 있다!!
    중간값이 가능한 답이냐라고 물었을때 답이 되어야 한다

    lt는 답의 최솟값으로 rt는 답의 최대값으로 산정하자
 */