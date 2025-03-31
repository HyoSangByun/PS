package BackTracking;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex_15663 {

    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] ch;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        answer = new int[M];
        ch = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        permu(0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void permu(int L) {
        if (L == M) {
            String s = "";
            for (int i : answer) {
                s += String.valueOf(i);
                s += " ";
            }
            set.add(s);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!ch[i]) {
                ch[i] = true;
                answer[L] = arr[i];
                permu(L + 1);
                ch[i] = false;

            }
        }
    }
}
