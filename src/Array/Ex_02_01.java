package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_02_01 { //큰 수 출력하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < n; i++) {
            if(array[i] > array[i-1]) list.add(array[i]);
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
