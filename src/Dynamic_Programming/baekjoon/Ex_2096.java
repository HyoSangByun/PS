package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] prevMax = new int[3]; // 이전 행의 최대값 저장
        int[] prevMin = new int[3]; // 이전 행의 최소값 저장
        int[] currMax = new int[3]; // 현재 행의 최대값 저장
        int[] currMin = new int[3]; // 현재 행의 최소값 저장

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            prevMax[i] = nextInt;
            prevMin[i] = nextInt;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int nextInt = sc.nextInt();
                if (j == 0) { // 왼쪽 끝
                    currMax[j] = Math.max(prevMax[0], prevMax[1]) + nextInt;
                    currMin[j] = Math.min(prevMin[0], prevMin[1]) + nextInt;
                } else if (j == 2) { // 오른쪽 끝
                    currMax[j] = Math.max(prevMax[1], prevMax[2]) + nextInt;
                    currMin[j] = Math.min(prevMin[1], prevMin[2]) + nextInt;
                } else { // 가운데
                    currMax[j] = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]) + nextInt;
                    currMin[j] = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]) + nextInt;
                }
            }
            // 현재 행이 다음 반복에서 이전 행이 되도록 갱신
            System.arraycopy(currMax, 0, prevMax, 0, 3);
            System.arraycopy(currMin, 0, prevMin, 0, 3);
        }

        // 마지막 행의 최댓값과 최솟값 찾기
        int max = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]);
        int min = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]);

        System.out.println(max + " " + min);
    }
}

/*
    메모리 초과
    문제를 해결하기 위해 굳이 전체 2차원 배열을 유지할 필요는 없습니다.
    현재 필요한 것은 현재 줄(i)과 그 이전 줄(i-1)만을 이용하는 방식이므로,
    배열을 2개의 1차원 배열로 줄일 수 있습니다.
 */