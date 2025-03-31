package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_03 { //최대점수 구하기(DFS)
    static int N, time, max, answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        time = sc.nextInt();
        int[] score = new int[N];
        int[] timeCount = new int[N];

        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            timeCount[i] = sc.nextInt();
        }

        DFS(0,0,0,score,timeCount);
        System.out.println(max);
    }

    public static void DFS(int L, int timeSum, int scoreSum, int[] score, int[] timeCount) {
        if (timeSum > time ) {
            return;
        }
        if (L == N) {
            if (scoreSum > max) max = scoreSum;
        }else {
            if (scoreSum > max) max = scoreSum;
            DFS(L+1, timeSum + timeCount[L],scoreSum+score[L], score, timeCount); //원소 사용함
            DFS(L+1, timeSum , scoreSum, score, timeCount); // 원소 사용 X
        }
    }
}

/*
    각 원소를 부분집합에 넣는다 안넣는다로 나눔
 */