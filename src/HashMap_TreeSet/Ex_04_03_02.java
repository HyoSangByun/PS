package HashMap_TreeSet;

import java.util.HashSet;
import java.util.Scanner;

public class Ex_04_03_02 { //매출액의 종류
    public static void main(String[] args) {
        /*
            7 4 n k
            20 12 20 10 23 17 10
            20 12 20 10     3   20 12 10
            12 20 10 23     4   12 10 20 23
            20 10 23 17     4   20 10 23 17
            10 23 17 10     3   10 23 17
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashSet<Integer> firstSet = new HashSet<>();

        for (int i = 0; i < k; i++) {
            firstSet.add(arr[i]);
        }
        System.out.print(firstSet.size() + " ");

        for (int i = k + 1; i <= n; i++) {
            firstSet.remove(arr[i-k-1]);
            firstSet.add(arr[i-1]);
            System.out.println(firstSet);
            System.out.print(firstSet.size() + " ");

        }

    }
}
