package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.*;

public class Ex_16234 { //백준 16234
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, L, R, answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] ch;

    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (true) {
            ch = new boolean[N][N];
            flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!ch[i][j]) {
                        moving(i, j);
                    }
                }
            }

            if (!flag) {
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }

    static void moving(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        List<Point> union = new ArrayList<>();

        Q.offer(new Point(x, y));
        union.add(new Point(x, y));
        ch[x][y] = true;

        int sum = board[x][y];

        while (!Q.isEmpty()) {
            Point p = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !ch[nx][ny]) {
                    int diff = Math.abs(board[p.x][p.y] - board[nx][ny]);
                    if (L <= diff && diff <= R) {
                        Q.offer(new Point(nx, ny));
                        union.add(new Point(nx, ny));
                        ch[nx][ny] = true;
                        sum += board[nx][ny];
                        flag = true;
                    }
                }
            }
        }

        int avg = sum / union.size();
        for (Point p : union) {
            board[p.x][p.y] = avg;
        }
    }
}
