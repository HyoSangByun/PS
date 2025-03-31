package Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_2477 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        boolean[] ch = new boolean[6];

        int N = sc.nextInt();
        int width = 0;
        int height = 0;

        for (int i = 0; i < 6; i++) {
            int direction = sc.nextInt();
            int length = sc.nextInt();

            if (direction == 1 || direction == 2) {
                width = Math.max(width, length);
            }
            if (direction == 3 || direction == 4) {
                height = Math.max(height, length);
            }
            list.add(length);
        }

        for (int i = 0; i < list.size(); i++) {
            int left = (i - 1 + 6) % 6;
            int right = (i + 1 ) % 6;
            if (list.get(i) == height || list.get(i) == width) {
                ch[i] = true;
            }
            else if ((list.get(left) == height || list.get(left) == width)){
                ch[i] = true;
            }
            else if (list.get(right) == height || list.get(right) == width){
                ch[i] = true;
            }
        }

        int minus = 1;
        for (int i = 0; i < ch.length; i++) {
            if (!ch[i]) {
                minus *= list.get(i);
            }
        }

        System.out.println((width * height - minus) * N);

    }

}

/*
    제일 긴 변이랑 이어져 있는 얘 빼고 구하기

    서쪽이나 동쪽방향의 선분을 가로, 북쪽이나 남쪽방향의 선분을 세로로 생각
    1. 가장 긴 가로와 세로의 위치를 각각 구한다.
    1. 가장 긴 가로 옆에 위치한 두 세로의 길이 차이가 빈 사각형의 세로가 된다.
    1. 2번과 같은 원리로 가장 긴 세로 양 옆에 위치한 두 가로의 차이가 빈 사각형의 가로가 된다.
    1. 2~3의 과정으로 구한 결과로 빈 사각형의 넓이를 구하고 큰 사각형의 넓이에서 빼주고 * N

    이런 방법도 있음
 */