package Sorting_Searching;

import java.util.HashSet;
import java.util.Scanner;

public class Ex_06_05 { //중복확인
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        if (set.size() == n) System.out.println("U");
        else System.out.println("D");
    }
}
