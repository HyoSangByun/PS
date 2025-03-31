package BackTracking;

import java.util.Scanner;

public class Ex_9663 {
    static int[] arr;
    static int N;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        nQueen(0);

        System.out.println(answer);
    }
    static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col]) return false;
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
