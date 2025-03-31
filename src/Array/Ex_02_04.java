package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_02_04 { //피보나치 수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        int a = 0;
        int b = 1;
        while (list.size() < n) {
            list.add( list.get(a) + list.get(b));
            a++;
            b++;
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
