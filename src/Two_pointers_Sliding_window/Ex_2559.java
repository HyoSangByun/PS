package Two_pointers_Sliding_window;

import java.util.Scanner;

public class Ex_2559 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int sum = 0;
            for (int j = i; j < i+K; j++) {
                sum += arr[j];
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

}
