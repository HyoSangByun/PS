package Implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_21608 {

    static class Point implements Comparable<Point> {

        private int x;

        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    static int N;
    static List<List<Integer>> list = new ArrayList<>();
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i <= N * N; i++) {
            list.add(new ArrayList<>());
        }

        int[] studentOrder = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            int student = sc.nextInt();
            studentOrder[i] = student;
            for (int j = 0; j < 4; j++) {
                int nextInt = sc.nextInt();
                list.get(student).add(nextInt);
            }
        }

        map = new int[N][N];
        // 자리 찾기
        for (int i = 0; i < N * N; i++) {
            find(studentOrder[i]);
        }

        //만족도 조사
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = map[i][j];
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && list.get(student)
                        .contains(map[nx][ny])) {
                        count++;
                    }
                }

                if (count == 1) {
                    sum += 1;
                } else if (count == 2) {
                    sum += 10;
                } else if (count == 3) {
                    sum += 100;
                } else if (count == 4) {
                    sum += 1000;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println();
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//        }
//        System.out.println();
        System.out.println(sum);
    }

    private static void find(int student) {
        //비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        List<Integer> loveList = list.get(student);
        List<Point> candidates = new ArrayList<>();

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                if (map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && loveList.contains(map[nx][ny])) {
                            count++;
                        }
                    }

                    if (count == max) {
                        candidates.add(new Point(i, j));
                    } else if (count > max) {
                        max = count;
                        candidates.clear();
                        candidates.add(new Point(i, j));
                    }
                }
            }
        }
        //1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        if (candidates.size() > 1) {
            candidates = process2(candidates);
        }
        Point chosenSeat = candidates.get(0);
        map[chosenSeat.x][chosenSeat.y] = student;
    }

    private static List<Point> process2(List<Point> candidates) {
        List<Point> bestOptions = new ArrayList<>();
        int max2 = -1;

        for (Point point : candidates) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                    count++;
                }
            }
            if (count == max2) {
                bestOptions.add(point);
            } else if (count > max2) {
                max2 = count;
                bestOptions.clear();
                bestOptions.add(point);
            }
        }
        Collections.sort(bestOptions);
        return bestOptions;
    }
}