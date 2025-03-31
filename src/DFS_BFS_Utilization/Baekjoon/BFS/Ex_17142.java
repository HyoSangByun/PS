package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.*;

public class Ex_17142 {
    static class Virus {
        int x, y, time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, M, virusCount, answer = Integer.MAX_VALUE;
    static int[][] map;
    static List<Virus> virusList = new ArrayList<>();
    static boolean[] comb;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int originalEmpty = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); // 활성화할 바이러스의 수

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j, 0)); // 바이러스 위치 저장
                }
                if (map[i][j] == 0) {
                    originalEmpty++;
                }
            }
        }
        virusCount = virusList.size(); //바이러스의 갯수

        comb = new boolean[virusCount]; // 바이러스를 활성화할지 선택하기 위한 배열
        dfs(0, 0); // DFS 시작

        // 결과 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int L, int count) {
        if (count == M) { // M개의 바이러스를 선택한 경우
            spreadVirus(); // 바이러스 확산
            return;
        }

        if (L < virusCount) {
            comb[L] = true; // 현재 바이러스를 활성화
            dfs(L + 1, count + 1); // 다음 바이러스로 진행
            comb[L] = false; // 현재 바이러스를 비활성화
            dfs(L + 1, count); // 다음 바이러스로 진행
        }
    }

    private static void spreadVirus() {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] infected = new boolean[N][N];
        int emptySpaces = originalEmpty;

        // 선택된 바이러스를 큐에 추가
        for (int i = 0; i < virusCount; i++) {
            if (comb[i]) {
                Virus virus = virusList.get(i);
                infected[virus.x][virus.y] = true; // 비활성 바이러스를 감염 처리
                q.add(new Virus(virus.x, virus.y, 0)); // 시간을 0으로 설정
            }
        }

        // 빈 공간이 없는 경우 즉시 0을 반환
        if (emptySpaces == 0) {
            answer = 0; // 모든 빈 공간이 이미 감염된 경우
            return;
        }

        // BFS 시작
        int maxTime = 0; // 최대 시간이 얼마인지 기록

        while (!q.isEmpty()) {
            Virus virus = q.poll();

            // 현재 시간이 최대 시간보다 크면 갱신
            maxTime = Math.max(maxTime, virus.time);

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                // 범위 체크 및 감염 가능 여부 확인
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (infected[nx][ny] || map[nx][ny] == 1) continue;

                // 빈 공간을 감염시키는 경우
                if (map[nx][ny] == 0) {
                    emptySpaces--; // 빈 공간 수 감소
                }

                // 빈 공간이 모두 감염되면 결과를 업데이트
                if (emptySpaces == 0) {
                    answer = Math.min(answer, virus.time + 1);
                    return; // 모든 빈 공간이 감염되면 종료
                }

                infected[nx][ny] = true; // 감염 처리
                q.add(new Virus(nx, ny, virus.time + 1)); // 다음 바이러스 큐에 추가
            }
        }
    }
}

/*
    DFS로 조합 경우의 수를 구해서 BFS를 실행해주자
    로직의 흐름은 맞았다.

    하지만 처음에 M == 바이러스 총 갯수인 경우와
    비활성화된 바이러스 칸에 바이러스가 퍼지는 경우의 케이스도 생각해야 했다.
    그리고, 빈 공간이 모두 감염되었는지도 확인해야 한다.
 */