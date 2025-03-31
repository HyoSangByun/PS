package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex_14983 {
    static class Land {
        private int to;
        private int length;

        public Land(int to, int length) {
            this.to = to;
            this.length = length;
        }
    }

    static int N, M;
    static int[] items;
    static List<List<Land>> lists = new ArrayList<>();
    static Set<Integer> canGO;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }
        ch = new int[N + 1];
        items = new int[N];
        for (int i = 0; i < N; i++) {
            items[i] = sc.nextInt();
        }

        for (int i = 0; i < r; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int length = sc.nextInt();

            lists.get(from).add(new Land(to, length));
            lists.get(to).add(new Land(from, length));
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            canGO = new HashSet<>();
            Arrays.fill(ch, Integer.MAX_VALUE);
            find(i, 0);
            int sum = 0;
            for (Integer go : canGO) {
                sum += items[go - 1];
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    private static void find(int start, int sum) {
        canGO.add(start);
        for (Land land : lists.get(start)) {
            if (sum + land.length < ch[land.to] && sum + land.length <= M ) {
                ch[land.to] = sum + land.length;
                find(land.to, sum + land.length);
            }
        }
    }

}
