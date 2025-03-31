package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dy = new int[N];
        dy[0] = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 1;
        for (int i = 1; i < N; i++) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) count = Math.max(count, dy[j]);
            }
            dy[i] = count + 1;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}
