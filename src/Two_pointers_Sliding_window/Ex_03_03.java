package Two_pointers_Sliding_window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex_03_03 { //최대 매출 (sliding window) !time limit exceed
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }


        int x = 0;
        int max = 0;
        while ( x + k <= n) {
            List<Integer> subList = list.subList(x, x + k);
            int sum = 0;
            for (Integer i : subList) {
                sum += i;
            }

            if(sum > max) max = sum;
            x++;
        }

        System.out.println(max);
    }
}

/*
sliding window는 O(n) 시간복잡도 가능

 */