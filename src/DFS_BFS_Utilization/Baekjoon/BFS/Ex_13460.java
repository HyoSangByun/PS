package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_13460 {
    static class Point {
        private int rx, ry, bx, by, distance;
        public Point(int rx, int ry, int bx, int by, int distance) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.distance = distance;
        }
    }

    static int N, M, answer = -1;
    static char[][] map;
    static boolean[][][][] visited; // 빨간 구슬과 파란 구슬 각각의 위치를 함께 저장
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M][N][M]; // 방문 기록

        Point start = null;
        int holeX = 0, holeY = 0;

        sc.nextLine(); // 개행 처리
        int redX = -1, redY = -1, blueX = -1, blueY = -1; // 초기화된 구슬 좌표
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    redX = i;
                    redY = j;
                } else if (map[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                } else if (map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }

        start = new Point(redX, redY, blueX, blueY, 0); // 시작 상태 설정
        bfs(start, holeX, holeY);

        System.out.println(answer);
    }

    static void bfs(Point start, int holeX, int holeY) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(start);
        visited[start.rx][start.ry][start.bx][start.by] = true;

        while (!Q.isEmpty()) {
            Point cur = Q.poll();

            if (cur.distance > 10) return; // 10번 이내로 해결하지 못하면 -1

            // 빨간 구슬이 구멍에 들어갔고, 파란 구슬이 안 들어간 경우
            if (cur.rx == holeX && cur.ry == holeY && !(cur.bx == holeX && cur.by == holeY)) {
                answer = cur.distance;
                return;
            }

            for (int i = 0; i < 4; i++) { // 네 방향 탐색
                int redNx = cur.rx;
                int redNy = cur.ry;
                int blueNx = cur.bx;
                int blueNy = cur.by;

                // 빨간 구슬 이동
                while (map[redNx + dx[i]][redNy + dy[i]] != '#' && map[redNx][redNy] != 'O') {
                    redNx += dx[i];
                    redNy += dy[i];
                }

                // 파란 구슬 이동
                while (map[blueNx + dx[i]][blueNy + dy[i]] != '#' && map[blueNx][blueNy] != 'O') {
                    blueNx += dx[i];
                    blueNy += dy[i];
                }

                // 파란 구슬이 구멍에 빠지면 무효
                if (map[blueNx][blueNy] == 'O') continue;

                // 빨간 구슬과 파란 구슬이 겹치는 경우 처리
                if (redNx == blueNx && redNy == blueNy) {
                    if (Math.abs(redNx - cur.rx) + Math.abs(redNy - cur.ry) > Math.abs(blueNx - cur.bx) + Math.abs(blueNy - cur.by)) {
                        // 빨간 구슬이 더 멀리서 온 경우, 파란 구슬을 뒤로 이동
                        redNx -= dx[i];
                        redNy -= dy[i];
                    } else {
                        // 파란 구슬이 더 멀리서 온 경우, 빨간 구슬을 뒤로 이동
                        blueNx -= dx[i];
                        blueNy -= dy[i];
                    }
                }

                // 새로운 상태가 방문되지 않은 상태일 때만 큐에 넣음
                if (!visited[redNx][redNy][blueNx][blueNy]) {
                    visited[redNx][redNy][blueNx][blueNy] = true;
                    Q.offer(new Point(redNx, redNy, blueNx, blueNy, cur.distance + 1));
                }
            }
        }
    }
}
