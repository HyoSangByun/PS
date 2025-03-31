package Swea;

import java.util.Scanner;

public class Ex_1247 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static Point[] points;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        points = new Point[N + 2];
        visited = new boolean[N];

        for (int i = 0; i < N + 2; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points[i] = new Point(x, y);
        }

        dfs(0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int L, int prev, int cur, int distanceSum) {
        Point prevPoint = points[prev];
        Point curPoint = points[cur];
        int distance = getDistance(prevPoint, curPoint);
        distanceSum += distance;

        // 현재까지 누적한 거리가 이미 answer보다 크면 더 이상 탐색할 필요가 없음
        if (distanceSum >= answer) return;

        if (L == N ) {
            Point house = points[1];
            int lastDistance = getDistance(curPoint, house);
            answer = Math.min(answer, distanceSum + lastDistance);
            return;
        }

        for (int i = 2; i < points.length; i++) {
            if (!visited[i - 2]) {
                visited[i - 2] = true;
                dfs(L + 1, cur, i, distanceSum);
                visited[i - 2] = false;
            }
        }
    }

    private static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}

/*
    DFS를 활용한 순열로 풀 수 있는 문제였다.
    순열은 백트래킹으로 구현가능하다.
 */
