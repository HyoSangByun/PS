package DFS_BFS_Utilization;

import java.util.*;

public class Ex_08_15_02 { //피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)

    static int n, m;
    static List<Point> houses = new ArrayList<>();
    static List<Point> pizzaStores = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int[] comb;

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point house : houses) { //집마다 피자 가게의 최소거리를 구해서 더함
                int dist = Integer.MAX_VALUE;
                for (int i : comb) {
                    dist = Math.min(dist, distance(house, pizzaStores.get(i)));
                }
                sum += dist;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < pizzaStores.size(); i++) {
                comb[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static int distance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) houses.add(new Point(i, j));
                if (board[i][j] == 2) pizzaStores.add(new Point(i, j));
            }
        }

        comb = new int[m];
        DFS(0, 0);
        System.out.println(answer);
    }
}

/*
    집이 주체여야 함
    도시의 피자 배달 거리 = 각 집의 피자 배달 거리의 합
 */