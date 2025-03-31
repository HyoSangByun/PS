package Swea;

import java.util.*;

public class Ex_3752 {
    static int N;
    static int[] arr;
    static boolean[] check;
    static Set<Integer> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        set = new HashSet<>();
        dfs(0);
        for (Integer i : set) {
            System.out.println(i);
        }
    }

    private static void dfs(int L) {
        if (L == N) {
            int total = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) total += arr[i];
            }
            set.add(total);
        }
        else {
            check[L] = true;
            dfs(L + 1);
            check[L] = false;
            dfs(L + 1);
        }
    }
}
