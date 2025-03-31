package Array;

import java.util.*;

public class Ex_02_08 { //등수 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) count++;
            }
            System.out.print(count + " ");
        }
    }
}
