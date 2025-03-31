package DFS_BFS_Utilization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_08_12 { //토마토 !틀림

    static int n, m , answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static  ArrayList<Point> list;

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int BFS(){
        Queue<Point> Q = new LinkedList<>();
        for (Point point : list) {
            Q.offer(new Point(point.x, point.y));
        }
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                }
            }
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //행
        m = sc.nextInt(); //열

        board = new int[m][n];

        list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int i1 = sc.nextInt();
                board[i][j] = i1;
                if (i1 == 1) list.add(new Point(i, j));
            }
        }

        System.out.println(BFS());
    }

}
