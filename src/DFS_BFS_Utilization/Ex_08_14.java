package DFS_BFS_Utilization;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_08_14 { //섬나라 아일랜드 (BFS)

    static int n;
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[][] board;
    static int answer;

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y] = 0;
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { //갈 수 있음
                    board[nx][ny] = 0;
                    Q.offer(new Point(nx, ny));
                }

            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    BFS(i,j);
                }
            }
        }

        System.out.println(answer);
    }

}
