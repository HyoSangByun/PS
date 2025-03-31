package Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_06_03 { //버블 정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int k = i - 1;
            int l = i;
            while ( k >= 0) {
                int i1 = arr[l]; //기준
                int i2 = arr[k]; //앞에 값

                if (i1 < i2) { //기준값이 앞에 값보다 작으면
                    arr[k] = i1;
                    arr[l] = i2;
                    k--;
                    l--;
                } else break;

            }

        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

/*
    삽입 정렬
    
    삽입 정렬은 두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후 자료를 뒤로 옮기고
    지정한 자리에 자료를 삽입하여 정렬하는 알고리즘이다.
    즉, 두 번째 자료는 첫 번째 자료, 세 번째 자료는 두 번째와 첫 번째 자료,
    네 번째 자료는 세 번째, 두 번째, 첫 번째 자료와 비교한 후 자료가 삽입될 위치를 찾는다.
    자료가 삽입될 위치를 찾았다면 그 위치에 자료를 삽입하기 위해 자료를 한 칸씩 뒤로 이동시킨다.
 */