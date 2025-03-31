package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.*;

public class Ex_16946 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] area; // 각 칸의 영역 번호를 저장할 배열
    static boolean[][] visited;
    static List<Integer> sizes = new ArrayList<>(); // 각 영역의 크기를 저장할 리스트
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        area = new int[N][M];
        sc.nextLine();

        // 이동할 수 있는 칸은 0, 벽은 1로 초기화
        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < nextLine.length(); j++) {
                int nextInt = nextLine.charAt(j) - '0';
                map[i][j] = nextInt;
            }
        }

        // BFS를 사용하여 각 영역의 크기를 구하고 메모이제이션
        int areaNum = 1; // 영역 번호는 1부터 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && area[i][j] == 0) { // 아직 방문하지 않은 0인 영역에 대해
                    int size = getAreaSize(i, j, areaNum); // BFS로 영역 크기 구하기
                    sizes.add(size); // 영역 크기 저장
                    areaNum++;
                }
            }
        }

        // 벽을 기준으로 상하좌우 0 영역의 크기를 합산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) { // 벽이면
                    System.out.print(smashingWall(i, j) % 10); // 벽을 부수고 이동할 수 있는 최대 크기 % 10
                } else {
                    System.out.print(0); // 빈 공간은 0 출력
                }
            }
            System.out.println();
        }
    }

    // BFS로 영역 크기를 구하고, 해당 영역에 번호를 매기기
    private static int getAreaSize(int x, int y, int areaNum) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        area[x][y] = areaNum; // 영역 번호를 메모이제이션
        int size = 1; // 현재 영역 크기

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && area[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    area[nx][ny] = areaNum; // 동일 영역 번호 할당
                    queue.offer(new Point(nx, ny));
                    size++; // 영역 크기 증가
                }
            }
        }

        return size; // 영역의 크기 반환
    }

    // 벽을 부수고 이동할 수 있는 최대 영역 크기 구하기
    private static int smashingWall(int x, int y) {
        Set<Integer> uniqueAreas = new HashSet<>(); // 중복 계산 방지를 위한 Set
        int totalSize = 1; // 벽이 있는 칸도 포함되므로 초기값은 1

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                int areaNum = area[nx][ny]; // 인접한 영역의 번호
                if (!uniqueAreas.contains(areaNum)) {
                    uniqueAreas.add(areaNum); // 중복된 영역은 추가하지 않음
                    totalSize += sizes.get(areaNum - 1); // 해당 영역 크기 더하기
                }
            }
        }

        return totalSize; // 총 이동할 수 있는 칸 수 반환
    }
}

/*
    설계 구상은 똑같음.
    하지만, 나는 영역 크기를 구하는 것과 영역을 나누는 걸 따로따로 해줘서 시간초과가 발생했었음.
 */