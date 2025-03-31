package greedy.baekjoon;

import java.util.Scanner;

public class Ex_06 { //백준 13305
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int nextCheapOil = 0;

        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = sc.nextInt();

        }

        int[] oils = new int[N];
        for (int i = 0; i < N; i++) {
            oils[i] = sc.nextInt();
        }

        // 1. 처음에 주유할 때 처음 주유소보다 싼 곳까지 갈 수 있을만큼만 주유한다
        int currentOilPay = oils[0];
        int sum = 0;
        int position = 0;

        while (true) {
            int moveDistance = 0;
            int nextPostion = findCheapOilCity(N, oils, currentOilPay, position);

            if (nextPostion > 0) {
                for (int i = position; i <= nextPostion - 1; i++) {
                    moveDistance += distance[i];
                }
                sum += currentOilPay * moveDistance;
            }
            if (position == 0 && nextPostion == -1) {
                for (int i = 0; i < distance.length; i++) {
                    moveDistance += distance[i];
                }
                sum = currentOilPay * moveDistance;
                break;
            } else if (position > 0 && nextPostion == -1) {
                for (int i = position; i < distance.length; i++) {
                    moveDistance += distance[i];
                }
                sum += currentOilPay * moveDistance;
                break;
            }


            currentOilPay = oils[nextPostion];
            position = nextPostion;

        }

        System.out.println(sum);
    }

    private static int findCheapOilCity(int N, int[] oils, int currentOilPay, int currentPosition) {
        for (int i = currentPosition + 1; i < N - 1; i++) {
            if (oils[i] < currentOilPay) return i;
        }
        return -1;
    }
}

/*
    1. 처음에 주유할 때 처음 주유소보다 싼 곳까지 갈 수 있을만큼만 주유한다
    2. 그리고 도착한 주유소보다 싼 곳이 있다면 그 곳 까지 갈 수 있을만큼만 주유한다
    2번을 반복
 */