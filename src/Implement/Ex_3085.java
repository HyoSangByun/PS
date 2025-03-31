package Implement;

import java.util.Scanner;

public class Ex_3085 {

    private static int answer = 1;
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            for (int j = 0; j < nextLine.length(); j++) {
                map[i][j] = nextLine.charAt(j) - 'A';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny>= 0 && ny < N && map[i][j] != map[nx][ny]) {
                        int[][] map2 = new int[N][N];

                        for (int l = 0; l < map.length; l++) {
                            map2[l] = map[l].clone();
                        }

                        int tmp = map2[i][j];
                        map2[i][j] = map2[nx][ny];
                        map2[nx][ny] = tmp;

                        getMaxLength(map2);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void getMaxLength(int[][] arr) {

        for (int i = 0; i < N; i++) {
            int row_max = 1;
            int row_current_color = -1;

            int col_max = 1;
            int col_current_color = -1;

            for (int j = 0; j < N; j++) {
                if (arr[i][j] == row_current_color) {
                    row_max++;
                    answer = Math.max(answer, row_max);
                }
                else if(arr[i][j] != row_current_color){
                    row_current_color = arr[i][j];
                    row_max = 1;
                }

                if (arr[j][i] == col_current_color) {
                    col_max++;
                    answer = Math.max(answer, col_max);
                }
                else if(arr[j][i] != col_current_color) {
                    col_current_color = arr[j][i];
                    col_max = 1;
                }
            }
        }
    }

}
