package Dynamic_Programming;

import java.util.Scanner;

public class Ex_10_03 { //최대 부분 증가 수열(LIS)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dy = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dy[0] = 1;
        int answer = 0;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}

/*
    LIS (최장 증가 부분 수열)**는 주어진 배열에서 순서대로 증가하는 가장 긴 부분 수열을 찾는 문제입니다.
    부분 수열은 원소들이 배열 내에서 순서를 유지하면서 일부 원소를 선택하는 것이므로, 연속되지 않아도 됩니다.
 */

/*
    강의 문제 풀이 방식은 arr[i]가 마지막 원소로서의 최대 순열 길이를 dy[i]에 기록해둠
 */