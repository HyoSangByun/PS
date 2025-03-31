package DFS_BFS_Utilization;

import java.util.*;

public class Ex_08_15 { //피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)

    static int n, max = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer;

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int distance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void DFS(int x, int y, int[][] dis){
        if (board[x][y] == 1) max = Math.max(max, dis[x][y]);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != 3) { // 갈수 있음
                int i1 = board[x][y];
                board[x][y] = 3;
                dis[nx][ny] = dis[x][y] + distance(new Point(x, y), new Point(nx, ny));
                DFS(nx, ny, dis);


                board[x][y] = i1;
            }

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) { //피자 가게마다 집까지의 최대 배달거리 구함
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    int[][] arr = new int[n][n];
                    max = 0;
                    DFS(i,j,arr);
                    map.put(new Point(i, j), max);
                }
            }
        }
//        for (Point point : map.keySet()) {
//            System.out.println(point.x + " " + point.y);
//        }

//        for (Map.Entry<Point, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getValue());
//        }

        max = 0;

        for (int i = 0; i < m; i++) {
            Point key = null;
            for (Map.Entry<Point, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            map.remove(key);
        }

        max = 0;
        for (Integer value : map.values()) {
            if (value > max) max = value;
        }

        System.out.println(max);
    }

}

/*
    집이 주체여야 함
    도시의 피자 배달 거리 = 각 집의 피자 배달 거리의 합
 */