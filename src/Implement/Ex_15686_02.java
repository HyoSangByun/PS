package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_15686_02 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static List<Point> chickens = new ArrayList<>();
    static List<Point> houses = new ArrayList<>();
    static int[][] map;
    static Point[] choosen;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { // M이 아닌 N으로 수정
                int nextInt = sc.nextInt();
                if (nextInt == 1) houses.add(new Point(i, j));
                if (nextInt == 2) chickens.add(new Point(i, j));
                map[i][j] = nextInt;
            }
        }

        choosen = new Point[M];
        getCombi(0, 0);
        System.out.println(answer);
    }

    private static void getCombi(int L, int start) {
        if (L == M) {
            getDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            choosen[L] = chickens.get(i);
            getCombi(L + 1, i + 1); // 수정된 부분
        }
    }

    private static void getDistance() {
        int sum = 0;
        for (Point house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (Point chicken : choosen) {
                int distance = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
                minDistance = Math.min(distance, minDistance);
            }
            sum += minDistance;
        }
        answer = Math.min(answer, sum);
    }
}

/*
    치킨집마다 집까지의 거리를 구한뒤
    가장 긴 순서대로 치킨 집 제거 후
    도시의 치킨 거리를 구함


 */