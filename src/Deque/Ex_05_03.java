package Deque;

import java.util.Scanner;
import java.util.Stack;

public class Ex_05_03 { //크레인 인형뽑기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            if (PickUp(arr2[i], n, arr) != -1) {
                if ( !stack.isEmpty() && stack.peek() == arr[PickUp(arr2[i], n, arr)][arr2[i] - 1] ) {
                    stack.pop();
                    count++;
                } else {
                    stack.push(arr[PickUp(arr2[i], n, arr)][arr2[i] - 1]);
                }
                arr[PickUp(arr2[i], n, arr)][arr2[i] - 1] = 0; //뽑은 자리 0으로 처리
            }

        }

        System.out.println(count * 2);
    }

    public static Integer PickUp(int p, int n, int[][] arr) { //뽑은 인형의 열을 반환/ 행자리, 크기, 2차원 배열 입력
        int number = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i][p-1] != 0) {
                number = i;
                break;
            }
        }

        return number;
    }
}
