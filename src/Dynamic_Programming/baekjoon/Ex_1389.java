package Dynamic_Programming.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_1389 {

    static List<List<Integer>> lists = new ArrayList<>();
    static int[] ch;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        int[] answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            ch = new int[N+1];
            ch[i] = -1;
            find(i, 1);
            ch[i] = 0;
            for (int ch : ch) {
                answer[i] += ch;
            }
        }

        int min = Integer.MAX_VALUE;
        int person = 0;
        for (int i = 1; i <= N; i++) {
            if (answer[i] < min) {
                min = answer[i];
                person = i;
            }
        }

        System.out.println(person);
    }

    private static void find(int start, int L) {
        for (Integer i : lists.get(start)) {
            if (ch[i] == 0) {
                ch[i] = L;
                find(i, L + 1);
            } else {
                if (ch[i] > L) {
                    ch[i] = L;
                    find(i, L + 1);
                }
            }
        }
    }

}
