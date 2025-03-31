package Implement;

import java.util.Scanner;

public class Ex_18111 {
    static int N, M, B;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        B = sc.nextInt();

        map = new int[N][M];
        int[] blockCount = new int[257]; // 높이 0부터 256까지의 블록 수

        int totalBlocks = 0; // 전체 블록 수

        // 땅의 높이를 입력받고 각 높이에 대한 블록 수를 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int height = sc.nextInt();
                map[i][j] = height;
                blockCount[height]++;
                totalBlocks++;
            }
        }

        int ansHeight = 0;
        int ansTime = Integer.MAX_VALUE;

        // 모든 가능한 높이에 대해 계산
        for (int i = 0; i <= 256; i++) {
            int time = 0;
            int blocks = B; // 인벤토리 블록 수

            // 현재 높이 i에 맞추기 위한 시간 계산
            for (int h = 0; h <= 256; h++) {
                if (h > i) { // 현재 높이보다 높은 경우
                    int count = blockCount[h]; // 해당 높이의 블록 수
                    time += (h - i) * count * 2; // 블록 제거는 2초
                    blocks += count * (h - i); // 인벤토리에 추가
                } else if (h < i) { // 현재 높이보다 낮은 경우
                    int count = blockCount[h]; // 해당 높이의 블록 수
                    time += (i - h) * count; // 블록 추가는 1초
                    blocks -= count * (i - h); // 인벤토리에서 빼야 하므로 감소
                }
            }

            // 블록 수가 음수인 경우는 불가능
            if (blocks < 0) continue;

            // 최소 시간 업데이트
            if (ansTime > time) {
                ansTime = time;
                ansHeight = i;
            } else if (ansTime == time && ansHeight < i) {
                ansHeight = i; // 높이가 높은 경우 선택
            }
        }

        System.out.println(ansTime + " " + ansHeight);
    }
}

/*
    땅을 파야하는 경우면 그냥 파면됨.
    땅을 올려야하는 경우 인벤토리에 없다면 먼저 파야함.
    인벤토리에 있다면 올리면 됨.
 */