package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_2239 {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map = new int[9][9]; // 스도쿠 판
    static List<Point> emptyCells = new ArrayList<>(); // 빈칸 좌표 리스트
    static boolean foundAnswer = false; // 정답을 찾았는지 여부
    static String answer = null; // 사전식으로 가장 작은 정답

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            String line = sc.next();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 0) {
                    emptyCells.add(new Point(i, j)); // 빈칸 저장
                }
            }
        }
        sc.close();

        dfs(0);

        int index = 0;
        StringBuilder answerOut = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                answerOut.append(answer.charAt(index++));
            }
            answerOut.append("\n");
        }
        System.out.println(answerOut.toString());
    }

    private static void dfs(int depth) {
        // 종료 조건: 모든 빈칸이 채워진 경우
        if (depth == emptyCells.size()) {
            StringBuilder sb = new StringBuilder();
            for (int[] row : map) {
                for (int num : row) {
                    sb.append(num);
                }
            }
            String currentResult = sb.toString();

            // 가장 작은 답으로 갱신
            if (answer == null || currentResult.compareTo(answer) < 0) {
                answer = currentResult;
            }
            foundAnswer = true;
            return;
        }

        // 현재 처리 중인 빈칸
        Point current = emptyCells.get(depth);

        // 가능한 숫자 구하기
        List<Integer> possibleNumbers = getPossibleNum(current);

        for (int num : possibleNumbers) {
            map[current.x][current.y] = num; // 숫자 넣기
            dfs(depth + 1); // 다음 빈칸 처리
            if (foundAnswer) return; // 사전식으로 가장 작은 답을 찾았으므로 중단
            map[current.x][current.y] = 0; // 되돌리기
        }
    }

    private static List<Integer> getPossibleNum(Point point) {
        boolean[] used = new boolean[10]; // 1~9 숫자의 사용 여부
        List<Integer> result = new ArrayList<>();

        // 가로, 세로 확인
        for (int i = 0; i < 9; i++) {
            if (map[point.x][i] != 0) used[map[point.x][i]] = true; // 가로
            if (map[i][point.y] != 0) used[map[i][point.y]] = true; // 세로
        }

        // 3×3 박스 확인
        int startX = (point.x / 3) * 3;
        int startY = (point.y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] != 0) used[map[i][j]] = true;
            }
        }

        // 사용되지 않은 숫자 추가
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) result.add(i);
        }

        return result;
    }

}

/*
    1~9 숫자로 넣을 수 있는 칸을 찾아서 넣음 - 백트래킹?
 */