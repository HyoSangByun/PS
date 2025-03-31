package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_02_02 { //보이는 학생
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(array[0]);
        int max = array[0];

        for (int i = 1; i < n; i++) {
            if(max < array[i]) {
                max = array[i];
                list.add(array[i]);
            }
        }

        System.out.println(list.size());
    }
}
