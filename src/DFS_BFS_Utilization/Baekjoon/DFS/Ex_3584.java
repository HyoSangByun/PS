package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_3584 {
    static int N;
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            lists = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                lists.add(new ArrayList<>());
            }

            for (int j = 0; j < N - 1; j++) {
                int a = sc.nextInt(); //부모
                int b = sc.nextInt(); //자식

                //자식 -> 부모로 이동해야하므로
                lists.get(b).add(a);
            }
            int a = sc.nextInt();
            int b = sc.nextInt();

            List<Integer> parents = new ArrayList<>();
            dfsA(a, parents);
            System.out.println(dfsB(b, parents));
        }
    }

    static void dfsA(int a, List<Integer> parents) {
        parents.add(a);

        if (!lists.get(a).isEmpty()) {
            dfsA(lists.get(a).get(0), parents);
        }
    }

    static int dfsB(int b, List<Integer> parents) {
        if (parents.contains(b)) {
            return b;
        }

        return dfsB(lists.get(b).get(0), parents);
    }
}
