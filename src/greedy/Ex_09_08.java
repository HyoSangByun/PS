package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_09_08 { //원더랜드 (최소 스패닝 트리 - '크루스칼' : Union & Find 이용)
    static int[] unf;

    static class Edge implements Comparable<Edge> {
        private int v1;
        private int v2;
        private int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

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
        ArrayList<Edge> arr = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a, b, c));
        }

        int answer = 0;
        Collections.sort(arr);

        for (Edge ob : arr) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);

            if (fv1 != fv2) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);
    }
}

/*
    가중치 값이 최소가 되도록 트리를 뽑아내는 것을 최소스패닝트리라 한다.
    트리는 정점이 n개면 간선은 n-1개다

    코스가 적은 순서대로 edge 선택
    그런데 선택한 edge의 정점이 이미 집합에 속해있다면? 뽑지 않음!
    뽑은 것들은 union 시켜줌
 */