package DFS_BFS_Utilization.Baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_13549 { //백준 13549
    static int N, K, answer;
    static int[] dx = {-1, 1 };

    static boolean[] ch;

    static class Position {
        public int position;
        public int time;

        public Position(int postion, int time) {
            this.position = postion;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        ch = new boolean[100001];

        BFS(new Position(N, 0));
        System.out.println(answer);
    }

    static void BFS(Position position) {
        Queue<Position> Q = new LinkedList<>();
        Q.offer(position);
        ch[position.position] = true; // 초기 위치 방문 체크

        while (!Q.isEmpty()) {
            Position pollPosition = Q.poll();
            int currentPosition = pollPosition.position;
            int currentTime = pollPosition.time;

            if (currentPosition == K) {
                answer = currentTime;
                return;
            }

            // 순간이동의 경우: 우선 처리
            int teleportPosition = currentPosition * 2;
            if (teleportPosition <= 100000 && !ch[teleportPosition]) {
                Q.offer(new Position(teleportPosition, currentTime));
                ch[teleportPosition] = true;
            }

            // 걷는 경우
            for (int i = 0; i < 2; i++) {
                int nextPosition = currentPosition + dx[i];
                if (nextPosition >= 0 && nextPosition <= 100000 && !ch[nextPosition]) {
                    Q.offer(new Position(nextPosition, currentTime + 1));
                    ch[nextPosition] = true;
                }
            }
        }
    }
}

/*
    순간이동의 경우를 걷는 경우의 수보다 우선적으로 처리해줘야함
 */