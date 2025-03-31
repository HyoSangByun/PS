package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_2667 { //백준 2667
    static int N, count, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static ArrayList<Integer> list = new ArrayList<>();
    static void DFS(int x, int y) {
        board[x][y]= 0;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 1) { //갈 수 있으면
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String next = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = next.charAt(j) - '0';
            }
        }

        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if( board[i][j] == 1 ) {
                    count = 0;
                    answer++;
                    DFS(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(answer);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
