package Two_pointers_Sliding_window;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_03_03_02 { //최대 매출 (sliding window) !time limit exceed
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
        while ( x + k < n) {
            int sum=0;

            for (int i = x; i < x+k; i++) {
                sum += list.get(i);
            }
            if(sum > max) max = sum;
            x++;
        }

        System.out.println(max);
    }
}