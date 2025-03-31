package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_02 { //백준 11399
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        int sum = 0;
        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sum += list.get(j);
            }
        }

        System.out.println(sum);
    }
}
