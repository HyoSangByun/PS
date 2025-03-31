package Implement;

import java.util.Scanner;

public class Ex_2615 {
    static int[][] map = new int[19][19];
    // 우, 우하, 하, 좌하 4방향만 확인
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean flag = false;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        if (check(i, j, map[i][j], k)) {
                            flag = true;
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        if (!flag) System.out.println(0);
    }

    private static boolean check(int x, int y, int color, int direction) {
        int count = 1;

        // 해당 방향으로 연속된 바둑알 세기
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        while (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && map[nx][ny] == color) {
            count++;
            nx += dx[direction];
            ny += dy[direction];
        }

        // 반대 방향으로도 탐색하여 중복 검사 방지
        nx = x - dx[direction];
        ny = y - dy[direction];
        while (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && map[nx][ny] == color) {
            count++;
            nx -= dx[direction];
            ny -= dy[direction];
        }

        // 정확히 5개의 돌만 연속되었는지 확인
        if (count == 5) {
            // 이전 좌표와 다음 좌표 확인 (여섯 개가 아닌지 확인)
            int prevX = x - dx[direction];
            int prevY = y - dy[direction];
            int nextX = x + 5 * dx[direction];
            int nextY = y + 5 * dy[direction];

            if (prevX >= 0 && prevY >= 0 && prevX < 19 && prevY < 19 && map[prevX][prevY] == color) {
                return false; // 여섯 개 이상의 돌이 있는 경우
            }

            if (nextX >= 0 && nextY >= 0 && nextX < 19 && nextY < 19 && map[nextX][nextY] == color) {
                return false; // 여섯 개 이상의 돌이 있는 경우
            }

            return true;
        }

        return false;
    }
}


