package DFS_BFS_Basic;

import java.util.Scanner;

public class Ex_07_08 { //송아지 찾기(BFS : 상태트리탐색)
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();

        BFS(E - S);
        System.out.println(count);
    }

    public static void BFS(int dis) {
        if (dis > 0) {
            if (dis >= 5) {
                count++;
                BFS(dis - 5);
            } else if (dis == 4) {
                count += 2;
            } else if ( dis == 3) {
                count += 3;
            } else if ( dis == 2) {
                count += 2;
            } else if ( dis == 1) {
                count ++;
            }
        } else if (dis < 0) {
            count = Math.abs(dis);
        }
    }

}

/*
    하지만 이 방식은 **BFS(너비 우선 탐색)**의 전형적인 구조와 다릅니다.
    BFS는 주로 큐를 사용해 모든 가능한 상태(노드)를 탐색하며 최단 경로를 찾는 알고리즘입니다.
    BFS는 너비를 우선적으로 탐색하여 최단 거리를 보장합니다.

    BFS는 최소 값을 구하는데 적용
 */