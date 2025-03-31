package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_15686 {
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
    static int[] distances;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nextInt = sc.nextInt();
                if (nextInt == 1) houses.add(new Point(i, j));
                if (nextInt == 2) chickens.add(new Point(i, j));
                map[i][j] = nextInt;
            }
        }

        distances = new int[chickens.size()];
        for (int i = 0; i < chickens.size(); i++) {
            getDistance(i, chickens.get(i));
        }

        removeChicken();

        int sum = 0;
        for (Point house : houses) {
            int ans = Integer.MAX_VALUE;
            for (Point chicken : chickens) {
                int houseDistance = 0;
                houseDistance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                ans = Math.min(ans, houseDistance);
            }
            sum += ans;
        }

        System.out.println(sum);
    }

    private static void getDistance(int index, Point chicken) {
        int sum = 0;
        for (Point house : houses) {
            sum += Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
        }
        distances[index] = sum;
    }

    private static void removeChicken() {
        while (true) {
            if (chickens.size() == M) break;
            int index = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < distances.length; i++) {
                if (max < distances[i]) {
                    index = i;
                    max = distances[i];
                }
            }
            chickens.remove(index);
        }
    }
}

/*
    치킨집마다 집까지의 거리를 구한뒤
    가장 긴 순서대로 치킨 집 제거 후
    도시의 치킨 거리를 구함


 */