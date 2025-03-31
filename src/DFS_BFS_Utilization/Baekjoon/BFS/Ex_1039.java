package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex_1039 {

    static int M;
    static int answer = -1;
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        M = sc.nextInt();

        StringBuilder sb = new StringBuilder(String.valueOf(a));
        char[] charArray = sb.toString().toCharArray();

        bfs(charArray, 0);

        System.out.println(answer);
    }

    private static void bfs(char[] a, int L) {
        String state = new String(a) + "," + L;

        if (visited.contains(state)) {
            return;
        }
        visited.add(state);

        if (L == M) {
            int cur = 0;
            int b = 1;
            for (int i = a.length - 1; i >= 0; i--) {
                cur += Character.getNumericValue(a[i]) * b;
                b *= 10;
            }

            answer = Math.max(answer, cur);
            return;
        }

        for (int i = 0; i < a.length - 1; i++) {
            char tmp = a[i];
            for (int j = i+1; j < a.length; j++) {
                a[i] = a[j];
                a[j] = tmp;
                if (a[0] != '0') {
                    bfs(a, L + 1);
                }
                a[j] = a[i];
                a[i] = tmp;
            }
        }
    }



}
