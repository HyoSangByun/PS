package Two_pointers_Sliding_window;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_03_01 { //두 배열 합치기 (two pointers  알고리즘) !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list1.add(sc.nextInt());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            list1.add(sc.nextInt());
        }

        list1.sort(null);
        for (Integer i : list1) {
            System.out.print(i + " ");
        }


    }
}

/*
two pointer 알고리즘은 O(n)시간복잡도
 */