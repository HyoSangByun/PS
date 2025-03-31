package greedy;

import java.util.Scanner;

public class Ex_09_07 { ////친구인가? (Disjoint-Set : Union&Find)
    static int[] unf;

    static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        int fa = Find(a);
        int fb = Find(b);

        if ( fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}

/*
    서로소 집합 - 공통 원소가 없는 집합

    union함수와 find함수는 외워두자!
 */