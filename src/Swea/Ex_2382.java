package Swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ex_2382 {
    static class Virus {
        private int x;
        private int y;
        private int count;
        private int direction;

        public Virus(int x, int y, int count, int direction) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.direction = direction;
        }
    }

    static int N, M, K;
    static int[][] countMap;
    static List<Virus> list;

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            list = new ArrayList<>();
            countMap = new int[N][N];

            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int heads = sc.nextInt();
                int direction = sc.nextInt() - 1; // 상: 1, 하: 2, 좌: 3, 우: 4 → 배열 인덱스에 맞추기 위해 -1

                countMap[x][y]++;
                list.add(new Virus(x, y, heads, direction));
            }

            for (int j = 0; j < M; j++) {
                moving();   // 이동 처리
                checkMatch(); // 겹치는 바이러스 처리
            }

            int answer = 0;
            for (Virus virus : list) {
                answer += virus.count;
            }
            System.out.println(answer);
        }
    }

    // 바이러스 이동
    private static void moving() {
        int[][] newCountMap = new int[N][N];
        List<Virus> newList = new ArrayList<>();

        for (Virus virus : list) {
            int nx = virus.x + dx[virus.direction];
            int ny = virus.y + dy[virus.direction];

            // 경계에 도달했을 때
            if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
                virus.direction = changeDirection(virus.direction); // 방향 바꾸기
                virus.count /= 2; // 절반으로 줄이기
            }

            // 새 위치에 이동한 바이러스 정보 업데이트
            if (virus.count > 0) {
                newCountMap[nx][ny]++;
                newList.add(new Virus(nx, ny, virus.count, virus.direction));
            }
        }

        list = newList; // 새 리스트로 교체
        countMap = newCountMap;
    }

    // 방향 전환 함수
    private static int changeDirection(int direction) {
        if (direction == 0) return 1; // 상 -> 하
        if (direction == 1) return 0; // 하 -> 상
        if (direction == 2) return 3; // 좌 -> 우
        return 2; // 우 -> 좌
    }

    // 겹치는 바이러스 처리
    private static void checkMatch() {
        List<Virus> newList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (countMap[i][j] > 1) { // 겹치는 경우
                    int maxCount = 0;
                    int totalCount = 0;
                    int newDirection = 0;

                    for (Virus virus : list) {
                        if (virus.x == i && virus.y == j) {
                            totalCount += virus.count;
                            if (virus.count > maxCount) {
                                maxCount = virus.count;
                                newDirection = virus.direction;
                            }
                        }
                    }

                    newList.add(new Virus(i, j, totalCount, newDirection)); // 최종 합산 후 추가
                } else if (countMap[i][j] == 1) {
                    for (Virus virus : list) {
                        if (virus.x == i && virus.y == j) {
                            newList.add(virus); // 겹치지 않으면 그대로 유지
                        }
                    }
                }
            }
        }

        list = newList; // 리스트 업데이트
    }
}

/*
    먼저 이동시키고 -> 이동시킬 떄마다 원래 칸은 흔적 지우고 갈 곳은 없앤다.
    감소시킴
    겹치는게 있는지 확인 -> int배열에 개체수 저장

 */