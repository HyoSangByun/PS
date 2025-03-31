package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.*;

public class Ex_16236 { //이 문제는 봐도 모르겠음
    static class Shark {
        int x, y, size, eaten, distance;

        public Shark(int x, int y, int size, int eaten, int distance) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eaten = eaten;
            this.distance = distance;
        }
    }

    static int N, sum, answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};  // 상좌하우
    static int[] dy = {0, -1, 0, 1};  // 상좌하우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        Shark shark = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0, 0);
                    map[i][j] = 0;  // 상어의 위치를 빈칸으로 바꿈
                }
            }
        }

        bfs(shark);
        System.out.println(answer);
    }

    private static void bfs(Shark shark) {
        while (true) {
            PriorityQueue<Shark> pq = new PriorityQueue<>((a, b) -> {
                if (a.distance == b.distance) {
                    if (a.x == b.x) return a.y - b.y;  // y 좌표가 작은 것 우선
                    return a.x - b.x;  // x 좌표가 작은 것 우선
                }
                return a.distance - b.distance;  // 거리 우선
            });

            boolean[][] visited = new boolean[N][N];
            Queue<Shark> q = new LinkedList<>();
            q.offer(new Shark(shark.x, shark.y, shark.size, shark.eaten, 0));
            visited[shark.x][shark.y] = true;

            boolean found = false;

            while (!q.isEmpty()) {
                Shark cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;

                        // 상어가 이동 가능한 경우
                        if (map[nx][ny] <= cur.size) {
                            q.offer(new Shark(nx, ny, cur.size, cur.eaten, cur.distance + 1));

                            // 먹을 수 있는 물고기 발견
                            if (map[nx][ny] > 0 && map[nx][ny] < cur.size) {
                                pq.offer(new Shark(nx, ny, cur.size, cur.eaten + 1, cur.distance + 1));
                                found = true;
                            }
                        }
                    }
                }
            }

            if (!found) return;  // 먹을 수 있는 물고기가 없으면 종료

            // 가장 가까운 물고기 선택
            Shark next = pq.poll();
            answer += next.distance;
            shark.x = next.x;
            shark.y = next.y;
            shark.eaten = next.eaten;

            map[next.x][next.y] = 0;  // 물고기를 먹은 위치는 빈칸으로

            // 상어가 크기만큼 물고기를 먹었으면 크기 증가
            if (shark.eaten == shark.size) {
                shark.size++;
                shark.eaten = 0;
            }
        }
    }
}

/*
    1. 아기 상어의 크기

- 초기값 : 2

- 크기의 수만큼 물고기를 잡아먹으면 크기 1 증가

  - 즉, 초기값이 2니까 물고기 두마리를 잡아먹었을 때 3이 되고

  - 이후, 3마리를 더 잡아먹어야 크기가 4가 되는 느낌

2. 우선순위가 높은 상어 탐색

- 우선순위 큐나 정렬을 써야 한다 뭐 이런 후기가 있는데,

- i=0~N, j=0~N까지 순차 탐색하면서 0이상 상어의 크기 미만인 물고기 중 거리가 가장 짧은 물고기를 bfs로 선택해주면 됨.
 */