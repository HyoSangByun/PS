package HashMap_TreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Ex_04_05 { //K번째 큰 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n - 2; i++) { //0 ~7
            for (int j = i + 1; j < n - 1; j++) { //1 ~ 8
                for (int l = j + 1; l < n; l++) { //2 ~ 9
                    int sum = arr[i] + arr[j] + arr[l];
//                    System.out.println(sum);
                    treeSet.add(sum);
                }
            }
        }

        if (treeSet.size() < k) {
            System.out.println(-1);
        } else {
            int answer = 0;
            for (int i = 0; i < k; i++) {
                answer = treeSet.pollFirst();
            }
            System.out.println(answer);
        }

    }
}
