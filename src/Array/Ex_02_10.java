package Array;

import java.util.Scanner;

public class Ex_02_10 { //봉우리
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 2][n + 2];

        for (int j = 0; j < n + 2; j++) {
            arr[0][j] = 0;
            arr[j][0] = 0;
            arr[n + 1][j] = 0;
            arr[j][n + 1] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count= 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if( (arr[i][j] > arr[i-1][j]) && (arr[i][j] > arr[i][j-1]) && (arr[i][j] > arr[i+1][j]) && (arr[i][j] > arr[i][j+1]) ) count++;
            }
        }
        System.out.println(count);
    }
}

/*
i , j, k 삼중 포문 안에서
int[] dx = [ -1, 0, 1, 0 ]
int[] dy = [0 , 1, 0, -1 ]
nx = i + dx[k]
ny = i + dy[k]
를 해서 상하좌우를 봄
 */