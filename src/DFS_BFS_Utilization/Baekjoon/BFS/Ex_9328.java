package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.*;

public class Ex_9328 {
    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, answer;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys; // 열쇠를 가지고 있는지 여부를 나타냄
    static List<Point>[] doors; // 문 앞에서 대기하고 있는 좌표
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();

            // 맵 크기를 위아래로 2칸씩 더 크게 만듦
            map = new char[N + 2][M + 2];
            visited = new boolean[N + 2][M + 2];
            keys = new boolean[26]; // a-z 열쇠 여부
            doors = new ArrayList[26]; // A-Z 문 대기 좌표

            for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }

            // 지도 입력 (가장자리는 빈칸 처리)
            for (int i = 1; i <= N; i++) {
                String line = sc.nextLine();
                for (int j = 1; j <= M; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            // 외곽(바깥 테두리)을 모두 빈칸 처리
            for (int i = 0; i < N + 2; i++) {
                map[i][0] = '.';
                map[i][M + 1] = '.';
            }
            for (int j = 0; j < M + 2; j++) {
                map[0][j] = '.';
                map[N + 1][j] = '.';
            }

            // 이미 가지고 있는 열쇠 입력
            String keyInput = sc.nextLine();
            if (!keyInput.equals("0")) {
                for (int i = 0; i < keyInput.length(); i++) {
                    keys[keyInput.charAt(i) - 'a'] = true; // 열쇠 등록
                }
            }

            answer = 0;
            bfs(); // 탐색 시작
            System.out.println(answer);
        }
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[N + 2][M + 2];

        // 외곽(0번째, N+1번째 행과 열)에 빈 공간이므로 외곽에서 출발 가능
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < N + 2 && ny >= 0 && ny < M + 2 && !visited[nx][ny] && map[nx][ny] != '*') {
                    char current = map[nx][ny];
                    visited[nx][ny] = true;

                    if (current == '.') {
                        queue.offer(new Point(nx, ny));
                    } else if (current == '$') { // 문서를 발견
                        answer++;
                        queue.offer(new Point(nx, ny));
                    } else if (Character.isLowerCase(current)) { // 열쇠를 발견
                        keys[current - 'a'] = true; // 열쇠 획득
                        queue.offer(new Point(nx, ny));
                        // 새로운 열쇠로 이전에 막힌 문들을 열 수 있음
                        while (!doors[current - 'a'].isEmpty()) {
                            queue.offer(doors[current - 'a'].remove(0));
                        }
                    } else if (Character.isUpperCase(current)) { // 문을 발견
                        if (keys[current - 'A']) { // 열쇠가 있으면 문 통과
                            queue.offer(new Point(nx, ny));
                        } else { // 열쇠가 없으면 대기
                            doors[current - 'A'].add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
    }
}

/*
    열쇠가 없는 문을 방문하면 문 좌표를 리스트에 저장했다가
    나중에 열쇠를 얻으면 큐에 문 좌표를 모두 넣어주는 방식은 생각지 못한 방식이었음.
 */