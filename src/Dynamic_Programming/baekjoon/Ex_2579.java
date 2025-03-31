package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_2579 { //백준 2579
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dy = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        dy[1] = arr[1];
        dy[2] = arr[1] + arr[2];
        dy[3] = Math.max(arr[1],arr[2]) + arr[3];

        for (int i = 4; i <= N; i++) {
            dy[i] = Math.max(dy[i - 3] + arr[i - 1], dy[i - 2]) + arr[i];
        }

        System.out.println(dy[N]);
    }
}

/*
    계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
    연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
    마지막 도착 계단은 반드시 밟아야 한다.

    dy에는 계단별로 얻을 수 있는 최대 점수를 기록하자

    세번째 계단부터는 방법이 1+1+1 은 안되고 1 + 2나 2 + 1이 되어야함
    1: 1
    2 : 1 + 1 or 2 / 1:2 or 2 1번
    3 : 1 + 2 or 2 + 1 밖에 안됨
    4 : 1 + 2 + 1 or 2 + 1 + 1 or 1 + 1 + 2 or 2 + 2

    n번째 계단을 밟는 방법은
    n-3을 밟고 n-1번 계단을 밟고 오는 경우와 n-2번을 밟고 오는 경우 2가지가 존재한다.
 */