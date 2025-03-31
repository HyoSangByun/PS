package Sorting_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex_06_01 { //선택 정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            arr[i] = Collections.min(list);
            list.remove(Collections.min(list));
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

/*
    선택 정렬
    해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘
    첫 번째 순서에는 첫 번째 위치에 가장 최솟값을 넣는다.
    두 번째 순서에는 두 번째 위치에 남은 값 중에서의 최솟값을 넣는다.
    …
 */

/*
이중포문으로 구현
i, j = i+1

j가 돌면서 i~n까지 중 최소값을 idx로 설정
 */