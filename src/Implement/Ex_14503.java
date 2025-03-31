package Implement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_14503 {
    static class Cleaner {
        private int x;
        private int y;
        private int direction;

        public Cleaner(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] cleaned;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0}; //북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int D = sc.nextInt();

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs(new Cleaner(startX, startY, D));
        System.out.println(answer);
    }

    private static void bfs(Cleaner start) {
        Queue<Cleaner> Q = new LinkedList<>();
        Q.offer(start);

        while (!Q.isEmpty()) {
            Cleaner poll = Q.poll();
            int direction = poll.direction;

            // 현재 칸을 청소
            if (map[poll.x][poll.y] == 0 && !cleaned[poll.x][poll.y]) {
                cleaned[poll.x][poll.y] = true;
                answer++;
            }

            boolean flag = false;
            // 주변 칸 탐색
            for (int i = 0; i < 4; i++) {
                // 반시계 방향으로 회전
                direction = (direction + 3) % 4; // 회전 후 방향 업데이트
                int nx = poll.x + dx[direction];
                int ny = poll.y + dy[direction];

                // 청소하지 않은 빈 칸인 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !cleaned[nx][ny] && map[nx][ny] == 0) {
                    Q.offer(new Cleaner(nx, ny, direction)); // 전진
                    flag = true;
                    break;
                }
            }

            // 모든 방향을 탐색했으나 청소할 칸이 없는 경우
            if (!flag) {
                // 후진할 수 있는지 확인
                int backDir = (poll.direction + 2) % 4; // 현재 방향의 반대 방향
                int backX = poll.x + dx[backDir];
                int backY = poll.y + dy[backDir];

                // 후진 가능한 경우에만 후진
                if (backX >= 0 && backX < N && backY >= 0 && backY < M && map[backX][backY] == 0) {
                    Q.offer(new Cleaner(backX, backY, poll.direction)); // 방향 유지
                } else {
                    // 후진할 수 없으면 종료
                    break;
                }
            }
        }
    }
}

/*

 */