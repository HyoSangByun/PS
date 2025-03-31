package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.*;

public class Ex_14502 { //백준 14502
    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static int N, M, max = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Point> combiList = new ArrayList<>(); //0인 포인트들을 담아둠
    static List<int[]> combinations = new ArrayList<>(); //컴비네이션 조합을 담아둠

    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nextInt = sc.nextInt();
                board[i][j] = nextInt;

                if (nextInt == 0) combiList.add(new Point(i, j));
            }
        }

        int[] array = new int[3];

        generateCombi(0,0, array);
        getAnswer();

        System.out.println(max);
    }

    static void generateCombi(int L, int start, int[] currentCombi) {
        if (L == 3) {
            combinations.add(currentCombi.clone());
            return;
        }

        for (int i = start; i < combiList.size(); i++) {
            currentCombi[L] = i;
            generateCombi(L + 1,i + 1, currentCombi);
        }
    }

    static void getAnswer() {

        for (int[] combination : combinations) {
            int[][] arr = board.clone(); // 얕은 복사이므로 각 요소 배열도 복제해야 함
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].clone();
            }

            Point point1 = combiList.get(combination[0]);
            Point point2 = combiList.get(combination[1]);
            Point point3 = combiList.get(combination[2]);

            arr[point1.x][point1.y] = 1;
            arr[point2.x][point2.y] = 1;
            arr[point3.x][point3.y] = 1;

            max = Math.max(simulateSpread(arr), max);

        }

    }

    private static int simulateSpread(int[][] arr) {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point pollPoint = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = pollPoint.x + dx[k];
                int ny = pollPoint.y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) count++;
            }
        }

        return count;
    }
}

/*
    1. 빈 공간 탐색: 모든 빈 공간을 탐색하여 벽을 세울 수 있는 위치를 찾습니다.
    2. 조합 생성: 빈 공간에서 3개를 선택하여 벽을 세울 수 있는 모든 조합을 생성합니다.
    3. 시뮬레이션: 각 조합에 대해 바이러스 확산 시뮬레이션을 수행하고 안전 영역을 계산합니다.
    4. 최대 안전 영역 기록: 안전 영역의 크기를 비교하여 최대 안전 영역을 기록합니다.
 */